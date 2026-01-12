package com.mycompany.hymap_sopir.controller;

import Sopir.TableAddButton.TableActionEvent;
import com.mycompany.hymap_sopir.model.jadwal_kiriman.JadwalRepository;
import com.mycompany.hymap_sopir.model.jadwal_kiriman.PelangganKiriman;
import com.mycompany.hymap_sopir.view.JadwalKiriman;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class JadwalKirimanController {
    private final JadwalKiriman view;
    private final JadwalRepository repository;
    private final String armada;

    public JadwalKirimanController(JadwalKiriman view, int sopirId, String armada) {
        this.view = view;
        this.armada = armada;
        this.repository = new JadwalRepository();
        initController();
    }

    private void initController() {
        view.setArmadaLabel(armada);
        view.setDate(new Date()); 
        loadData();

        view.addPrevButtonListener(e -> changeDate(-1));
        view.addNextButtonListener(e -> changeDate(1));
        view.addDatePropertyChangeListener(evt -> loadData());

        view.setTableActionEvent(new TableActionEvent() {
            @Override
            public void onTerkirim(int row) { handleUpdate(row, "sudah terkirim"); }
            @Override
            public void onBelum(int row) { handleUpdate(row, "belum terkirim"); }
        });
    }

    private void handleUpdate(int row, String status) {
        // Mencegah UI 'stuck' dengan menghentikan editing sebelum refresh
        stopTableEditing();

        int id = view.getPelangganIdAt(row);
        Date date = view.getDate();
        
        if (repository.updateStatusPengiriman(id, date, status)) {
            // Reload total agar status di model & view sinkron 100%
            loadData(); 
        } else {
            view.showErrorMessage("Gagal menyimpan perubahan ke database.");
        }
    }

    private void loadData() {
        stopTableEditing();
        Date date = view.getDate();
        if (date != null) {
            List<PelangganKiriman> data = repository.getJadwalByDate(armada, date);
            view.updateTableData(data);
        }
    }

    private void stopTableEditing() {
        if (view.getTable() != null && view.getTable().isEditing()) {
            view.getTable().getCellEditor().stopCellEditing();
        }
    }

    private void changeDate(int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(view.getDate());
        cal.add(Calendar.DAY_OF_MONTH, days);
        view.setDate(cal.getTime());
    }
}