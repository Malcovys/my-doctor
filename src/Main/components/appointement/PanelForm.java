package main.components.appointement;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.components.Message;
import main.controller.ControllerAppointment;
import main.controller.ControllerPatient;
import main.controller.ControllerServices;
import main.controller.ControllerUser;
import main.model.ModelPatient;
import main.views.MainView;

/**
 *
 * @author malco
 */
public class PanelForm extends javax.swing.JPanel {
    
    private final MainView grandParent;
    
    private final ModelPatient modelPatient;
    private boolean patientIsExist;
    
    private String initialtPatientfistName;
    private String initialPatientLastName;
    private String initialPatientEmail;
    private String initialPatientTelephone;
    private String defaultComboBoxValue;

    /**
     * Creates new form AppointementForm
     * @param commande_back
     * @param grandParent
     */
    public PanelForm(ActionListener commande_back, MainView grandParent) {
        this.grandParent = grandParent;
        this.modelPatient = new ModelPatient();
        this.patientIsExist = false;
        
        initComponents();
        init();
        initCommandeBack(commande_back);
    }
    
    private void init() {
        getInitialInputValues();
        initComboBox();
    }
    
    private void initComboBox() {
        defaultComboBoxValue = "---Liste---";
        choice_doctor.add(defaultComboBoxValue);
        choice_rdvReason.add(defaultComboBoxValue);
        try {
            String[] listService = ControllerServices.getAllServicesTitle();
            for (String service : listService) {
                choice_rdvReason.add(service);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PanelForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void getInitialInputValues() {
        initialtPatientfistName = patient_firstName.getText().strip();
        initialPatientLastName = patient_lastName.getText().strip();
        initialPatientTelephone = patient_telephone.getText().strip();
        initialPatientEmail = patient_email.getText().strip();
    }
    
    private void initCommandeBack(ActionListener commande_back) {
        btn_cancel.addActionListener(commande_back);
    }
    
    private boolean validateTextFields() {
        if(patient_firstName.getText().strip().equals(initialtPatientfistName)) {
            return false;
        }
        
        if(patient_lastName.getText().strip().equals(initialPatientLastName)) {
            return false;
        }
        
        if(patient_email.getText().strip().equals(initialPatientEmail)) {
            return false;
        }
        
        return true;
    }
    
    private boolean validateComboBox() {
        return !choice_rdvReason.getSelectedItem().equals(defaultComboBoxValue) && !choice_doctor.getSelectedItem().equals(defaultComboBoxValue);
    }
    
    private void setPatientData() {
        patient_email.setText(modelPatient.getEmail());
        patient_firstName.setText(modelPatient.getFirstName());
        patient_lastName.setText(modelPatient.getLastName());
    }
    
    private boolean validateTelephoneField() {
        try {
            Integer.valueOf(patient_telephone.getText().strip());
            return true;
        } catch (NumberFormatException e) {
            return  false;
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

        calandar = new assets.swing.datechooser.DateChooser();
        timePicker = new com.raven.swing.TimePicker();
        form_title = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        rdv = new javax.swing.JLabel();
        text_date = new javax.swing.JLabel();
        rdv_date = new javax.swing.JTextField();
        text_hour = new javax.swing.JLabel();
        rdv_hour = new javax.swing.JTextField();
        text_rdv_reason = new javax.swing.JLabel();
        choice_rdvReason = new java.awt.Choice();
        text_patient = new javax.swing.JLabel();
        patient_firstName = new javax.swing.JTextField();
        patient_lastName = new javax.swing.JTextField();
        patient_email = new javax.swing.JTextField();
        patient_telephone = new javax.swing.JTextField();
        text_doctor = new javax.swing.JLabel();
        choice_doctor = new java.awt.Choice();
        btn_cancel = new assets.swing.Button();
        btn_validate = new assets.swing.Button();
        jButton1 = new javax.swing.JButton();

        calandar.setForeground(new java.awt.Color(35, 166, 97));
        calandar.setTextRefernce(rdv_date);

        timePicker.setForeground(new java.awt.Color(35, 166, 97));
        timePicker.set24hourMode(true);
        timePicker.setDisplayText(rdv_hour);

        setBackground(new java.awt.Color(255, 255, 255));

        form_title.setBackground(new java.awt.Color(255, 255, 255));
        form_title.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        form_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        form_title.setText("Créer un nouveau rendez-vous");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 20));

        rdv.setBackground(new java.awt.Color(255, 255, 255));
        rdv.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        rdv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rdv.setText("Rendez-vous");

        text_date.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        text_date.setText("Date :");

        rdv_date.setBackground(new java.awt.Color(242, 242, 242));
        rdv_date.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        text_hour.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        text_hour.setText("Heure :");

        rdv_hour.setBackground(new java.awt.Color(242, 242, 242));
        rdv_hour.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        text_rdv_reason.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        text_rdv_reason.setText("Raison :");

        choice_rdvReason.setBackground(new java.awt.Color(242, 242, 242));

        text_patient.setBackground(new java.awt.Color(255, 255, 255));
        text_patient.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        text_patient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text_patient.setText("Patient");

        patient_firstName.setBackground(new java.awt.Color(242, 242, 242));
        patient_firstName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        patient_firstName.setText("Nom*");
        patient_firstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                patient_firstNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                patient_firstNameFocusLost(evt);
            }
        });

