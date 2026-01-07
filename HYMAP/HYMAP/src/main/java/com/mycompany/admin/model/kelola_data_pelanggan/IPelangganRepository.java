/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.model.kelola_data_pelanggan;

/**
 *
 * @author Aditya
 */

import java.util.List;

public interface IPelangganRepository {
    List<Pelanggan> getAllPelanggan();
    boolean addPelanggan(Pelanggan pelanggan);
     boolean updatePelanggan(Pelanggan pelanggan); // Tambahkan jika perlu
    // boolean deletePelanggan(int id); // Tambahkan jika perlu
}
