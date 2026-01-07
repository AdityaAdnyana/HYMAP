/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.model.kelola_data_pelanggan;

/**
 *
 * @author Aditya
 */
import com.mycompany.admin.config.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PelangganRepository implements IPelangganRepository {

    @Override
    public boolean addPelanggan(Pelanggan p) {
        String sql = "INSERT INTO pelanggan (nama, alamat, no_telepon, daerah_kiriman) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, p.getNama());
            pstmt.setString(2, p.getAlamat());
            pstmt.setString(3, p.getNoTelepon());
            pstmt.setString(4, p.getDaerahKiriman());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Pelanggan> getAllPelanggan() {
        // ... Implementasi select * from pelanggan ...
        // (Kode ini dipindahkan dari Controller atau View lama)
        return new ArrayList<>(); // Placeholder
    }

    @Override
    public boolean updatePelanggan(Pelanggan p) {
        String sql = "UPDATE pelanggan SET nama = ?, alamat = ?, no_telepon = ?, daerah_kiriman = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, p.getNama());
            pstmt.setString(2, p.getAlamat());
            pstmt.setString(3, p.getNoTelepon());
            pstmt.setString(4, p.getDaerahKiriman());
            pstmt.setInt(5, p.getId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
