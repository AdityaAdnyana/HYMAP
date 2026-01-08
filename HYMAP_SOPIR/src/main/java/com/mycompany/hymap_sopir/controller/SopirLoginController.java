package com.mycompany.hymap_sopir.controller;


import com.mycompany.hymap_sopir.model.login.IAuthRepository;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Import View tujuan selanjutnya (Misal Dashboard atau Jadwal)

import com.mycompany.hymap_sopir.model.login.Sopir;
import com.mycompany.hymap_sopir.view.JadwalKiriman;
import com.mycompany.hymap_sopir.view.SopirLogin;
import org.mindrot.jbcrypt.BCrypt;

public class SopirLoginController {
    
    private final SopirLogin view;
    private final IAuthRepository repository;

    public SopirLoginController(SopirLogin view, IAuthRepository repository) {
        this.view = view;
        this.repository = repository;

        // Pasang listener ke tombol login di View
        this.view.addLoginListener(new LoginListener());
    }

    private class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsernameInput();
            String password = view.getPasswordInput();

            // 1. Validasi Input Kosong
            if (username.isEmpty() || password.isEmpty()) {
                view.showErrorMessage("Username dan password tidak boleh kosong.");
                return;
            }

            // 2. Cari Sopir di Database (Model)
            Sopir sopir = repository.findByUsername(username);

            // 3. Verifikasi Password dengan BCrypt
            if (sopir != null) {
                // Cek apakah password input cocok dengan hash di database
                if (BCrypt.checkpw(password, sopir.getPassword())) {
                    loginSuccess(sopir);
                } else {
                    view.showErrorMessage("Password salah!");
                }
            } else {
                view.showErrorMessage("Username tidak ditemukan!");
            }
        }
    }

    private void loginSuccess(Sopir sopir) {
        view.showSuccessMessage("Login Berhasil!");
        view.dispose(); // Tutup window login
        JadwalKiriman view = new JadwalKiriman();

        
        // Navigasi ke layar selanjutnya
        // Idealnya gunakan NavigationService, tapi untuk sekarang kita instansiasi langsung sesuai kode lama
        JadwalKirimanController jadwal = new JadwalKirimanController(view, sopir.getId(), sopir.getArmada());
        view.setVisible(true);
    }
}