package com.mycompany.admin.view.InfoPenjualan;

import com.mycompany.admin.model.InfoPenjualan.LaporanPenjualan;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

public class CetakLaporan extends javax.swing.JFrame {

    public CetakLaporan() {
        initComponents();
        this.setLocationRelativeTo(null);
        // Set tanggal hari ini default
        jDateChooser1.setDate(new Date()); 
    }

    public void setTableData(List<LaporanPenjualan> data) {
        DefaultTableModel model = (DefaultTableModel) tableLaporan.getModel();
        model.setRowCount(0);
        
        for (LaporanPenjualan p : data) {
            model.addRow(new Object[]{
                p.getId(),
                p.getNama(),
                p.getAlamat(),
                p.getJumlahGalon(),
                p.getHargaPerGalon(),
                p.getTotalHarga(),
                p.getStatusPengiriman(),
                p.getStatusPembayaran(),
                p.getTglUpdate() // Tgl update/filter
            });
        }
    }
    
    public Date getSelectedDate() {
        return jDateChooser1.getDate();
    }
    
    // Listener untuk perubahan tanggal
    public void addDateChangeListener(PropertyChangeListener listener) {
        jDateChooser1.addPropertyChangeListener("date", listener);
    }
    
    // Listener Tombol Navigasi Tanggal (< >)
    public void addPrevDateListener(java.awt.event.ActionListener listener) {
        jButton1.addActionListener(listener);
    }
    
    public void addNextDateListener(java.awt.event.ActionListener listener) {
        jButton2.addActionListener(listener);
    }
    
    public void setDate(Date date) {
        jDateChooser1.setDate(date);
    }

