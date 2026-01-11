package com.mycompany.admin.controller;

import com.mycompany.admin.controller.InfoPenjualan.InfoPenjualanController;
import com.mycompany.admin.view.DashboardMenu;
import com.mycompany.admin.util.NavigationService;

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
import com.mycompany.admin.view.AturJadwalPengiriman.PilihArmada;
import com.mycompany.admin.model.AturJadwalPengiriman.JadwalRepository;
import com.mycompany.admin.controller.AturJadwalPengiriman.JadwalController;


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
        view.addCetakLaporanListener(e -> navigateToCetakLaporan());
        view.addUpdateStatusPembayaranListener(e -> navigateToUpdateStatus());
        view.addAturJadwalListener(e -> navigateToAturjadwal());
    }
    
    // --- NAVIGATION LOGIC ---
    
    private void navigateToKelolaSopir() {
        NavigationService.toKelolaSopir(view);
    }
    
    private void navigateToKelolaPelanggan() {
        NavigationService.toKelolaPelanggan(view);
    }
    
    // Contoh placeholder untuk fitur lain
    
    private void navigateToCetakLaporan() {
        NavigationService.toCetakLaporan(view);
    }

    private void navigateToUpdateStatus() {
        NavigationService.toUpdateStatusPembayaran(view);
    }
    
    private void navigateToAturjadwal() {
        NavigationService.toAturJadwalPengiriman(view);
    }
    
}