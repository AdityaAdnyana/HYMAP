/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.controller.InfoPenjualan;

import com.mycompany.admin.model.InfoPenjualan.IInfoPenjualanRepository;
import com.mycompany.admin.model.InfoPenjualan.LaporanPenjualan;
import com.mycompany.admin.util.NavigationService;
import com.mycompany.admin.view.DashboardMenu;
import com.mycompany.admin.view.InfoPenjualan.CetakLaporan;
import com.mycompany.admin.view.InfoPenjualan.Status;
import com.mycompany.admin.view.InfoPenjualan.TableAddButton.StatusPembayaran.TableActionEvent;
import com.mycompany.admin.view.InfoPenjualan.UpdateStatusPembayaran;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author R9480
 */
public class InfoPenjualanController {
    
    private IInfoPenjualanRepository repository;

    public InfoPenjualanController(IInfoPenjualanRepository repository) {
        this.repository = repository;
        
    }

    // --- LOGIKA CETAK LAPORAN ---
    public void showCetakLaporan() {
        CetakLaporan view = new CetakLaporan();
        view.addMenuListener(e -> NavigationService.toDashboard(view));
        
        // 1. Load Data Awal
        refreshLaporan(view);
        
        // 2. Listener Tanggal Berubah
        view.addDateChangeListener(evt -> {
            if ("date".equals(evt.getPropertyName())) {
                refreshLaporan(view);
            }
        });
        
        // 3. Listener Tombol Navigasi Tanggal
        view.addPrevDateListener(e -> adjustDate(view, -1));
        view.addNextDateListener(e -> adjustDate(view, 1));
        
        // 4. Menu Back
        view.addMenuListener(e -> {
            NavigationService.toDashboard(view);
        });

        view.setVisible(true);
    }

    private void refreshLaporan(CetakLaporan view) {
        List<LaporanPenjualan> data = repository.getLaporanByDate(view.getSelectedDate());
        view.setTableData(data);
    }

    private void adjustDate(CetakLaporan view, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(view.getSelectedDate());
        cal.add(Calendar.DAY_OF_MONTH, days);
        view.setDate(cal.getTime()); // Ini akan memicu DateChangeListener
    }

    // --- LOGIKA UPDATE STATUS PEMBAYARAN ---
    public void showUpdateStatus() {
        UpdateStatusPembayaran view = new UpdateStatusPembayaran();

        view.addMenuListener(e -> NavigationService.toDashboard(view));
        
        // 1. Load Data Awal
        refreshStatusTable(view);
        
        // 2. Listener Tanggal
        view.addDateChangeListener(evt -> {
             if ("date".equals(evt.getPropertyName())) {
                refreshStatusTable(view);
            }
        });
        
        // 3. Listener Tombol Edit di Tabel
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEDIT(int row) {
                DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
                int id = (int) model.getValueAt(row, 0);
                String kirim = String.valueOf(model.getValueAt(row, 3));
                String bayar = String.valueOf(model.getValueAt(row, 4));
                
                openStatusDialog(view, id, kirim, bayar);
            }
        };
        view.setTableAction(event);
        
        view.setVisible(true);
    }
    
    private void refreshStatusTable(UpdateStatusPembayaran view) {
        List<LaporanPenjualan> data = repository.getLaporanByDate(view.getSelectedDate());
        view.setTableData(data);
    }

    // --- LOGIKA DIALOG STATUS ---
    private void openStatusDialog(UpdateStatusPembayaran parentView, int id, String kirim, String bayar) {
        Status statusView = new Status(id, kirim, bayar);
        
        statusView.addMenuListener(e -> NavigationService.toDashboard(statusView));
        
        statusView.addSimpanListener(e -> {
            boolean success = repository.updateStatus(
                statusView.getPelangganId(), 
                statusView.getStatusPengiriman(), 
                statusView.getStatusPembayaran()
            );
            
            if (success) {
                statusView.showMessage("Status berhasil diperbarui.");
                statusView.dispose();
                parentView.setVisible(true);
                refreshStatusTable(parentView); // Refresh tabel utama
            } else {
                statusView.showMessage("Gagal memperbarui status.");
            }
        });
        
        statusView.setVisible(true);
    }
}
