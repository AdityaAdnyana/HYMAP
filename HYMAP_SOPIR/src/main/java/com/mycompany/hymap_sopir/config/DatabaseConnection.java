package com.mycompany.hymap_sopir.config;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Aditya
 */

   
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/hymap-db";
    private static final String USER = "root"; // Ganti jika username Anda berbeda
    private static final String PASSWORD = ""; // Ganti jika Anda menggunakan password

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Daftarkan driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Buat koneksi ke database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Tampilkan error di konsol
            // Di aplikasi nyata, tampilkan pesan error yang lebih user-friendly
        }
        return connection;
    }
}

