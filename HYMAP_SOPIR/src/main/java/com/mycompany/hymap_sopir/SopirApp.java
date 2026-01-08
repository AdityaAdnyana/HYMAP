package com.mycompany.hymap_sopir;

import com.mycompany.hymap_sopir.controller.SopirLoginController;
import com.mycompany.hymap_sopir.model.login.AuthRepository;
import com.mycompany.hymap_sopir.view.SopirLogin;

public class SopirApp {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            // 1. Siapkan View
            SopirLogin view = new SopirLogin();
            
            // 2. Siapkan Repository (Model)
            AuthRepository repository = new AuthRepository();
            
            // 3. Gabungkan dalam Controller
            new SopirLoginController(view, repository);
            
            // 4. Tampilkan
            view.setVisible(true);
        });
    }
}