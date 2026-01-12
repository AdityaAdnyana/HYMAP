package com.mycompany.admin.controller.kelola_data_sopir;

import com.mycompany.admin.model.kelola_data_sopir.ISopirRepository;
import com.mycompany.admin.model.kelola_data_sopir.Sopir;
import com.mycompany.admin.util.NavigationService;
import com.mycompany.admin.view.kelola_data_sopir.DataSopir;
import com.mycompany.admin.view.kelola_data_sopir.RegistrasiSopir;
import com.mycompany.admin.view.kelola_data_sopir.EditDataSopir;
import com.mycompany.admin.view.kelola_data_sopir.table_add_button.TableActionEvent; 
import com.mycompany.admin.view.DashboardMenu; 

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SopirController {

    private DataSopir view;
    private ISopirRepository repository;

    public SopirController(DataSopir view, ISopirRepository repository) {
        this.view = view;
        this.repository = repository;
        initController();
    }

    private void initController() {
        refreshTable();

        // 1. Logic Tombol Tambah
        view.addTambahListener(e -> showRegistrasiView());

        // 2. Logic Tombol Menu (Back)
        view.addMenuListener(e -> {
            NavigationService.toDashboard(view);
        });

        // 3. Logic Action Table (Edit & Delete Cell Button)
        view.setTableListener(new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                handleEditRequest(row);
            }

            @Override
            public void onDelete(int row) {
                handleDeleteRequest(row);
            }
        });
    }

    private void refreshTable() {
        view.setTableData(repository.getAllSopir());
    }

    // --- LOGIKA TAMBAH ---
    private void showRegistrasiView() {
        RegistrasiSopir regView = new RegistrasiSopir();
        view.setVisible(false);
        regView.setVisible(true);

        // Aksi Tombol Simpan di Form Registrasi
        regView.addSimpanListener(e -> {
            String nama = regView.getNama();
            String telp = regView.getNoTelepon();
            String armada = regView.getArmada();
            String user = regView.getUsername();
            String pass = regView.getPassword();

            if(nama.isEmpty() || telp.isEmpty() || user.isEmpty()) {
                regView.showMessage("Data tidak boleh kosong!");
                return;
            }

            Sopir s = new Sopir(0, nama, telp, armada, user, pass);
            if (repository.addSopir(s)) {
                regView.showMessage("Berhasil Menambahkan Sopir!");
                regView.dispose();
                view.setVisible(true);
                refreshTable();
            } else {
                regView.showMessage("Gagal Menambahkan Data");
            }
        });
        
        // Aksi Back di Form Registrasi
        regView.addMenuListener(e -> {
            regView.dispose();
            view.setVisible(true);
        });
    }

    // --- LOGIKA EDIT ---
    private void handleEditRequest(int row) {
        DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
        int id = (int) model.getValueAt(row, 0);
        String nama = model.getValueAt(row, 1).toString();
        String telp = model.getValueAt(row, 2).toString();
        String armada = model.getValueAt(row, 3).toString();
        String user = model.getValueAt(row, 4).toString();
        String pass = model.getValueAt(row, 5).toString();

        EditDataSopir editView = new EditDataSopir();
        editView.setFormData(nama, telp, armada, user, pass);
        
        view.setVisible(false);
        editView.setVisible(true);

        // Aksi Update di Form Edit
        editView.addUpdateListener(e -> {
             String newNama = editView.getNama();
             String newTelp = editView.getNoTelepon();
             String newArmada = editView.getArmada();
             String newUser = editView.getUsername();
             String newPass = editView.getPassword();
             
             Sopir s = new Sopir(id, newNama, newTelp, newArmada, newUser, newPass);
             
             if(repository.updateSopir(s)) {
                 editView.showMessage("Data Berhasil Diupdate!");
                 editView.dispose();
                 view.setVisible(true);
                 refreshTable();
             } else {
                 editView.showMessage("Gagal Update Data!");
             }
        });
        
        // Aksi Back di Form Edit
        editView.addMenuListener(e -> {
            editView.dispose();
            view.setVisible(true);
        });
    }

    // --- LOGIKA DELETE ---
    private void handleDeleteRequest(int row) {
        DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
        int id = (int) model.getValueAt(row, 0);

        int confirm = JOptionPane.showConfirmDialog(view, "Yakin hapus sopir ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (repository.deleteSopir(id)) {
                // Hapus row dari tabel visual saja agar cepat (atau panggil refreshTable utk reload DB)
                // model.removeRow(row); 
                // Tapi lebih aman refreshTable() untuk sinkronisasi ID
                refreshTable(); 
                JOptionPane.showMessageDialog(view, "Data Terhapus");
            } else {
                JOptionPane.showMessageDialog(view, "Gagal Menghapus");
            }
        }
    }
}