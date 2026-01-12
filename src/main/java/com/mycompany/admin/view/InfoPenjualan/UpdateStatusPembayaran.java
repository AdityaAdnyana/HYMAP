package com.mycompany.admin.view.InfoPenjualan;

import com.mycompany.admin.model.InfoPenjualan.LaporanPenjualan;
import com.mycompany.admin.view.InfoPenjualan.TableAddButton.StatusPembayaran.TableActionCellEditor;
import com.mycompany.admin.view.InfoPenjualan.TableAddButton.StatusPembayaran.TableActionCellRenderer;
import com.mycompany.admin.view.InfoPenjualan.TableAddButton.StatusPembayaran.TableActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class UpdateStatusPembayaran extends javax.swing.JFrame {
    
    public UpdateStatusPembayaran() {
        initComponents();
        this.setLocationRelativeTo(null);
        jDateChooser3.setDate(new Date());
    }
    
    // Setup kolom aksi (tombol edit di tabel)
    public void setTableAction(TableActionEvent event) {
        table.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRenderer());
        table.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
    }
    
    public void setTableData(List<LaporanPenjualan> data) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        for (LaporanPenjualan p : data) {
            model.addRow(new Object[]{
                p.getId(),
                p.getNama(),
                p.getAlamat(),
                p.getStatusPengiriman(),
                p.getStatusPembayaran()
            });
        }
    }

    public javax.swing.JTable getTable() {
        return table;
    }

    public Date getSelectedDate() {
        return jDateChooser3.getDate();
    }
    
    public void addDateChangeListener(PropertyChangeListener listener) {
        jDateChooser3.addPropertyChangeListener("date", listener);
    }
    
    public void addMenuListener(java.awt.event.ActionListener listener) {
        MENU_BUTTON.addActionListener(listener);
    }


