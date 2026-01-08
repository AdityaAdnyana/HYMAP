/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.model.kelola_data_sopir;

/**
 *
 * @author Aditya
 */

public class Sopir {
    private int id;
    private String nama;
    private String noTelepon;
    private String armada;
    private String username;
    private String password;

    public Sopir(int id, String nama, String noTelepon, String armada, String username, String password) {
        this.id = id;
        this.nama = nama;
        this.noTelepon = noTelepon;
        this.armada = armada;
        this.username = username;
        this.password = password;
    }

    // Getters
    public int getId() { return id; }
    public String getNama() { return nama; }
    public String getNoTelepon() { return noTelepon; }
    public String getArmada() { return armada; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}