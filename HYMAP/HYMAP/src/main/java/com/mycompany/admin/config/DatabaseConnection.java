/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Aditya
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane; // Tambahkan import ini

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/hymap-db";
    private static final String USER = "root"; 
    private static final String PASSWORD = ""; 

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC tidak ditemukan!");
            e.printStackTrace();
        } catch (SQLException e) {
            // PENTING: Beritahu user jika koneksi gagal
            System.err.println("Gagal koneksi ke Database!");
            JOptionPane.showMessageDialog(null, 
                "Gagal terhubung ke Database.\nPastikan XAMPP/MySQL sudah aktif.", 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }
}
