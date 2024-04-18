package main.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.components.appointement.PanelForm;
import main.components.appointement.PanelList;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author malco
 */
public class PanelHome extends javax.swing.JPanel {

    private PanelForm RendezVousForm;
    private PanelList RendezVousList;
    
    private MigLayout layout;
    
    private final Color iniatlBtnNewRdvColor = Color.WHITE;
    private final Color focusBtnNewRdvColor = new Color(35,166,97);
    
    private final Color initalBtnNewRdvTextColor = Color.BLACK;
    private final Color focusBtnNewRdvTextColor = Color.WHITE;
    
    
    public PanelHome() {
        initComponents();
        init();
    }
    
    private void init() {
        layout = new MigLayout("fill, insets 0");
        scene.setLayout(layout);
        
        setRendezVousListPanel();
    }
    
    private void setRendezVousListPanel() {
        if(RendezVousForm != null) {
            scene.remove(RendezVousForm);
            btn_new_rdv.setBackground(iniatlBtnNewRdvColor);
            btn_new_rdv.setForeground(initalBtnNewRdvTextColor);
        }
        
        RendezVousList = new PanelList();
        scene.add(RendezVousList);
        scene.repaint();
        scene.revalidate();
    }
    
    private void setNewRendezVousForm() throws SQLException {
        if(RendezVousList != null) {
            scene.remove(RendezVousList);
            btn_new_rdv.setBackground(focusBtnNewRdvColor);
            btn_new_rdv.setForeground(focusBtnNewRdvTextColor);
        }
        
        ActionListener commande_back;
        commande_back = (ActionEvent e) -> {
            setRendezVousListPanel();
        };
        
        ActionListener commande_createRendezVous;
        commande_createRendezVous = (ActionEvent e) -> {
            createAppoitment();
        };
        
        RendezVousForm = new PanelForm(commande_back, commande_createRendezVous);
        scene.add(RendezVousForm);
        scene.repaint();
        scene.revalidate();
    }
    
    private void createAppoitment() {
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HeandPane = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btn_new_rdv = new assets.swing.Button();
        scene = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        HeandPane.setBackground(new java.awt.Color(35, 211, 137));
        HeandPane.setPreferredSize(new java.awt.Dimension(965, 115));

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Rendez-vous");

        javax.swing.GroupLayout HeandPaneLayout = new javax.swing.GroupLayout(HeandPane);
        HeandPane.setLayout(HeandPaneLayout);
        HeandPaneLayout.setHorizontalGroup(
            HeandPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeandPaneLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeandPaneLayout.setVerticalGroup(
            HeandPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeandPaneLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel11)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        btn_new_rdv.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_new_rdv.setText("Nouveau");
        btn_new_rdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_new_rdvActionPerformed(evt);
            }
        });

        scene.setBackground(new java.awt.Color(255, 255, 255));
        scene.setOpaque(false);

        javax.swing.GroupLayout sceneLayout = new javax.swing.GroupLayout(scene);
        scene.setLayout(sceneLayout);
        sceneLayout.setHorizontalGroup(
            sceneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        sceneLayout.setVerticalGroup(
            sceneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(scene, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 822, Short.MAX_VALUE)
                        .addComponent(btn_new_rdv, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
            .addComponent(HeandPane, javax.swing.GroupLayout.DEFAULT_SIZE, 971, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(HeandPane, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_new_rdv, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_new_rdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_new_rdvActionPerformed
        try {
            setNewRendezVousForm();
        } catch (SQLException ex) {
            Logger.getLogger(PanelHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_new_rdvActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HeandPane;
    private assets.swing.Button btn_new_rdv;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel scene;
    // End of variables declaration//GEN-END:variables
}
