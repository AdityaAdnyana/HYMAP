package com.mycompany.hymap_sopir.model.login;

public class Sopir {
    private int id;
    private String username;
    private String password; // Ini akan berisi hash dari database
    private String armada;

    public Sopir(int id, String username, String password, String armada) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.armada = armada;
    }

    // Getters
    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getArmada() { return armada; }
}