    public void addMenuListener(java.awt.event.ActionListener listener) {
        MENU_BUTTON.addActionListener(listener);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HeaderD1 = new javax.swing.JPanel();
        HeaderU1 = new javax.swing.JPanel();
        MAIN_PANEL = new javax.swing.JPanel();
        MENU_BUTTON = new javax.swing.JButton();
        CETAK_LAPORAN_PANEL = new javax.swing.JPanel();
        CETAK_LAPORAN_TEXT_PANEL = new javax.swing.JPanel();
        CETAK_LAPORAN_TEXT = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLaporan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        HeaderD = new javax.swing.JPanel();
        HeaderU = new javax.swing.JPanel();

        HeaderD1.setBackground(new java.awt.Color(44, 97, 116));
        HeaderD1.setMaximumSize(new java.awt.Dimension(1920, 26));
        HeaderD1.setMinimumSize(new java.awt.Dimension(1920, 0));
        HeaderD1.setPreferredSize(new java.awt.Dimension(375, 52));

        HeaderU1.setBackground(new java.awt.Color(46, 86, 103));
        HeaderU1.setMaximumSize(new java.awt.Dimension(1920, 26));
        HeaderU1.setMinimumSize(new java.awt.Dimension(1920, 0));
        HeaderU1.setPreferredSize(new java.awt.Dimension(375, 26));

        javax.swing.GroupLayout HeaderU1Layout = new javax.swing.GroupLayout(HeaderU1);
        HeaderU1.setLayout(HeaderU1Layout);
        HeaderU1Layout.setHorizontalGroup(
            HeaderU1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1920, Short.MAX_VALUE)
        );
        HeaderU1Layout.setVerticalGroup(
            HeaderU1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout HeaderD1Layout = new javax.swing.GroupLayout(HeaderD1);
        HeaderD1.setLayout(HeaderD1Layout);
        HeaderD1Layout.setHorizontalGroup(
            HeaderD1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderD1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(HeaderU1, javax.swing.GroupLayout.PREFERRED_SIZE, 1920, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        HeaderD1Layout.setVerticalGroup(
            HeaderD1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderD1Layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addComponent(HeaderU1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MAIN_PANEL.setBackground(new java.awt.Color(172, 210, 202));
        MAIN_PANEL.setPreferredSize(new java.awt.Dimension(960, 540));

        MENU_BUTTON.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ASSET/Menu_Dark.png"))); // NOI18N
        MENU_BUTTON.setInheritsPopupMenu(true);
        MENU_BUTTON.setPreferredSize(new java.awt.Dimension(55, 55));
        MENU_BUTTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MENU_BUTTONActionPerformed(evt);
            }
        });

        CETAK_LAPORAN_TEXT_PANEL.setBackground(new java.awt.Color(55, 119, 142));

        CETAK_LAPORAN_TEXT.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        CETAK_LAPORAN_TEXT.setForeground(new java.awt.Color(255, 255, 255));
        CETAK_LAPORAN_TEXT.setText("Cetak Laporan");

        javax.swing.GroupLayout CETAK_LAPORAN_TEXT_PANELLayout = new javax.swing.GroupLayout(CETAK_LAPORAN_TEXT_PANEL);
        CETAK_LAPORAN_TEXT_PANEL.setLayout(CETAK_LAPORAN_TEXT_PANELLayout);
        CETAK_LAPORAN_TEXT_PANELLayout.setHorizontalGroup(
            CETAK_LAPORAN_TEXT_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CETAK_LAPORAN_TEXT_PANELLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(CETAK_LAPORAN_TEXT)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        CETAK_LAPORAN_TEXT_PANELLayout.setVerticalGroup(
            CETAK_LAPORAN_TEXT_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CETAK_LAPORAN_TEXT_PANELLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CETAK_LAPORAN_TEXT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tableLaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nama", "Alamat", "Jumlah Pesanan", "Harga Satuan", "Total Harga", "Status Pengiriman", "Status Pembayaran", "Tgl Update Akhir"
            }
        ));
        jScrollPane1.setViewportView(tableLaporan);
        if (tableLaporan.getColumnModel().getColumnCount() > 0) {
            tableLaporan.getColumnModel().getColumn(7).setResizable(false);
            tableLaporan.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel3.setBackground(new java.awt.Color(55, 119, 142));

        jButton1.setText("<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText(">");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton2)
                        .addComponent(jButton1))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout CETAK_LAPORAN_PANELLayout = new javax.swing.GroupLayout(CETAK_LAPORAN_PANEL);
        CETAK_LAPORAN_PANEL.setLayout(CETAK_LAPORAN_PANELLayout);
        CETAK_LAPORAN_PANELLayout.setHorizontalGroup(
            CETAK_LAPORAN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CETAK_LAPORAN_PANELLayout.createSequentialGroup()
                .addGroup(CETAK_LAPORAN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CETAK_LAPORAN_PANELLayout.createSequentialGroup()
                        .addComponent(CETAK_LAPORAN_TEXT_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CETAK_LAPORAN_PANELLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)))
                .addContainerGap())
        );
        CETAK_LAPORAN_PANELLayout.setVerticalGroup(
            CETAK_LAPORAN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CETAK_LAPORAN_PANELLayout.createSequentialGroup()
                .addGroup(CETAK_LAPORAN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CETAK_LAPORAN_TEXT_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CETAK_LAPORAN_PANELLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        HeaderD.setBackground(new java.awt.Color(44, 97, 116));
        HeaderD.setMaximumSize(new java.awt.Dimension(1920, 26));
        HeaderD.setMinimumSize(new java.awt.Dimension(1920, 0));
        HeaderD.setPreferredSize(new java.awt.Dimension(375, 52));

        HeaderU.setBackground(new java.awt.Color(46, 86, 103));
        HeaderU.setMaximumSize(new java.awt.Dimension(1920, 26));
        HeaderU.setMinimumSize(new java.awt.Dimension(1920, 0));
        HeaderU.setPreferredSize(new java.awt.Dimension(375, 26));

        javax.swing.GroupLayout HeaderULayout = new javax.swing.GroupLayout(HeaderU);
        HeaderU.setLayout(HeaderULayout);
        HeaderULayout.setHorizontalGroup(
            HeaderULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        HeaderULayout.setVerticalGroup(
            HeaderULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout HeaderDLayout = new javax.swing.GroupLayout(HeaderD);
        HeaderD.setLayout(HeaderDLayout);
        HeaderDLayout.setHorizontalGroup(
            HeaderDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HeaderU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1920, Short.MAX_VALUE)
        );
        HeaderDLayout.setVerticalGroup(
            HeaderDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderDLayout.createSequentialGroup()
                .addComponent(HeaderU, javax.swing.GroupLayout.DEFAULT_SIZE, 5, Short.MAX_VALUE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MAIN_PANELLayout = new javax.swing.GroupLayout(MAIN_PANEL);
        MAIN_PANEL.setLayout(MAIN_PANELLayout);
        MAIN_PANELLayout.setHorizontalGroup(
            MAIN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HeaderD, javax.swing.GroupLayout.PREFERRED_SIZE, 960, Short.MAX_VALUE)
            .addGroup(MAIN_PANELLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MENU_BUTTON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(899, Short.MAX_VALUE))
            .addComponent(CETAK_LAPORAN_PANEL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MAIN_PANELLayout.setVerticalGroup(
            MAIN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MAIN_PANELLayout.createSequentialGroup()
                .addComponent(HeaderD, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MENU_BUTTON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CETAK_LAPORAN_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MAIN_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MAIN_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MENU_BUTTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MENU_BUTTONActionPerformed

    }//GEN-LAST:event_MENU_BUTTONActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CetakLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CetakLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CetakLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CetakLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CetakLaporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CETAK_LAPORAN_PANEL;
    private javax.swing.JLabel CETAK_LAPORAN_TEXT;
    private javax.swing.JPanel CETAK_LAPORAN_TEXT_PANEL;
    private javax.swing.JPanel HeaderD;
    private javax.swing.JPanel HeaderD1;
    private javax.swing.JPanel HeaderU;
    private javax.swing.JPanel HeaderU1;
    private javax.swing.JPanel MAIN_PANEL;
    private javax.swing.JButton MENU_BUTTON;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableLaporan;
    // End of variables declaration//GEN-END:variables
}
