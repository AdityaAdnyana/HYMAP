/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.admin.model.InfoPenjualan;

import java.util.Date;
import java.util.List;

/**
 *
 * @author R9480
 */
public interface IInfoPenjualanRepository {

    List<LaporanPenjualan> getLaporanByDate(Date date);

    boolean updateStatus(int id, String statusPengiriman, String statusPembayaran);
}
