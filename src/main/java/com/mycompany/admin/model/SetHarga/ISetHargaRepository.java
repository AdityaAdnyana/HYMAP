/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.admin.model.SetHarga;

/**
 *
 * @author R9480
 */
public interface ISetHargaRepository {
    double getCurrentReferencePrice();
    boolean updateAllHarga(double hargaBaru);
}
