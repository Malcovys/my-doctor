package main.components.appointement;

import assets.swing.cell.TableActionCellEditor;
import assets.swing.cell.TableActionCellRender;
import assets.swing.cell.TableActionEvent;

/**
 *
 * @author malco
 */
public class PanelList extends javax.swing.JPanel {

    /**
     * Creates new form PanalList
     */
    public PanelList() {
        initComponents();
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit " + row);
            }

            @Override
            public void onDesable(int row) {
                System.out.println("Desable "  + row);
            }

            @Override
            public void onView(int row) {
                System.out.println("view "  + row);
            }
        };
        
        appoitementTable.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        appoitementTable.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choise_date = new java.awt.Choice();
        choise_patient = new java.awt.Choice();
        choice_doctor = new java.awt.Choice();
        jScrollPane1 = new javax.swing.JScrollPane();
        appoitementTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        choise_date.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        choise_date.setFocusable(false);
        choise_date.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        choise_patient.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        choise_patient.setFocusable(false);
        choise_patient.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        choice_doctor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        choice_doctor.setFocusable(false);
        choice_doctor.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        appoitementTable.setAutoCreateRowSorter(true);
        appoitementTable.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        appoitementTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "10/04/52", null, null, null, null, null}
            },
            new String [] {
                "ID", "Date", "Heure", "Patient", "Docteur", "Raison", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        appoitementTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        appoitementTable.setGridColor(new java.awt.Color(255, 255, 255));
        appoitementTable.setMinimumSize(new java.awt.Dimension(80, 80));
        appoitementTable.setName(""); // NOI18N
        appoitementTable.setPreferredSize(new java.awt.Dimension(120, 40));
        appoitementTable.setRowHeight(40);
        appoitementTable.setSelectionBackground(new java.awt.Color(35, 211, 137));
        appoitementTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        appoitementTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        appoitementTable.setShowGrid(false);
        jScrollPane1.setViewportView(appoitementTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(choise_date, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(choise_patient, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(choice_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 915, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choise_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choise_patient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choice_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable appoitementTable;
    private java.awt.Choice choice_doctor;
    private java.awt.Choice choise_date;
    private java.awt.Choice choise_patient;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
