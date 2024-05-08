package assets.swing.cell.v;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author malco
 */
public class TableActionCellEditorV extends DefaultCellEditor {
    
    private final TableActionEventV event ;
    
    public TableActionCellEditorV(TableActionEventV event) {
        super(new JCheckBox());
        this.event = event;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PanelActionV action = new PanelActionV();
        action.initEvent(event, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
    
}