// Ganti juga metode setupTombolStatusPengiriman() Anda agar sesuai dengan nilai ENUM di DB

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MAIN_PANEL = new javax.swing.JPanel();
        MENU_BUTTON = new javax.swing.JButton();
        HeaderD1 = new javax.swing.JPanel();
        HeaderU1 = new javax.swing.JPanel();
        HeaderD = new javax.swing.JPanel();
        HeaderU = new javax.swing.JPanel();
        HeaderD2 = new javax.swing.JPanel();
        HeaderU2 = new javax.swing.JPanel();
        UPDATE_STATUS_PEMBAYARAN_PANEL = new javax.swing.JPanel();
        UPDATE_STATUS_PEMBAYARAN_TEXT_PANEL = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();

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
            .addGap(0, 0, Short.MAX_VALUE)
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
                .addComponent(HeaderU, 0, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        HeaderD2.setBackground(new java.awt.Color(44, 97, 116));
        HeaderD2.setMaximumSize(new java.awt.Dimension(1920, 26));
        HeaderD2.setMinimumSize(new java.awt.Dimension(960, 0));
        HeaderD2.setPreferredSize(new java.awt.Dimension(375, 52));

        HeaderU2.setBackground(new java.awt.Color(46, 86, 103));
        HeaderU2.setMaximumSize(new java.awt.Dimension(1920, 26));
        HeaderU2.setMinimumSize(new java.awt.Dimension(960, 0));
        HeaderU2.setPreferredSize(new java.awt.Dimension(375, 26));

        javax.swing.GroupLayout HeaderU2Layout = new javax.swing.GroupLayout(HeaderU2);
        HeaderU2.setLayout(HeaderU2Layout);
        HeaderU2Layout.setHorizontalGroup(
            HeaderU2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        HeaderU2Layout.setVerticalGroup(
            HeaderU2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout HeaderD2Layout = new javax.swing.GroupLayout(HeaderD2);
        HeaderD2.setLayout(HeaderD2Layout);
        HeaderD2Layout.setHorizontalGroup(
            HeaderD2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HeaderU2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
        );
        HeaderD2Layout.setVerticalGroup(
            HeaderD2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderD2Layout.createSequentialGroup()
                .addComponent(HeaderU2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        UPDATE_STATUS_PEMBAYARAN_PANEL.setBackground(new java.awt.Color(205, 228, 223));

        UPDATE_STATUS_PEMBAYARAN_TEXT_PANEL.setBackground(new java.awt.Color(55, 119, 142));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Update Status Pembayaran");

        javax.swing.GroupLayout UPDATE_STATUS_PEMBAYARAN_TEXT_PANELLayout = new javax.swing.GroupLayout(UPDATE_STATUS_PEMBAYARAN_TEXT_PANEL);
        UPDATE_STATUS_PEMBAYARAN_TEXT_PANEL.setLayout(UPDATE_STATUS_PEMBAYARAN_TEXT_PANELLayout);
        UPDATE_STATUS_PEMBAYARAN_TEXT_PANELLayout.setHorizontalGroup(
            UPDATE_STATUS_PEMBAYARAN_TEXT_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPDATE_STATUS_PEMBAYARAN_TEXT_PANELLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UPDATE_STATUS_PEMBAYARAN_TEXT_PANELLayout.setVerticalGroup(
            UPDATE_STATUS_PEMBAYARAN_TEXT_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPDATE_STATUS_PEMBAYARAN_TEXT_PANELLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nama", "Alamat", "Status Pengiriman", "Status Pembayaran", "Aksi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(30);
        table.setSelectionBackground(new java.awt.Color(227, 227, 227));
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(5);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(50);
            table.getColumnModel().getColumn(4).setPreferredWidth(50);
            table.getColumnModel().getColumn(5).setPreferredWidth(5);
        }

        jPanel5.setBackground(new java.awt.Color(55, 119, 142));

        jButton5.setText("<");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText(">");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton6)
                        .addComponent(jButton5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout UPDATE_STATUS_PEMBAYARAN_PANELLayout = new javax.swing.GroupLayout(UPDATE_STATUS_PEMBAYARAN_PANEL);
        UPDATE_STATUS_PEMBAYARAN_PANEL.setLayout(UPDATE_STATUS_PEMBAYARAN_PANELLayout);
        UPDATE_STATUS_PEMBAYARAN_PANELLayout.setHorizontalGroup(
            UPDATE_STATUS_PEMBAYARAN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPDATE_STATUS_PEMBAYARAN_PANELLayout.createSequentialGroup()
                .addGroup(UPDATE_STATUS_PEMBAYARAN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UPDATE_STATUS_PEMBAYARAN_PANELLayout.createSequentialGroup()
                        .addComponent(UPDATE_STATUS_PEMBAYARAN_TEXT_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UPDATE_STATUS_PEMBAYARAN_PANELLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)))
                .addContainerGap())
        );
        UPDATE_STATUS_PEMBAYARAN_PANELLayout.setVerticalGroup(
            UPDATE_STATUS_PEMBAYARAN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPDATE_STATUS_PEMBAYARAN_PANELLayout.createSequentialGroup()
                .addGroup(UPDATE_STATUS_PEMBAYARAN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(UPDATE_STATUS_PEMBAYARAN_TEXT_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout MAIN_PANELLayout = new javax.swing.GroupLayout(MAIN_PANEL);
        MAIN_PANEL.setLayout(MAIN_PANELLayout);
        MAIN_PANELLayout.setHorizontalGroup(
            MAIN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HeaderD1, javax.swing.GroupLayout.PREFERRED_SIZE, 1037, Short.MAX_VALUE)
            .addComponent(HeaderD2, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
            .addGroup(MAIN_PANELLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MENU_BUTTON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UPDATE_STATUS_PEMBAYARAN_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(HeaderD, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        MAIN_PANELLayout.setVerticalGroup(
            MAIN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MAIN_PANELLayout.createSequentialGroup()
                .addComponent(HeaderD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MAIN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MAIN_PANELLayout.createSequentialGroup()
                        .addComponent(MENU_BUTTON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(267, 267, 267)
                        .addComponent(HeaderD, 0, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(UPDATE_STATUS_PEMBAYARAN_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(HeaderD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MAIN_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MAIN_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void MENU_BUTTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MENU_BUTTONActionPerformed

    }//GEN-LAST:event_MENU_BUTTONActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateStatusPembayaran().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HeaderD;
    private javax.swing.JPanel HeaderD1;
    private javax.swing.JPanel HeaderD2;
    private javax.swing.JPanel HeaderU;
    private javax.swing.JPanel HeaderU1;
    private javax.swing.JPanel HeaderU2;
    private javax.swing.JPanel MAIN_PANEL;
    private javax.swing.JButton MENU_BUTTON;
    private javax.swing.JPanel UPDATE_STATUS_PEMBAYARAN_PANEL;
    private javax.swing.JPanel UPDATE_STATUS_PEMBAYARAN_TEXT_PANEL;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
