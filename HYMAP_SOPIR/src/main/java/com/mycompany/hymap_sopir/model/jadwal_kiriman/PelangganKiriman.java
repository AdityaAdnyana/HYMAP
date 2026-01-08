package com.mycompany.hymap_sopir.model.jadwal_kiriman;

public class PelangganKiriman {
    private int id;
    private String nama;
    private String alamat;
    private String status;

    public PelangganKiriman(int id, String nama, String alamat, String status) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.status = status;
    }

    public int getId() { return id; }
    public String getNama() { return nama; }
    public String getAlamat() { return alamat; }
    public String getStatus() { return status; }
}