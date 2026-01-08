package com.mycompany.hymap_sopir.controller;

import Sopir.TableAddButton.TableActionEvent;
import com.mycompany.hymap_sopir.model.jadwal_kiriman.JadwalRepository;
import com.mycompany.hymap_sopir.model.jadwal_kiriman.PelangganKiriman;
import com.mycompany.hymap_sopir.view.JadwalKiriman;

import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class JadwalKirimanController {

    private final JadwalKiriman view;
    private final JadwalRepository repository;
    private final int sopirId;
    private final String armada;

    public JadwalKirimanController(JadwalKiriman view, int sopirId, String armada) {
        this.view = view;
        this.sopirId = sopirId;
        this.armada = armada;
        this.repository = new JadwalRepository();

        initController();
    }

    private void initController() {
        // Setup awal view
        view.setArmadaLabel(armada);
        view.setDate(new Date()); // Set hari ini

        // Load data awal
        loadData();

        // Listener Navigasi Tanggal (Prev)
        view.addPrevButtonListener((ActionEvent e) -> changeDate(-1));

        // Listener Navigasi Tanggal (Next)
        view.addNextButtonListener((ActionEvent e) -> changeDate(1));

        // Listener Perubahan Date Chooser
        view.addDatePropertyChangeListener(evt -> loadData());

        // Listener Aksi Tombol di Tabel (Terkirim / Belum)
        view.setTableActionEvent(new TableActionEvent() {
            @Override
            public void onTerkirim(int row) {
                handleUpdateStatus(row, "sudah terkirim");
            }

            @Override
            public void onBelum(int row) {
                handleUpdateStatus(row, "belum terkirim");
            }
        });
        
        view.setVisible(true);
    }

    private void changeDate(int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(view.getDate());
        cal.add(Calendar.DAY_OF_MONTH, days);
        view.setDate(cal.getTime());
        // Note: loadData() akan otomatis terpanggil karena PropertyChangeListener di DateChooser
    }

    private void loadData() {
        Date currentDate = view.getDate();
        if (currentDate != null) {
            List<PelangganKiriman> data = repository.getJadwalByDate(armada, currentDate);
            view.updateTableData(data);
        }
    }

    private void handleUpdateStatus(int row, String newStatus) {
        int pelangganId = view.getPelangganIdAt(row);
        
        boolean success = repository.updateStatusPengiriman(pelangganId, newStatus);
        
        if (success) {
            view.updateStatusCell(row, newStatus);
        } else {
            view.showErrorMessage("Gagal update status di database.");
        }
    }
}