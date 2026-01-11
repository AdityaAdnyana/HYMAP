/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin.view.AturJadwalPengiriman.TablleButton;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author Aditya
 */
public class TableActionCellRenderer extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1){
        Component com = super.getTableCellRendererComponent(jtable, o, bln1, bln1, TOP, SOUTH);
        
        PanelAction action = new PanelAction();
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}
