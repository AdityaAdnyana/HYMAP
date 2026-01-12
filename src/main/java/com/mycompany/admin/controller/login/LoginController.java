/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.controller.login;

/**
 *
 * @author Aditya
 */
import com.mycompany.admin.model.login.IAuthRepository;
import com.mycompany.admin.util.NavigationService;
import com.mycompany.admin.view.login.AdminLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

    private final AdminLogin view;
    private final IAuthRepository repository;

    // Dependency Injection via Constructor (SOLID)
    public LoginController(AdminLogin view, IAuthRepository repository) {
        this.view = view;
        this.repository = repository;

        // Pasang listener ke View
        this.view.addLoginListener(new LoginListener());
    }

    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();

            // Validasi Input Sederhana
            if (username.isEmpty() || password.isEmpty()) {
                view.showErrorMessage("Username dan Password tidak boleh kosong!");
                return;
            }

            // Panggil Model (Repository)
            boolean isLoginSuccess = repository.login(username, password);

            if (isLoginSuccess) {
                NavigationService.toDashboard(view);
            } else {
                view.showErrorMessage("Username atau Password salah!");
            }
        }
    }
}
