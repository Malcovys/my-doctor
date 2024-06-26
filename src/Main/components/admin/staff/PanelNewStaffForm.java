package main.components.admin.staff;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.components.Message;
import main.controller.ControllerRole;
import main.controller.ControllerServices;
import main.controller.ControllerUser;
import main.views.MainView;

/**
 *
 * @author malco
 */
public class PanelNewStaffForm extends javax.swing.JPanel {

    private final MainView grandParent;
    
    /**
     * Creates new form PanelNewStaffForm
     * @param commande_back
     * @param grandParent
     */
    public PanelNewStaffForm(ActionListener commande_back, MainView grandParent) {
        initComponents();
        btn_cancel.addActionListener(commande_back);
        this.grandParent = grandParent;
        
        choiceFonction.add("---- list ----");
        try 
        {
            String[] listRole = ControllerRole.getRolesTitle();
            for(String role : listRole) 
            {
                choiceFonction.add(role);
            }
        } catch (SQLException ex) {
            grandParent.showMessage(Message.MessageType.ERROR, "Erreur: get list role");
            Logger.getLogger(PanelNewStaffForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        form_title = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        nameText = new javax.swing.JTextField();
        emailText = new javax.swing.JTextField();
        telephoneText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        choiceFonction = new java.awt.Choice();
        jLabel4 = new javax.swing.JLabel();
        btn_validate = new assets.swing.Button();
        btn_cancel = new assets.swing.Button();
        passwordText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setOpaque(false);

        form_title.setBackground(new java.awt.Color(255, 255, 255));
        form_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        form_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        form_title.setText("Nouveau personnel");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 20));

        nameText.setBackground(new java.awt.Color(242, 242, 242));

        emailText.setBackground(new java.awt.Color(242, 242, 242));

        telephoneText.setBackground(new java.awt.Color(242, 242, 242));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("Nom");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setText("Email");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("Téléphone");

        choiceFonction.setBackground(new java.awt.Color(242, 242, 242));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("Fonction");

        btn_validate.setBackground(new java.awt.Color(35, 166, 97));
        btn_validate.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_validate.setForeground(new java.awt.Color(255, 255, 255));
        btn_validate.setText("Confirmer");
        btn_validate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_validateActionPerformed(evt);
            }
        });

        btn_cancel.setBackground(new java.awt.Color(242, 242, 242));
        btn_cancel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_cancel.setText("Retour");

        passwordText.setBackground(new java.awt.Color(242, 242, 242));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("Mot de passe");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(form_title))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(emailText)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(choiceFonction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_cancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                                .addGap(244, 244, 244)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_validate, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5))))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(form_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(choiceFonction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_validate, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_validateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_validateActionPerformed
        if(!"".equals(nameText.getText()) && !"".equals(emailText.getText()) && !"".equals(telephoneText.getText()) && !"---- list ----".equals(choiceFonction.getSelectedItem()) && !"".equals(passwordText.getText()))
        {
            try {
                Integer.valueOf(telephoneText.getText().strip());
                try {
                    ControllerUser.createUser(nameText.getText(), emailText.getText().strip(), telephoneText.getText().strip(), choiceFonction.getSelectedItem(), passwordText.getText());
                    nameText.setText("");
                    emailText.setText("");
                    telephoneText.setText("");
                    passwordText.setText("");
                    choiceFonction.select(0);
                    grandParent.showMessage(Message.MessageType.SUCCESS, "Staff enregisté");
                } catch (SQLException ex) {
                    grandParent.showMessage(Message.MessageType.ERROR, "Erreur: insert user");
                    Logger.getLogger(PanelNewStaffForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (NumberFormatException e) {
                grandParent.showMessage(Message.MessageType.ERROR, "Erreur: telephone invalide");
            }
        }
        else 
        {
            grandParent.showMessage(Message.MessageType.ERROR, "Erreur: Les champs sont obligatoire");
        }
    }//GEN-LAST:event_btn_validateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private assets.swing.Button btn_cancel;
    private assets.swing.Button btn_validate;
    private java.awt.Choice choiceFonction;
    private javax.swing.JTextField emailText;
    private javax.swing.JLabel form_title;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField passwordText;
    private javax.swing.JTextField telephoneText;
    // End of variables declaration//GEN-END:variables
}
