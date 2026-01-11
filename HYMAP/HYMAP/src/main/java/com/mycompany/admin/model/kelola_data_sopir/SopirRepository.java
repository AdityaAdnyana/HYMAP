/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.model.kelola_data_sopir;

import com.mycompany.admin.config.DatabaseConnection; // Sesuaikan package koneksi Anda
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SopirRepository implements ISopirRepository {

    @Override
    public List<Sopir> getAllSopir() {
        List<Sopir> list = new ArrayList<>();
        String sql = "SELECT id, nama, no_telepon, armada, username, password FROM sopir ORDER BY id";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                list.add(new Sopir(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("no_telepon"),
                    rs.getString("armada"),
                    rs.getString("username"),
                    rs.getString("password")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean addSopir(Sopir s) {
        String sql = "INSERT INTO sopir (nama, no_telepon, armada, username, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, s.getNama());
            pstmt.setString(2, s.getNoTelepon());
            pstmt.setString(3, s.getArmada());
            pstmt.setString(4, s.getUsername());
            pstmt.setString(5, s.getPassword()); // Sebaiknya di-hash jika memungkinkan
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateSopir(Sopir s) {
        String sql = "UPDATE sopir SET nama = ?, no_telepon = ?, armada = ?, username = ?, password = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, s.getNama());
            pstmt.setString(2, s.getNoTelepon());
            pstmt.setString(3, s.getArmada());
            pstmt.setString(4, s.getUsername());
            pstmt.setString(5, s.getPassword());
            pstmt.setInt(6, s.getId());
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteSopir(int id) {
        String sql = "DELETE FROM sopir WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}