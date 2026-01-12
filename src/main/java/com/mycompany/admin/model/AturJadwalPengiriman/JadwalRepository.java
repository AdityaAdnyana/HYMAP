/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.model.AturJadwalPengiriman;

import com.mycompany.admin.config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author R9480
 */
public class JadwalRepository implements IJadwalRepository {

    @Override
    public List<Jadwal> getJadwalByArmada(String armada) {
        List<Jadwal> list = new ArrayList<>();
        String sql = "SELECT id, nama, alamat, jumlah_galon, harga_per_galon, rentang_pengiriman, tgl_mulai_rentang "
                + "FROM pelanggan WHERE daerah_kiriman = ? ORDER BY id";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, armada);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new Jadwal(
                            rs.getInt("id"),
                            rs.getString("nama"),
                            rs.getString("alamat"),
                            rs.getInt("jumlah_galon"),
                            rs.getDouble("harga_per_galon"),
                            rs.getInt("rentang_pengiriman"),
                            rs.getDate("tgl_mulai_rentang")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean updateJadwal(Jadwal j) {
        String sql = "UPDATE pelanggan SET jumlah_galon = ?, harga_per_galon = ?, "
                + "rentang_pengiriman = ?, tgl_mulai_rentang = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, j.getStokGalon());
            pstmt.setDouble(2, j.getHarga());
            pstmt.setInt(3, j.getRentangPengiriman());
            pstmt.setDate(4, j.getTglMulaiRentang());
            pstmt.setInt(5, j.getId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
