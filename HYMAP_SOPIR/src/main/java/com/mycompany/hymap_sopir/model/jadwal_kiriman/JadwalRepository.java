package com.mycompany.hymap_sopir.model.jadwal_kiriman;

import com.mycompany.hymap_sopir.config.DatabaseConnection;
import com.mycompany.hymap_sopir.model.jadwal_kiriman.PelangganKiriman;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JadwalRepository {

    public List<PelangganKiriman> getJadwalByDate(String armada, Date date) {
        List<PelangganKiriman> list = new ArrayList<>();
        java.sql.Date selectedDateSql = new java.sql.Date(date.getTime());

        String sql = "SELECT p.id, p.nama, p.alamat, p.status_pengiriman AS status " +
                     "FROM pelanggan p " +
                     "WHERE p.daerah_kiriman = ? " +
                     "AND ? >= p.tgl_mulai_rentang " +
                     "AND p.rentang_pengiriman > 0 " +
                     "AND DATEDIFF(?, p.tgl_mulai_rentang) % p.rentang_pengiriman = 0";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, armada);
            pstmt.setDate(2, selectedDateSql);
            pstmt.setDate(3, selectedDateSql);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new PelangganKiriman(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("alamat"),
                        rs.getString("status")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean updateStatusPengiriman(int pelangganId, String newStatus) {
        String sql = "UPDATE pelanggan SET status_pengiriman = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, newStatus);
            pstmt.setInt(2, pelangganId);
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}