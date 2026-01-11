/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.model.InfoPenjualan;

import com.mycompany.admin.config.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author R9480
 */
public class InfoPenjualanRepository implements IInfoPenjualanRepository {

    @Override
    public List<LaporanPenjualan> getLaporanByDate(java.util.Date date) {
        List<LaporanPenjualan> list = new ArrayList<>();
        
        // Logika query filter tanggal (sama seperti kode asli Anda)
        String sql;
        if (date == null) {
            sql = "SELECT id, nama, alamat, jumlah_galon, harga_per_galon, " +
                  "(jumlah_galon * harga_per_galon) AS total_harga, " +
                  "status_pengiriman, status_pembayaran " +
                  "FROM pelanggan ORDER BY nama ASC";
        } else {
            sql = "SELECT id, nama, alamat, jumlah_galon, harga_per_galon, " +
                  "(jumlah_galon * harga_per_galon) AS total_harga, " +
                  "status_pengiriman, status_pembayaran " +
                  "FROM pelanggan " +
                  "WHERE ? >= tgl_mulai_rentang AND rentang_pengiriman > 0 " +
                  "AND DATEDIFF(?, tgl_mulai_rentang) % rentang_pengiriman = 0 " +
                  "ORDER BY nama ASC";
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            java.sql.Date sqlDate = (date != null) ? new java.sql.Date(date.getTime()) : null;

            if (sqlDate != null) {
                pstmt.setDate(1, sqlDate);
                pstmt.setDate(2, sqlDate);
            }

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
                        sqlDate // Menggunakan tanggal filter sebagai tgl laporan
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean updateStatus(int id, String statusKirim, String statusBayar) {
        String sql = "UPDATE pelanggan SET status_pengiriman = ?, status_pembayaran = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, statusKirim);
            pstmt.setString(2, statusBayar);
            pstmt.setInt(3, id);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
