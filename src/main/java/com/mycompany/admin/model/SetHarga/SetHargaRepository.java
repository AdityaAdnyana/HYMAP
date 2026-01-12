/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.model.SetHarga;

import com.mycompany.admin.config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author R9480
 */
public class SetHargaRepository implements ISetHargaRepository {

    @Override
    public double getCurrentReferencePrice() {
        // Mengambil salah satu harga sebagai referensi (misal ID pertama atau limit 1)
        String sql = "SELECT harga_per_galon FROM pelanggan LIMIT 1";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                return rs.getDouble("harga_per_galon");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0; // Default jika kosong/error
    }

    @Override
    public boolean updateAllHarga(double hargaBaru) {
        // Mengupdate kolom harga_per_galon untuk SEMUA pelanggan
        String sql = "UPDATE pelanggan SET harga_per_galon = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setDouble(1, hargaBaru);
            
            // executeUpdate mengembalikan jumlah baris yang terupdate
            // Kita anggap sukses jika tidak ada error (walau 0 row updated jika tabel kosong)
            pstmt.executeUpdate(); 
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
