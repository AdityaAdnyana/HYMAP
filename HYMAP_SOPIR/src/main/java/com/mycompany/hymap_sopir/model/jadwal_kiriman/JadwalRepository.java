package com.mycompany.hymap_sopir.model.jadwal_kiriman;

import com.mycompany.hymap_sopir.config.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class JadwalRepository {

    private java.sql.Date toSqlDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return new java.sql.Date(cal.getTimeInMillis());
    }

    public List<PelangganKiriman> getJadwalByDate(String armada, Date date) {
        List<PelangganKiriman> list = new ArrayList<>();
        java.sql.Date sqlDate = toSqlDate(date);

        // SQL: Mengambil status dari tabel pengiriman khusus untuk tanggal yang dipilih
        String sql = "SELECT p.id, p.nama, p.alamat, " +
                     "COALESCE(k.status, 'Belum Terkirim') AS status_harian " +
                     "FROM pelanggan p " +
                     "LEFT JOIN pengiriman k ON p.id = k.pelanggan_id AND k.tanggal_pengiriman = ? " +
                     "WHERE p.daerah_kiriman = ? " +
                     "AND ? >= p.tgl_mulai_rentang " +
                     "AND DATEDIFF(?, p.tgl_mulai_rentang) % p.rentang_pengiriman = 0";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setDate(1, sqlDate);
            pstmt.setString(2, armada);
            pstmt.setDate(3, sqlDate);
            pstmt.setDate(4, sqlDate);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new PelangganKiriman(
                        rs.getInt("id"), 
                        rs.getString("nama"), 
                        rs.getString("alamat"), 
                        rs.getString("status_harian")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean updateStatusPengiriman(int pelangganId, Date date, String newStatus) {
        java.sql.Date sqlDate = toSqlDate(date);
        
        // Memerlukan UNIQUE INDEX (pelanggan_id, tanggal_pengiriman) di database agar bekerja
        String sql = "INSERT INTO pengiriman (pelanggan_id, tanggal_pengiriman, status) VALUES (?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE status = VALUES(status)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, pelangganId);
            pstmt.setDate(2, sqlDate);
            pstmt.setString(3, newStatus);
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}