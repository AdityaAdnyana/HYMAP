/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.util; // Atau package controller

import com.mycompany.admin.controller.AturJadwalPengiriman.JadwalController;
import javax.swing.JFrame;

// Import semua View, Model, Controller yang dibutuhkan
import com.mycompany.admin.view.DashboardMenu;
import com.mycompany.admin.controller.DashboardController;
import com.mycompany.admin.controller.InfoPenjualan.InfoPenjualanController;
import com.mycompany.admin.controller.kelola_data_pelanggan.PelangganController;
import com.mycompany.admin.view.kelola_data_sopir.DataSopir;
import com.mycompany.admin.model.kelola_data_sopir.SopirRepository;
import com.mycompany.admin.controller.kelola_data_sopir.SopirController;
import com.mycompany.admin.model.AturJadwalPengiriman.JadwalRepository;
import com.mycompany.admin.model.InfoPenjualan.InfoPenjualanRepository;
import com.mycompany.admin.model.kelola_data_pelanggan.PelangganRepository;
import com.mycompany.admin.view.AturJadwalPengiriman.PilihArmada;
import com.mycompany.admin.view.InfoPenjualan.UpdateStatusPembayaran;
import com.mycompany.admin.view.kelola_data_pelanggan.DataPelanggan;
// ... import lainnya

public class NavigationService {

    public static void toDashboard(JFrame currentFrame) {
        DashboardMenu view = new DashboardMenu();     
        new DashboardController(view);
        view.setVisible(true);
        currentFrame.dispose();
    }

    public static void toKelolaSopir(JFrame currentFrame) {
        DataSopir view = new DataSopir();
        SopirRepository repo = new SopirRepository();
        new SopirController(view, repo);
        view.setVisible(true);
        currentFrame.dispose();
    }
    
    public static void toKelolaPelanggan(JFrame currentFrame) {
        DataPelanggan view = new DataPelanggan();
        PelangganRepository repo = new PelangganRepository();
        new PelangganController(view, repo);
        view.setVisible(true);
        currentFrame.dispose();
    }
    
    public static void toCetakLaporan(JFrame currentFrame) {
        InfoPenjualanRepository repo = new InfoPenjualanRepository();
        new InfoPenjualanController(repo).showCetakLaporan();
        currentFrame.dispose();
    }

    public static void toUpdateStatusPembayaran(JFrame currentFrame) {
        InfoPenjualanRepository repo = new InfoPenjualanRepository();
        new InfoPenjualanController(repo).showUpdateStatus();
        currentFrame.dispose();
    }
    
    public static void toAturJadwalPengiriman(JFrame currentFrame){
        PilihArmada view = new PilihArmada();
        JadwalRepository repo = new JadwalRepository();
        new JadwalController(view, repo);
        view.setVisible(true);
        currentFrame.dispose();
    }
}
