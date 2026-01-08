package com.mycompany.hymap_sopir.model.login;


import com.mycompany.hymap_sopir.config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthRepository implements IAuthRepository {

    @Override
    public Sopir findByUsername(String username) {
        String sql = "SELECT id, username, password, armada FROM sopir WHERE username = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Sopir(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"), // Ini adalah Hashed Password
                        rs.getString("armada")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null jika user tidak ditemukan
    }
}