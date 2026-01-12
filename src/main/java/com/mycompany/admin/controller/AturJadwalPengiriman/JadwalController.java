/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.controller.AturJadwalPengiriman;

import com.mycompany.admin.model.AturJadwalPengiriman.IJadwalRepository;
import com.mycompany.admin.model.AturJadwalPengiriman.Jadwal;
import com.mycompany.admin.util.NavigationService;
import com.mycompany.admin.view.AturJadwalPengiriman.JadwalPengiriman;
import com.mycompany.admin.view.AturJadwalPengiriman.PilihArmada;
import com.mycompany.admin.view.AturJadwalPengiriman.TablleButton.TableActionEvent;
import com.mycompany.admin.view.AturJadwalPengiriman.UpdateJadwal;
import com.mycompany.admin.view.DashboardMenu;
import java.util.List;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author R9480
 */
public class JadwalController {

    private PilihArmada pilihView;
    private IJadwalRepository repository;
    private String currentArmada;

    public JadwalController(PilihArmada view, IJadwalRepository repo) {
        this.pilihView = view;
        this.repository = repo;
        initPilihArmada();
    }

    private void initPilihArmada() {
        pilihView.setVisible(true);

        // Listener saat Armada dipilih
        pilihView.addPilihListener(e -> {
            currentArmada = pilihView.getSelectedArmada();
            showJadwalTable();
            pilihView.dispose();
        });

        // Listener Back ke Dashboard
        pilihView.addMenuListener(e -> {
//            pilihView.dispose();
            NavigationService.toDashboard(pilihView);
        });
    }

    private void showJadwalTable() {
        // 1. Buat View Baru (Constructor Kosong sesuai perbaikan di atas)
        JadwalPengiriman jadwalView = new JadwalPengiriman();

        // 2. Ambil Data & Tampilkan
        List<Jadwal> data = repository.getJadwalByArmada(currentArmada);
        jadwalView.setTableData(data);

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) { // Perhatikan huruf kecil 'onEdit' (sesuai interface asli)
                DefaultTableModel model = (DefaultTableModel) jadwalView.getTable().getModel();
                
                // Ambil data dari baris yang diklik
                int id = (int) model.getValueAt(row, 0);
                String nama = (String) model.getValueAt(row, 1);
                String alamat = (String) model.getValueAt(row, 2);
                int stok = (int) model.getValueAt(row, 3);
                double harga = (double) model.getValueAt(row, 4);
                int rentang = (int) model.getValueAt(row, 5);
                
                // Konversi tanggal aman
                Object tglObj = model.getValueAt(row, 6);
                java.sql.Date tgl = null;
                if (tglObj instanceof java.sql.Date) {
                    tgl = (java.sql.Date) tglObj;
                } else if (tglObj instanceof java.util.Date) {
                    tgl = new java.sql.Date(((java.util.Date) tglObj).getTime());
                }

                // Panggil Dialog Update
                showUpdateDialog(jadwalView, id, nama, alamat, stok, harga, rentang, tgl);
            }
        };
        
        jadwalView.setTableActionEvent(event);

        jadwalView.addKembaliListener(e -> {
            jadwalView.dispose();
            pilihView.setVisible(true);
        });

        pilihView.setVisible(false);
        jadwalView.setVisible(true);
    }

    private void showUpdateDialog(JadwalPengiriman parentView, int id, String nama, String alamat,
            int stok, double harga, int rentang, java.util.Date tgl) {

        UpdateJadwal updateView = new UpdateJadwal(id, nama, alamat, stok, harga, rentang, tgl);

        // Logika Simpan
        updateView.addSimpanListener(e -> {
            try {
                int newStok = Integer.parseInt(updateView.getStokInput());
                double newHarga = Double.parseDouble(updateView.getHargaInput());
                int newRentang = Integer.parseInt(updateView.getRentangInput());
                java.util.Date utilDate = updateView.getTglInput();

                if (utilDate == null) {
                    updateView.showWarning("Tanggal tidak boleh kosong!");
                    return;
                }
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                Jadwal newData = new Jadwal(id, nama, alamat, newStok, newHarga, newRentang, sqlDate);

                if (repository.updateJadwal(newData)) {
                    updateView.showMessage("Jadwal Berhasil Diupdate!");
                    updateView.dispose();

                    // Refresh data tabel di belakang layar
                    parentView.setTableData(repository.getJadwalByArmada(currentArmada));
                    parentView.setVisible(true);
                } else {
                    updateView.showWarning("Gagal Update Database!");
                }

            } catch (NumberFormatException ex) {
                updateView.showWarning("Input Angka (Stok/Harga/Rentang) tidak valid!");
            }
        });

        // Logika Batal/Back
        updateView.addBackListener(e -> {
            updateView.dispose();
            parentView.setVisible(true);
        });

        parentView.setVisible(false);
        updateView.setVisible(true);
    }
}
