/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.model.kelola_data_sopir;

import java.util.List;

public interface ISopirRepository {
    List<Sopir> getAllSopir();
    boolean addSopir(Sopir sopir);
    boolean updateSopir(Sopir sopir);
    boolean deleteSopir(int id);
}
