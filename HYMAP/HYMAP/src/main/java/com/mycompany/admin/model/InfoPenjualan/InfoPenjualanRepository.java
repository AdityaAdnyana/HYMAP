package com.mycompany.admin.model.InfoPenjualan;

import com.mycompany.admin.config.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class InfoPenjualanRepository implements IInfoPenjualanRepository {

    // Helper method untuk normalisasi tanggal ke 00:00:00
    private java.sql.Date toSqlDate(Date date) {
        if (date == null) return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return new java.sql.Date(cal.getTimeInMillis());
    }

    @Override
    public List<LaporanPenjualan> getLaporanByDate(Date date) {
        List<LaporanPenjualan> list = new ArrayList<>();
        java.sql.Date sqlDate = toSqlDate(date != null ? date : new Date());

      
        String sql = "SELECT p.id, p.nama, p.alamat, p.jumlah_galon, p.harga_per_galon, " +
                     "(p.jumlah_galon * p.harga_per_galon) AS total_harga, " +
                     "COALESCE(k.status, 'Belum Terkirim') AS status_pengiriman, " +
                     "COALESCE(k.status_pembayaran, 'bon') AS status_pembayaran " +
                     "FROM pelanggan p " +
                     "LEFT JOIN pengiriman k ON p.id = k.pelanggan_id AND k.tanggal_pengiriman = ? " +
                     "WHERE ? >= p.tgl_mulai_rentang AND p.rentang_pengiriman > 0 " +
                     "AND DATEDIFF(?, p.tgl_mulai_rentang) % p.rentang_pengiriman = 0 " +
                     "ORDER BY p.nama ASC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setDate(1, sqlDate);
            pstmt.setDate(2, sqlDate);
            pstmt.setDate(3, sqlDate);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new LaporanPenjualan(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("alamat"),
                        rs.getInt("jumlah_galon"),
                        rs.getDouble("harga_per_galon"),
                        rs.getDouble("total_harga"),
                        rs.getString("status_pengiriman"),
                        rs.getString("status_pembayaran"),
                        sqlDate 
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean updateStatus(int id, Date date, String statusPengiriman, String statusPembayaran) {
        java.sql.Date sqlDate = toSqlDate(date);
        
        
        String sql = "INSERT INTO pengiriman (pelanggan_id, tanggal_pengiriman, status, status_pembayaran) " +
                     "VALUES (?, ?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE status = VALUES(status), status_pembayaran = VALUES(status_pembayaran)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.setDate(2, sqlDate);
            pstmt.setString(3, statusPengiriman);
            pstmt.setString(4, statusPembayaran);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}