        patient_lastName.setBackground(new java.awt.Color(242, 242, 242));
        patient_lastName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        patient_lastName.setText("Prénom*");
        patient_lastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                patient_lastNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                patient_lastNameFocusLost(evt);
            }
        });

        patient_email.setBackground(new java.awt.Color(242, 242, 242));
        patient_email.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        patient_email.setText("E-mail*");
        patient_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                patient_emailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                patient_emailFocusLost(evt);
            }
        });

        patient_telephone.setBackground(new java.awt.Color(242, 242, 242));
        patient_telephone.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        patient_telephone.setText("Téléphone*");
        patient_telephone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                patient_telephoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                patient_telephoneFocusLost(evt);
            }
        });

        text_doctor.setBackground(new java.awt.Color(255, 255, 255));
        text_doctor.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        text_doctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text_doctor.setText("Dorteur");

        choice_doctor.setBackground(new java.awt.Color(242, 242, 242));
        choice_doctor.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        choice_doctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                choice_doctorMousePressed(evt);
            }
        });

        btn_cancel.setBackground(new java.awt.Color(242, 242, 242));
        btn_cancel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_cancel.setText("Retour");

        btn_validate.setBackground(new java.awt.Color(35, 166, 97));
        btn_validate.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_validate.setForeground(new java.awt.Color(255, 255, 255));
        btn_validate.setText("Confirmer");
        btn_validate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_validateActionPerformed(evt);
            }
        });

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(text_patient)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_validate, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(patient_firstName)
                                    .addComponent(patient_telephone))
                                .addGap(196, 196, 196)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(patient_email)
                                    .addComponent(patient_lastName)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(text_date)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdv_date, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(text_hour)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdv_hour, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(text_rdv_reason)
                                .addGap(12, 12, 12)
                                .addComponent(choice_rdvReason, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdv)
                            .addComponent(form_title)
                            .addComponent(choice_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_doctor))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(form_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdv_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdv_hour, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(text_date)
                        .addComponent(text_hour)
                        .addComponent(jButton1)
                        .addComponent(text_rdv_reason))
                    .addComponent(choice_rdvReason, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(text_patient)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patient_email, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patient_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patient_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patient_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(text_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(choice_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_validate, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_validateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_validateActionPerformed
        if(validateTextFields()) {
            if(validateTelephoneField()) {
                if(validateComboBox()) {
                    try {
                        if(!patientIsExist) {
                            this.modelPatient.setFirstName(patient_firstName.getText().strip());
                            this.modelPatient.setLastName(patient_lastName.getText().strip());
                            this.modelPatient.setEmail(patient_email.getText().strip());

                            ControllerPatient.savePatient(this.modelPatient);
                        }

                        String doctor = choice_doctor.getSelectedItem();
                        String date = rdv_date.getText().strip();
                        String hour = rdv_hour.getText().strip();
                        String reason = choice_rdvReason.getSelectedItem();

                        ControllerAppointment.createAppointementWith(this.modelPatient, doctor, date, hour, reason);

                        grandParent.showMessage(Message.MessageType.SUCCESS, "Enregistrement effectué");
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(PanelForm.class.getName()).log(Level.SEVERE, null, ex);
                        
                        grandParent.showMessage(Message.MessageType.ERROR, "Une erreur est survenue");
                    }
                } else {
                    grandParent.showMessage(Message.MessageType.ERROR, "Selection manquante");
                } 
            } else {
                grandParent.showMessage(Message.MessageType.ERROR, "Le champs téléphone ne peut contenir de lettres");
            }
        } else {
            grandParent.showMessage(Message.MessageType.ERROR, "Les champs sont obligatoires");
        }
        
    }//GEN-LAST:event_btn_validateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        timePicker.showPopup(this, 100, 100);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void patient_firstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_patient_firstNameFocusGained
        if(patient_firstName.getText().strip().equals(initialtPatientfistName)) {
            patient_firstName.setText("");
        }
    }//GEN-LAST:event_patient_firstNameFocusGained

    private void patient_lastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_patient_lastNameFocusGained
        if(patient_lastName.getText().strip().equals(initialPatientLastName)) {
            patient_lastName.setText("");
        }
    }//GEN-LAST:event_patient_lastNameFocusGained

    private void patient_emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_patient_emailFocusGained
        if(patient_email.getText().strip().equals(initialPatientEmail)) {
            patient_email.setText("");
        }
    }//GEN-LAST:event_patient_emailFocusGained

    private void patient_telephoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_patient_telephoneFocusGained
        if(patient_telephone.getText().strip().equals(initialPatientTelephone)) {
            patient_telephone.setText("");
        }
    }//GEN-LAST:event_patient_telephoneFocusGained

    private void patient_firstNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_patient_firstNameFocusLost
        if(patient_firstName.getText().strip().length() == 0) {
            patient_firstName.setText(initialtPatientfistName);
        }
    }//GEN-LAST:event_patient_firstNameFocusLost

    private void patient_lastNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_patient_lastNameFocusLost
        if(patient_lastName.getText().strip().length() == 0) {
            patient_lastName.setText(initialPatientLastName);
        }
    }//GEN-LAST:event_patient_lastNameFocusLost

    private void patient_emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_patient_emailFocusLost
        if(patient_email.getText().strip().length() == 0) {
            patient_email.setText(initialPatientEmail);
        }
    }//GEN-LAST:event_patient_emailFocusLost

    private void patient_telephoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_patient_telephoneFocusLost
        if(patient_telephone.getText().strip().length() == 0) {
            patient_telephone.setText(initialPatientTelephone);
        } else {
            if(validateTelephoneField()) {
                String telephone = patient_telephone.getText().strip();
                this.modelPatient.setTelephone(telephone);
                try {
                    patientIsExist = ControllerPatient.getPatientsByTelephone(this.modelPatient);
                    if(patientIsExist) { 
                        setPatientData();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(PanelForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_patient_telephoneFocusLost

    private void choice_doctorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choice_doctorMousePressed
        String[] freeDoctorsList = null;
        try {
            freeDoctorsList = ControllerUser.getFreeDoctor(rdv_date.getText().strip(), rdv_hour.getText().strip());

            if(freeDoctorsList.length == 0) {
                choice_doctor.removeAll();
                choice_doctor.add(defaultComboBoxValue);
                choice_doctor.add("Aucun docteur disponible");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(freeDoctorsList != null) {
            choice_doctor.removeAll();
            choice_doctor.add(defaultComboBoxValue);
            for (String doctorList : freeDoctorsList) {
                choice_doctor.add(doctorList);
            }
        }
    }//GEN-LAST:event_choice_doctorMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private assets.swing.Button btn_cancel;
    private assets.swing.Button btn_validate;
    private assets.swing.datechooser.DateChooser calandar;
    private java.awt.Choice choice_doctor;
    private java.awt.Choice choice_rdvReason;
    private javax.swing.JLabel form_title;
    private javax.swing.JButton jButton1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField patient_email;
    private javax.swing.JTextField patient_firstName;
    private javax.swing.JTextField patient_lastName;
    private javax.swing.JTextField patient_telephone;
    private javax.swing.JLabel rdv;
    private javax.swing.JTextField rdv_date;
    private javax.swing.JTextField rdv_hour;
    private javax.swing.JLabel text_date;
    private javax.swing.JLabel text_doctor;
    private javax.swing.JLabel text_hour;
    private javax.swing.JLabel text_patient;
    private javax.swing.JLabel text_rdv_reason;
    private com.raven.swing.TimePicker timePicker;
    // End of variables declaration//GEN-END:variables

}
