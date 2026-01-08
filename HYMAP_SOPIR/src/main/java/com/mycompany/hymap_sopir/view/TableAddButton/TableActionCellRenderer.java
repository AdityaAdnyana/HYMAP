package Sopir.TableAddButton;

import java.awt.Component;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableActionCellRenderer extends DefaultTableCellRenderer {
    
     @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
        PanelAction action = new PanelAction();

        Color background = isSelected ? jtable.getSelectionBackground() : jtable.getBackground();
        if (!isSelected && row % 2 != 0) {
            background = new Color(240, 240, 240);
        }
        
        action.setBackground(background);
        for(Component c : action.getComponents()){
            c.setBackground(background);
        }

        if (o != null) {
            action.setStatus(o.toString()); //
        }

        return action;
    }
}