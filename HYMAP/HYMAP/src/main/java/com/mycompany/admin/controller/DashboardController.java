package com.mycompany.admin.controller;

import com.mycompany.admin.controller.InfoPenjualan.InfoPenjualanController;
import com.mycompany.admin.view.DashboardMenu;

// Import Modul Sopir (MVC)
import com.mycompany.admin.view.kelola_data_sopir.DataSopir;
import com.mycompany.admin.model.kelola_data_sopir.SopirRepository;
import com.mycompany.admin.model.kelola_data_sopir.ISopirRepository;
import com.mycompany.admin.controller.kelola_data_sopir.SopirController;

// Import Modul Pelanggan (MVC)
import com.mycompany.admin.view.kelola_data_pelanggan.DataPelanggan;
import com.mycompany.admin.model.kelola_data_pelanggan.PelangganRepository;
import com.mycompany.admin.model.kelola_data_pelanggan.IPelangganRepository;
import com.mycompany.admin.controller.kelola_data_pelanggan.PelangganController;
import com.mycompany.admin.model.InfoPenjualan.InfoPenjualanRepository;
import com.mycompany.admin.view.InfoPenjualan.CetakLaporan;


public class DashboardController {
    
    private final DashboardMenu view;

    public DashboardController(DashboardMenu view) {
        this.view = view;
        initController();
    }
    
    private void initController() {
        // Mapping Tombol ke Fungsi Navigasi
        view.addKelolaSopirListener(e -> navigateToKelolaSopir());
        view.addKelolaPelangganListener(e -> navigateToKelolaPelanggan());
        view.addKelolaPelangganListener(e -> navigateToKelolaPelanggan());
        view.addInfoPenjualanListener(e -> navigateToInfoPenjualan());
    }
    
    // --- NAVIGATION LOGIC ---
    
    private void navigateToKelolaSopir() {
        // 1. Prepare View
        DataSopir sopirView = new DataSopir();
        
        // 2. Prepare Model (Repository)
        ISopirRepository sopirRepo = new SopirRepository();
        
        // 3. Prepare Controller (Wiring)
        new SopirController(sopirView, sopirRepo);
        
        // 4. Transition
        sopirView.setVisible(true);
        view.dispose(); // Tutup Dashboard
    }
    
    private void navigateToKelolaPelanggan() {
        // 1. Prepare View
        DataPelanggan pelangganView = new DataPelanggan();
        
        // 2. Prepare Model
        IPelangganRepository pelangganRepo = new PelangganRepository();
        
        // 3. Prepare Controller
        new PelangganController(pelangganView, pelangganRepo);
        
        // 4. Transition
        pelangganView.setVisible(true);
        view.dispose();
    }
    
    // Contoh placeholder untuk fitur lain
    
    private void navigateToInfoPenjualan() {
         CetakLaporan infoView = new CetakLaporan();
         InfoPenjualanRepository pelangganRepo = new InfoPenjualanRepository();
        
        // 3. Prepare Controller
        new InfoPenjualanController(pelangganRepo);
        
        // 4. Transition
        infoView.setVisible(true);
        view.dispose();
    }
    
    private void navigateToAturjadwal() {
         CetakLaporan infoView = new CetakLaporan();
         InfoPenjualanRepository pelangganRepo = new InfoPenjualanRepository();
        
        // 3. Prepare Controller
        new InfoPenjualanController(pelangganRepo);
        
        // 4. Transition
        infoView.setVisible(true);
        view.dispose();
    }
    
}