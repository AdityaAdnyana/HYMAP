/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.admin.model.AturJadwalPengiriman;

import java.util.List;

/**
 *
 * @author R9480
 */
public interface IJadwalRepository {

    List<Jadwal> getJadwalByArmada(String armada);

    boolean updateJadwal(Jadwal jadwal);
}
