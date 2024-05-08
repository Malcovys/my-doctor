package main.components.appointement;

import assets.swing.cell.ecc.TableActionCellEditorECC;
import assets.swing.cell.ecc.TableActionCellRenderECC;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import main.components.Message;
import main.controller.ControllerAppointment;
import main.controller.ControllerStatus;
import main.model.ModelStatus;
import main.views.MainView;
import assets.swing.cell.ecc.TableActionEventECC;
import assets.swing.cell.v.TableActionCellEditorV;
import assets.swing.cell.v.TableActionCellRenderV;
import assets.swing.cell.v.TableActionEventV;

/**
 *
 * @author malco
 */
public class PanelList extends javax.swing.JPanel {

    private final MainView grandParent;
            
    private Dictionary[] appoitementList;
    private TableActionEventECC tableActionEventECC;
    private TableActionEventV tableActionEventV;
    private DefaultTableModel tableModel;
    private String[] statusList;
    
    /**
     * Creates new form PanalList
     * @param grandParent
     * @throws java.sql.SQLException
     */
    public PanelList(MainView grandParent) throws SQLException {
        initComponents();
        
        this.grandParent = grandParent;        
        tableModel = (DefaultTableModel) jTable1.getModel(); // pour l'inction des actions
        
        
        tableActionEventECC = new TableActionEventECC() {
                @Override
                public void onEdit(int row) {
                    System.out.println("Edit " + row);
                }
                
                @Override
                public void onComplete(int row) {
                    try {
                        ControllerAppointment.setSatusComplete(Integer.parseInt(appoitementList[row].get("id").toString()));
                        setUpcomingAppoitementListToTable();
                        grandParent.showMessage(Message.MessageType.SUCCESS, "Modification effectué");
                    } catch (SQLException ex) {
                        grandParent.showMessage(Message.MessageType.ERROR, "Ereur: OnComplet event");
                        Logger.getLogger(PanelList.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                @Override
                public void onCancel(int row) {
                    System.out.println("annuler "  + row);
                }
        };
        
        
        tableActionEventV = new TableActionEventV() {
            @Override
            public void onView(int row) {
                System.out.println("voir");
            }
        };
        
        setStatusInChoice_statusCombobox();
        navigateByChoice_status(choice_status.getSelectedItem());
    }
    
    
    /* --------------------------- Combobox ----------------------------------- */ 
    private void setStatusInChoice_statusCombobox(){ // var used: statusList, choice_status, grandParent
        try {
            statusList = ControllerStatus.getAllStatus();
            for(String status : statusList) { choice_status.add(status); }
            ModelStatus modelStatus = new ModelStatus();
            modelStatus.setUpcoming();
            choice_status.select(modelStatus.getStatus());
        } catch (SQLException ex) {
            grandParent.showMessage(Message.MessageType.ERROR, "Erreur: setStatusInChoice_statusCombobox");
            Logger.getLogger(PanelList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    
    /* --------------------------- Tables management ----------------------------------- */ 
    private void setAppoitementListToTable() { //var used : tableModel et appoitementList
        while (tableModel.getRowCount() > 0) { tableModel.removeRow(0); }
        for(Dictionary appoitementInfo : appoitementList){
            tableModel.addRow(new Object[]{ 
                appoitementInfo.get("id"), 
                appoitementInfo.get("date"), 
                appoitementInfo.get("hour"),
                appoitementInfo.get("patientFirstName")+" "+appoitementInfo.get("patientLastName"),
                appoitementInfo.get("doctor"),
                appoitementInfo.get("reason"),
                appoitementInfo.get("status")
            });
        }     
    }
    private void setUpcomingAppoitementListToTable() throws SQLException { //var used : appoitementList
        ModelStatus modelStatus = new ModelStatus();
        modelStatus.setUpcoming();
        appoitementList = ControllerAppointment.getAppoitementListOfStatus(modelStatus);   
        setAppoitementListToTable();
    }
    private void setCompletedAppoitementToTable() throws SQLException { //var used : appoitementList
        ModelStatus modelStatus = new ModelStatus();
        modelStatus.setComplete();
        appoitementList = ControllerAppointment.getAppoitementListOfStatus(modelStatus);  
        setAppoitementListToTable();
    }
    
    
    /* --------------------------- Navigator By Choice_status ----------------------------------- */ 
    private void navigateByChoice_status(String choice_statusSelectedItem ) { // var used : grandParent
        switch (choice_statusSelectedItem) {
            case "à venir" -> {
                    try {
                        setUpcomingAppoitementListToTable();
                        // les actions sur la colone Action
                        jTable1.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRenderECC()); // le visuel
                        jTable1.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditorECC(tableActionEventECC));// les events 
                    } catch (SQLException ex) {
                        grandParent.showMessage(Message.MessageType.ERROR, "Erreur: case à venir");
                        Logger.getLogger(PanelList.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            case "terminer" -> {
                    try {  
                        setCompletedAppoitementToTable();
                        // les actions sur la colone Action
                        jTable1.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRenderV()); // le visuel
                        jTable1.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditorV(tableActionEventV));// les events 
                    } catch (SQLException ex) {
                        grandParent.showMessage(Message.MessageType.ERROR, "Erreur: case terminer");
                        Logger.getLogger(PanelList.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            case "annuler" -> System.out.println("annuler");
            default -> throw new AssertionError();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choice_status = new java.awt.Choice();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        choice_status.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        choice_status.setFocusable(false);
        choice_status.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        choice_status.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choice_statusItemStateChanged(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date", "Heure", "Patient", "Docteur", "Raison", "Statut", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(40);
        jTable1.setSelectionBackground(new java.awt.Color(35, 166, 97));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(jTable1);

        jLabel1.setText("Statut :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 927, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(choice_status, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(choice_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    /* --------------------------- Events actions ----------------------------------- */ 
    private void choice_statusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choice_statusItemStateChanged
        navigateByChoice_status(choice_status.getSelectedItem()); // var used : choice_status
    }//GEN-LAST:event_choice_statusItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choice_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
