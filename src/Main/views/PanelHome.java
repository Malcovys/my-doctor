package main.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import main.components.appointement.PaneltForm;
import main.components.appointement.PanelList;
import main.components.appointement.PanelView;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author malco
 */
public class PanelHome extends javax.swing.JPanel {
    
    private final MainView parent;
    
    private boolean btn_new_rdv_isActive;

    private PaneltForm RendezVousForm;
    private PanelList RendezVousList;
    private PanelView RendezVousView;
    
    private MigLayout layout;
    
    private final Color iniatlBtnNewRdvColor;
    private final Color focusBtnNewRdvColor;
    
    private final Color initalBtnNewRdvTextColor;
    private final Color focusBtnNewRdvTextColor;
    
    
    public PanelHome(MainView parent) {
        this.focusBtnNewRdvTextColor = Color.WHITE;
        this.initalBtnNewRdvTextColor = Color.BLACK;
        this.focusBtnNewRdvColor = new Color(35,166,97);
        this.iniatlBtnNewRdvColor = Color.WHITE;
        this.btn_new_rdv_isActive = false;
        this.parent = parent;
        initComponents();
        init();
    }
    
    private void init() {
        layout = new MigLayout("fill, insets 0");
        scene.setLayout(layout);
        setRendezVousListPanel();
    }
    
    
    /** ---------------------------- View Set ---------------------------- */
    private void setRendezVousListPanel() {
        if (RendezVousForm != null) {
            scene.remove(RendezVousForm);
            btn_new_rdv.setBackground(iniatlBtnNewRdvColor);
            btn_new_rdv.setForeground(initalBtnNewRdvTextColor);
        }
        if(RendezVousView != null) {
            scene.remove(RendezVousView);
        }
        RendezVousList = new PanelList(this.parent, this);
        scene.add(RendezVousList);
        scene.repaint();
        scene.revalidate();
    }
    private void setNewRendezVousFormPanel() {
        if(RendezVousList != null) {
            scene.remove(RendezVousList);
            btn_new_rdv.setBackground(focusBtnNewRdvColor);
            btn_new_rdv.setForeground(focusBtnNewRdvTextColor);
        }
        if(RendezVousView != null) {
            scene.remove(RendezVousView);
        }
        ActionListener commande_back;
        commande_back = (ActionEvent e) -> {
            setRendezVousListPanel();
            btn_new_rdv_isActive = false;
        };
        RendezVousForm = new PaneltForm(commande_back, this.parent);
        scene.add(RendezVousForm);
        scene.repaint();
        scene.revalidate();
    }
    public void setRendezVousViewPanel(Dictionary data) {
        if(RendezVousList != null) {
            scene.remove(RendezVousList);
        }
        ActionListener commande_back;
        commande_back = (ActionEvent e) -> {
            setRendezVousListPanel();
        };
        RendezVousView = new PanelView(this.parent, commande_back, data);
        scene.add(RendezVousView);
        scene.repaint();
        scene.revalidate();
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
                .addContainerGap())
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
        if(!btn_new_rdv_isActive) {
            setNewRendezVousFormPanel();
            btn_new_rdv_isActive = true;
        }
    }//GEN-LAST:event_btn_new_rdvActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HeandPane;
    private assets.swing.Button btn_new_rdv;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel scene;
    // End of variables declaration//GEN-END:variables
}
