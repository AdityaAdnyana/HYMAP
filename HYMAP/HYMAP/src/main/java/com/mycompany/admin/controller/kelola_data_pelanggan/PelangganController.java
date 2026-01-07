/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.controller.kelola_data_pelanggan;

import com.mycompany.admin.view.kelola_data_pelanggan.DataPelanggan;
import com.mycompany.admin.view.kelola_data_pelanggan.TambahDataPelanggan;
import com.mycompany.admin.model.kelola_data_pelanggan.IPelangganRepository;
import com.mycompany.admin.model.kelola_data_pelanggan.Pelanggan;
import com.mycompany.admin.view.kelola_data_pelanggan.DashboardMenu;
import com.mycompany.admin.view.kelola_data_pelanggan.EditDataPelanggan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class PelangganController {

    private DataPelanggan mainView;
    private IPelangganRepository repository;

    public PelangganController(DataPelanggan mainView, IPelangganRepository repository) {
        this.mainView = mainView;
        this.repository = repository;

        initController();
    }

    private void initController() {
        // 1. Load data awal ke Tabel
        refreshTable();

        // 2. Pasang Logic Tombol "Tambah" di Menu Utama
        mainView.addTambahListener(e -> showTambahView());
        
        // 3. Logic Edit/Hapus (Table Action)
        // ... (Kode TableAction Anda sudah benar) ...
    }
    
    private void refreshTable() {
        mainView.setTableData(repository.getAllPelanggan());
    }

    // --- LOGIKA MEMBUKA WINDOW TAMBAH & MENYIMPAN DATA ---
    private void showTambahView() {
        // Buat instance View Tambah baru
        TambahDataPelanggan tambahView = new TambahDataPelanggan();
        
        // Sembunyikan menu utama
        mainView.setVisible(false);
        tambahView.setVisible(true);

        // A. PASANG LOGIKA TOMBOL SIMPAN (Disini penerapan SRP & MVC)
        tambahView.addSimpanListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 1. Ambil Data dari View
                String nama = tambahView.getNamaInput();
                String alamat = tambahView.getAlamatInput();
                String telp = tambahView.getNoTeleponInput();
                String daerah = tambahView.getDaerahInput();

                // 2. Validasi Sederhana
                if (nama.isEmpty() || alamat.isEmpty() || telp.isEmpty()) {
                    tambahView.showWarning("Semua kolom harus diisi!");
                    return;
                }

                // 3. Buat Object Model
                Pelanggan p = new Pelanggan(0, nama, alamat, telp, daerah);

                // 4. Panggil Model/Repository untuk Simpan ke DB
                boolean success = repository.addPelanggan(p);

                // 5. Update View berdasarkan hasil
                if (success) {
                    tambahView.showMessage("Data berhasil disimpan!");
                    tambahView.dispose();       // Tutup window tambah
                    mainView.setVisible(true);  // Buka window utama
                    refreshTable();             // Refresh tabel
                } else {
                    tambahView.showWarning("Gagal menyimpan data ke database.");
                }
            }
        });

        // B. PASANG LOGIKA TOMBOL KEMBALI
        tambahView.addKembaliListener(e -> {
            tambahView.dispose();
            mainView.setVisible(true);
        });
    }
    private void handleEditRequest(int row) {
        // 1. Ambil data dari Tabel baris yang dipilih
        DefaultTableModel model = (DefaultTableModel) mainView.getTable().getModel();
        int id = (int) model.getValueAt(row, 0);
        String nama = model.getValueAt(row, 1).toString();
        String alamat = model.getValueAt(row, 2).toString();
        String telp = model.getValueAt(row, 3).toString();
        String daerah = model.getValueAt(row, 4).toString();

        // 2. Buka View Edit (Inject data lama ke constructor)
        EditDataPelanggan editView = new EditDataPelanggan(id, nama, alamat, telp, daerah);
        mainView.setVisible(false);
        editView.setVisible(true);

        // 3. Pasang Listener Tombol UPDATE di View Edit
        editView.addSimpanListener(e -> {
            // A. Ambil Data Baru dari Input
            String newNama = editView.getNamaInput();
            String newAlamat = editView.getAlamatInput();
            String newTelp = editView.getNoTeleponInput();
            String newDaerah = editView.getDaerahInput();
            int currentId = editView.getPelangganId();

            // B. Validasi
            if (newNama.isEmpty() || newAlamat.isEmpty() || newTelp.isEmpty()) {
                editView.showEmptyFieldWarning();
                return;
            }

            // C. Buat Object Model Update
            Pelanggan p = new Pelanggan(currentId, newNama, newAlamat, newTelp, newDaerah);

            // D. Panggil Repository untuk Update ke DB
            // (Pastikan Anda sudah buat method updatePelanggan di Repository & Interface)
            boolean success = repository.updatePelanggan(p); 

            // E. Update UI berdasarkan hasil
            if (success) {
                editView.showSuccessDialog();
                editView.dispose();
                mainView.setVisible(true);
                refreshTable(); // Refresh tabel utama
            } else {
                editView.showErrorDialog(); // Atau showDatabaseErrorDialog
            }
        });

        // 4. Pasang Listener Tombol BACK
        editView.addKembaliListener(e -> {
            editView.dispose();
            mainView.setVisible(true);
        });
    }
    
    // --- LOGIKA MENU BUTTON (Navigasi) ---
    // Tambahkan ini di initController(): mainView.addMenuListener(e -> backToDashboard());
    private void backToDashboard() {
        mainView.dispose();
        new DashboardMenu().setVisible(true); // Navigasi sederhana
    }
}