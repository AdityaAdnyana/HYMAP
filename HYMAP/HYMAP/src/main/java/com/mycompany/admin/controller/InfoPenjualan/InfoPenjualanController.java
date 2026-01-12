package com.mycompany.admin.controller.InfoPenjualan;

import com.mycompany.admin.model.InfoPenjualan.IInfoPenjualanRepository;
import com.mycompany.admin.model.InfoPenjualan.LaporanPenjualan;
import com.mycompany.admin.util.NavigationService;
import com.mycompany.admin.view.InfoPenjualan.CetakLaporan;
import com.mycompany.admin.view.InfoPenjualan.Status;
import com.mycompany.admin.view.InfoPenjualan.TableAddButton.StatusPembayaran.TableActionEvent;
import com.mycompany.admin.view.InfoPenjualan.UpdateStatusPembayaran;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class InfoPenjualanController {
    
    private IInfoPenjualanRepository repository;

    public InfoPenjualanController(IInfoPenjualanRepository repository) {
        this.repository = repository;
    }

    // --- LOGIKA CETAK LAPORAN ---
    public void showCetakLaporan() {
        CetakLaporan view = new CetakLaporan();
        view.addMenuListener(e -> NavigationService.toDashboard(view));
        
        refreshLaporan(view);
        
        view.addDateChangeListener(evt -> {
            if ("date".equals(evt.getPropertyName())) {
                refreshLaporan(view);
            }
        });
        
        view.addPrevDateListener(e -> adjustDate(view, -1));
        view.addNextDateListener(e -> adjustDate(view, 1));
        
        view.setVisible(true);
    }

    private void refreshLaporan(CetakLaporan view) {
        List<LaporanPenjualan> data = repository.getLaporanByDate(view.getSelectedDate());
        view.setTableData(data);
    }

    // Letakkan di dalam class InfoPenjualanController.java
private void adjustDate(javax.swing.JFrame view, int days) {
    java.util.Date currentDate = null;
    
    // 1. Cek Layar mana yang sedang mengirim perintah, lalu ambil tanggalnya
    if (view instanceof CetakLaporan) {
        currentDate = ((CetakLaporan) view).getSelectedDate();
    } else if (view instanceof UpdateStatusPembayaran) {
        currentDate = ((UpdateStatusPembayaran) view).getSelectedDate();
    }

    if (currentDate != null) {
        // 2. Logika Hitung Tanggal (Tambah/Kurang Hari)
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(java.util.Calendar.DAY_OF_MONTH, days);
        java.util.Date newDate = cal.getTime();
        
        // 3. Kembalikan tanggal baru ke Layar yang bersangkutan
        if (view instanceof CetakLaporan) {
            ((CetakLaporan) view).setDate(newDate);
        } else if (view instanceof UpdateStatusPembayaran) {
            ((UpdateStatusPembayaran) view).setDate(newDate);
        }
    }
}

    // --- LOGIKA UPDATE STATUS PEMBAYARAN ---
    public void showUpdateStatus() {
        UpdateStatusPembayaran view = new UpdateStatusPembayaran();
        view.addMenuListener(e -> NavigationService.toDashboard(view));
        
        refreshStatusTable(view);
        
        view.addDateChangeListener(evt -> {
             if ("date".equals(evt.getPropertyName())) {
                refreshStatusTable(view);
            }
        });

        view.addPrevDateListener(e -> adjustDate(view, -1));
    view.addNextDateListener(e -> adjustDate(view, 1));
        
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

    private void openStatusDialog(UpdateStatusPembayaran parentView, int id, String kirim, String bayar) {
        Status statusView = new Status(id, kirim, bayar);
        
        // Ambil tanggal dari JDateChooser di view utama agar update masuk ke tanggal yang benar
        java.util.Date selectedDate = parentView.getSelectedDate(); 

        statusView.addSimpanListener(e -> {
            // Memanggil repository dengan 4 parameter (id, date, statusKirim, statusBayar)
            boolean success = repository.updateStatus(
                statusView.getPelangganId(), 
                selectedDate, 
                statusView.getStatusPengiriman(), 
                statusView.getStatusPembayaran()
            );
            
            if (success) {
                statusView.showMessage("Status berhasil diperbarui.");
                statusView.dispose();
                refreshStatusTable(parentView); // Refresh tabel di belakangnya
            } else {
                statusView.showMessage("Gagal memperbarui status ke database.");
            }
        });

        // Tambahkan listener menu untuk menutup dialog jika batal
        statusView.addMenuListener(e -> statusView.dispose());
        
        statusView.setVisible(true);
    }
}