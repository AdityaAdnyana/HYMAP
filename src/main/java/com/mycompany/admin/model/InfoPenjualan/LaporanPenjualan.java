/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.model.InfoPenjualan;

import java.util.Date;

/**
 *
 * @author R9480
 */
public class LaporanPenjualan {

    private int id;
    private String nama;
    private String alamat;
    private int jumlahGalon;
    private double hargaPerGalon;
    private double totalHarga;
    private String statusPengiriman;
    private String statusPembayaran;
    private Date tglUpdate;

    public LaporanPenjualan(int id, String nama, String alamat, int jumlahGalon, double hargaPerGalon,
            double totalHarga, String statusPengiriman, String statusPembayaran, Date tglUpdate) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.jumlahGalon = jumlahGalon;
        this.hargaPerGalon = hargaPerGalon;
        this.totalHarga = totalHarga;
        this.statusPengiriman = statusPengiriman;
        this.statusPembayaran = statusPembayaran;
        this.tglUpdate = tglUpdate;
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

    public int getJumlahGalon() {
        return jumlahGalon;
    }

    public double getHargaPerGalon() {
        return hargaPerGalon;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public String getStatusPengiriman() {
        return statusPengiriman;
    }

    public String getStatusPembayaran() {
        return statusPembayaran;
    }

    public Date getTglUpdate() {
        return tglUpdate;
    }
}
