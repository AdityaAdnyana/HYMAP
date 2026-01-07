/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.model.login;

/**
 *
 * @author Aditya
 */

import com.mycompany.admin.config.DatabaseConnection; // Sesuaikan package koneksi Anda
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class AuthRepository implements IAuthRepository {

    @Override
    public boolean login(String username, String rawPassword) {
        // Query hanya mengambil hash password milik username yang diminta
        String sql = "SELECT password_hash FROM admin WHERE username = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String storedHash = rs.getString("password_hash");
                    
                    // Gunakan BCrypt untuk membandingkan raw password dengan hash
                    if (storedHash == null || !storedHash.startsWith("$2a$")) {
                        // Fallback jika database masih menyimpan plain text (untuk migrasi)
                        return rawPassword.equals(storedHash);
                    }
                    
                    return BCrypt.checkpw(rawPassword, storedHash);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Dalam aplikasi nyata, log error ini, jangan ditelan begitu saja
        }
        return false; // Username tidak ditemukan atau error
    }
}
