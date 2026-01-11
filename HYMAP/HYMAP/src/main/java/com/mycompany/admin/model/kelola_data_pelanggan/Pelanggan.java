/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.model.kelola_data_pelanggan;

/**
 *
 * @author Aditya
 */
public class Pelanggan {

    private int id;
    private String nama;
    private String alamat;
    private String noTelepon;
    private String daerahKiriman;

    public Pelanggan(int id, String nama, String alamat, String noTelepon, String daerahKiriman) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.daerahKiriman = daerahKiriman;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public String getDaerahKiriman() {
        return daerahKiriman;
    }
}
