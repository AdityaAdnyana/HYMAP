/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin;

import com.mycompany.admin.controller.login.LoginController;
import com.mycompany.admin.model.login.AuthRepository;
import com.mycompany.admin.model.login.IAuthRepository;
import com.mycompany.admin.view.login.AdminLogin;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Aditya
 */
public class AdminApp {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            // 1. Siapkan View
            AdminLogin view = new AdminLogin();
            
            // 2. Siapkan Model/Repository
            IAuthRepository repository = new AuthRepository();
            
            // 3. Siapkan Controller (Inject View dan Model)
            new LoginController(view, repository);
            
            // 4. Tampilkan View
            view.setVisible(true);
            
            String passwordBaru = "1";
            String hashedPassword = BCrypt.hashpw(passwordBaru, BCrypt.gensalt());
            System.out.println(hashedPassword);
        });
    }
}
