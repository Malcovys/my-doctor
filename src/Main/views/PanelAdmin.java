package main.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.components.admin.PanelAdminHome;
import main.components.admin.service.PanelListService;
import main.components.admin.service.PanelNewServiceForm;
import main.components.admin.staff.PanelListStaff;
import main.components.admin.staff.PanelNewStaffForm;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author malco
 */
public class PanelAdmin extends javax.swing.JPanel {
    
    private final MainView parent;
    
    private PanelAdminHome AdminHome;
    private PanelListStaff ListStaff;
    private PanelListService ListService;
    private PanelNewServiceForm NewServiceForm;
    private PanelNewStaffForm NewStaffForm;
    
    /**
     * Creates new form PanelAdmin
     * @param parent
     */
    public PanelAdmin(MainView parent) {
        initComponents();
        
        this.parent = parent;
        
        MigLayout layout = new MigLayout("fill, insets 0");
        scene.setLayout(layout);
        
        setAdminHomePanel();
    }
    
    
    private void setAdminHomePanel() {
        AdminHome = new PanelAdminHome(this);
        scene.add(AdminHome);
        scene.repaint();
        scene.revalidate();
    }
    public void setListStaffPanel() {
        ActionListener commande_back;
        commande_back = (ActionEvent e) -> {
            scene.remove(ListStaff);
            setAdminHomePanel();
        };
        scene.remove(AdminHome);
        ListStaff = new PanelListStaff(commande_back, parent);
        scene.add(ListStaff);
        scene.repaint();
        scene.revalidate();
    }
    public void setNewStaffFormPanel() {
        ActionListener commande_back;
        commande_back = (ActionEvent e) -> {
            scene.remove(NewStaffForm);
            setAdminHomePanel();
        };
        scene.remove(AdminHome);
        NewStaffForm = new PanelNewStaffForm(commande_back, parent);
        scene.add(NewStaffForm);
        scene.repaint();
        scene.revalidate();
    }
    public void setListServicePanel() {
        ActionListener commande_back;
        commande_back = (ActionEvent e) -> {
            scene.remove(ListService);
            setAdminHomePanel();
        };
        scene.remove(AdminHome);
        ListService = new PanelListService(commande_back, parent);
        scene.add(ListService);
        scene.repaint();
        scene.revalidate();
    }
    public void setNewServiceFormPanel() {
        ActionListener commande_back;
        commande_back = (ActionEvent e) -> {
            scene.remove(NewServiceForm);
            setAdminHomePanel();
        };
        scene.remove(AdminHome);
        NewServiceForm = new PanelNewServiceForm(commande_back, parent);
        scene.add(NewServiceForm);
        scene.repaint();
        scene.revalidate();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HeandPane = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        scene = new javax.swing.JPanel();

        setOpaque(false);

        HeandPane.setBackground(new java.awt.Color(35, 211, 137));
        HeandPane.setPreferredSize(new java.awt.Dimension(965, 115));

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Administration");

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

        scene.setBackground(new java.awt.Color(255, 255, 255));
        scene.setOpaque(false);

        javax.swing.GroupLayout sceneLayout = new javax.swing.GroupLayout(scene);
        scene.setLayout(sceneLayout);
        sceneLayout.setHorizontalGroup(
            sceneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 977, Short.MAX_VALUE)
        );
        sceneLayout.setVerticalGroup(
            sceneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HeandPane, javax.swing.GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE)
            .addComponent(scene, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(HeandPane, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scene, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HeandPane;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel scene;
    // End of variables declaration//GEN-END:variables
}
