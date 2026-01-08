/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.util; // Atau package controller

import javax.swing.JFrame;

// Import semua View, Model, Controller yang dibutuhkan
import com.mycompany.admin.view.DashboardMenu;
import com.mycompany.admin.controller.DashboardController;
import com.mycompany.admin.view.kelola_data_sopir.DataSopir;
import com.mycompany.admin.model.kelola_data_sopir.SopirRepository;
import com.mycompany.admin.controller.kelola_data_sopir.SopirController;
// ... import lainnya

public class NavigationService {

    // Static method agar mudah dipanggil tanpa instansiasi
    // Parameter 'currentFrame' digunakan untuk menutup jendela sebelumnya
    public static void toDashboard(JFrame currentFrame) {
        if (currentFrame != null) {
            currentFrame.dispose(); // Tutup jendela lama
        }

        // --- RAKIT MVC DASHBOARD DI SINI ---
        DashboardMenu view = new DashboardMenu();
        new DashboardController(view); // Controller otomatis memasang listener
        view.setVisible(true);
    }

    public static void toKelolaSopir(JFrame currentFrame) {
        if (currentFrame != null) {
            currentFrame.dispose();
        }

        // --- RAKIT MVC SOPIR DI SINI ---
        DataSopir view = new DataSopir();
        SopirRepository repo = new SopirRepository();
        new SopirController(view, repo);
        view.setVisible(true);
    }
    
    // ... Tambahkan method toKelolaPelanggan, toLogin, dll ...
}
