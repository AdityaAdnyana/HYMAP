/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.controller.SetHargaDefault;

import com.mycompany.admin.model.SetHarga.ISetHargaRepository;
import com.mycompany.admin.view.DashboardMenu;
import com.mycompany.admin.view.SetHargaDefault.SetHargaDefault;

/**
 *
 * @author R9480
 */
public class SetHargaController {
    
    private SetHargaDefault view;
    private ISetHargaRepository repository;

    public SetHargaController(SetHargaDefault view, ISetHargaRepository repository) {
        this.view = view;
        this.repository = repository;
        initController();
    }

    private void initController() {
        // 1. Tampilkan Data Awal (Harga saat ini)
        double currentPrice = repository.getCurrentReferencePrice();
        view.setHargaDisplay(currentPrice);
        
        // 2. Logic Tombol Simpan
        view.addSimpanListener(e -> {
            try {
                String input = view.getHargaInput();
                
                // Validasi: Cek apakah input kosong atau bukan angka
                if (input.isEmpty()) {
                    view.showWarning("Harga tidak boleh kosong!");
                    return;
                }
                
                double hargaBaru = Double.parseDouble(input);
                
                // Konfirmasi User
                int confirm = javax.swing.JOptionPane.showConfirmDialog(view, 
                        "Apakah Anda yakin ingin mengubah harga untuk SEMUA pelanggan menjadi: " + hargaBaru + "?",
                        "Konfirmasi Update Massal",
                        javax.swing.JOptionPane.YES_NO_OPTION);
                
                if (confirm == javax.swing.JOptionPane.YES_OPTION) {
                    // Eksekusi Update
                    if (repository.updateAllHarga(hargaBaru)) {
                        view.showMessage("Berhasil! Semua harga pelanggan telah diperbarui.");
                    } else {
                        view.showWarning("Gagal memperbarui database.");
                    }
                }
                
            } catch (NumberFormatException ex) {
                view.showWarning("Masukkan format angka yang benar (Contoh: 5000 atau 5000.0)");
            }
        });

        // 3. Logic Tombol Menu (Back)
        view.addMenuListener(e -> {
            view.dispose(); // Tutup window ini
            new DashboardMenu().setVisible(true);
        });
        
        // Tampilkan View
        view.setVisible(true);
    }
}
