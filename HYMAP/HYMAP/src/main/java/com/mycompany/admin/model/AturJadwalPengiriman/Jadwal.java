/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.model.AturJadwalPengiriman;

import java.sql.Date;

/**
 *
 * @author R9480
 */
public class Jadwal {

    private int id;
    private String nama;
    private String alamat;
    private int stokGalon;
    private double harga;
    private int rentangPengiriman;
    private Date tglMulaiRentang;

    public Jadwal(int id, String nama, String alamat, int stokGalon, double harga, int rentangPengiriman, Date tglMulaiRentang) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.stokGalon = stokGalon;
        this.harga = harga;
        this.rentangPengiriman = rentangPengiriman;
        this.tglMulaiRentang = tglMulaiRentang;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getStokGalon() {
        return stokGalon;
    }

    public double getHarga() {
        return harga;
    }

    public int getRentangPengiriman() {
        return rentangPengiriman;
    }

    public Date getTglMulaiRentang() {
        return tglMulaiRentang;
    }
}
