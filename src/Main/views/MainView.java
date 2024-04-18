package main.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JPanel;
import main.components.Message;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author malco
 */
public class MainView extends javax.swing.JPanel {

    private PanelHome Home;
    
    private JPanel activeNavButton;
    private final Color activeNavColor = new Color(148,215,162);
    private final Color navColor = new Color(59,199,125); 
    
    private MigLayout layout;
    private final float panelSize = 60f;
    
    
    public MainView() {
        initComponents();
        init();
    }
    
    private void init() {
        layout = new MigLayout("fill, insets 0");
        viewPanel.setLayout(layout);
        
        nagigateTo(btn_home);
    }
    
    private void nagigateTo(JPanel nav_btn) {
        if(nav_btn == btn_home) {
            Home = new PanelHome();
            viewPanel.add(Home, "width " + panelSize + "%, pos 0al 0 n 100%");
            
        }
        else if (nav_btn == btn_facture) {
            viewPanel.remove(Home);
        }
        
        focusNav(nav_btn);
        
        viewPanel.repaint();
        viewPanel.revalidate();
    }
    
    private void focusNav(JPanel btn)
    {
        if(activeNavButton != null) {
            activeNavButton.setBackground(navColor);
        }
        btn.setBackground(activeNavColor);
        activeNavButton = btn;
    }
    
    public void showMessage(Message.MessageType messageType, String message){
        Message ms = new Message();
        ms.showMessage(messageType, message);
     
        TimingTarget showMessageBehavior = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if(!ms.isShow())
                {
                    viewPanel.add(ms, "pos 0.5al -30", 0);
                    ms.setVisible(true);
                    ms.setShow(true);
                    viewPanel.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                if(ms.isShow()){
                    float movement = 40 * fraction;

                    layout.setComponentConstraints(ms, "pos 0.5al " +  + (int)(movement - 30));
                    viewPanel.repaint();
                    viewPanel.revalidate();
                }
            }
        };
        
        TimingTarget unShowMessageBehavior = new TimingTargetAdapter() {

            @Override
            public void timingEvent(float fraction) {
                if(ms.isShow()){
                    float movement = 40 * (1f - fraction); //faction : 0 -> 1

                    layout.setComponentConstraints(ms, "pos 0.5al " +  + (int)(movement - 30));
                    viewPanel.repaint();
                    viewPanel.revalidate();
                }
            }

            @Override
            public void end() {
                if(ms.isShow()) {
                   ms.setShow(false);
                   viewPanel.remove(ms);
                   viewPanel.repaint();
                   viewPanel.revalidate();
                }  
            } 
        };
        
        Animator showMessageBehaviorAnimator = new Animator(350, showMessageBehavior);
        showMessageBehaviorAnimator.setResolution(0);
        showMessageBehaviorAnimator.setAcceleration(0.5f);
        showMessageBehaviorAnimator.setDeceleration(0.5f);
        showMessageBehaviorAnimator.start();
        
        Thread unShowMessage = new Thread(() -> {
            try {
                Thread.sleep(2000);
                
                Animator unShowMessageBehaviorAnimator = new Animator(350, unShowMessageBehavior);
                
                unShowMessageBehaviorAnimator.setResolution(0);
                unShowMessageBehaviorAnimator.setAcceleration(0.5f);
                unShowMessageBehaviorAnimator.setDeceleration(0.5f);
                
                unShowMessageBehaviorAnimator.start();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        });
        
        unShowMessage.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btn_home = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        label_text = new javax.swing.JLabel();
        btn_facture = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        label_text1 = new javax.swing.JLabel();
        btn_rapport = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        label_text2 = new javax.swing.JLabel();
        btn_admin = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        label_text3 = new javax.swing.JLabel();
        viewPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 500));

        sidePanel.setBackground(new java.awt.Color(35, 166, 97));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MyDoctor");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_home.setBackground(new java.awt.Color(59, 199, 125));
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_homeMousePressed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/home.png"))); // NOI18N

        label_text.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        label_text.setForeground(new java.awt.Color(255, 255, 255));
        label_text.setText("Home");

        javax.swing.GroupLayout btn_homeLayout = new javax.swing.GroupLayout(btn_home);
        btn_home.setLayout(btn_homeLayout);
        btn_homeLayout.setHorizontalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_homeLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(label_text, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        btn_homeLayout.setVerticalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btn_homeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_text, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_facture.setBackground(new java.awt.Color(59, 199, 125));
        btn_facture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_factureMousePressed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/usd-circle.png"))); // NOI18N

        label_text1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        label_text1.setForeground(new java.awt.Color(255, 255, 255));
        label_text1.setText("Facture");

        javax.swing.GroupLayout btn_factureLayout = new javax.swing.GroupLayout(btn_facture);
        btn_facture.setLayout(btn_factureLayout);
        btn_factureLayout.setHorizontalGroup(
            btn_factureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_factureLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(label_text1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        btn_factureLayout.setVerticalGroup(
            btn_factureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btn_factureLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_text1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_rapport.setBackground(new java.awt.Color(59, 199, 125));
        btn_rapport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_rapportMousePressed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/document.png"))); // NOI18N

        label_text2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        label_text2.setForeground(new java.awt.Color(255, 255, 255));
        label_text2.setText("Rapport");

        javax.swing.GroupLayout btn_rapportLayout = new javax.swing.GroupLayout(btn_rapport);
        btn_rapport.setLayout(btn_rapportLayout);
        btn_rapportLayout.setHorizontalGroup(
            btn_rapportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_rapportLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(label_text2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        btn_rapportLayout.setVerticalGroup(
            btn_rapportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btn_rapportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_text2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_admin.setBackground(new java.awt.Color(59, 199, 125));
        btn_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_adminMousePressed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/users.png"))); // NOI18N

        label_text3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        label_text3.setForeground(new java.awt.Color(255, 255, 255));
        label_text3.setText("Administration");

        javax.swing.GroupLayout btn_adminLayout = new javax.swing.GroupLayout(btn_admin);
        btn_admin.setLayout(btn_adminLayout);
        btn_adminLayout.setHorizontalGroup(
            btn_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_adminLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(label_text3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        btn_adminLayout.setVerticalGroup(
            btn_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btn_adminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_text3, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1))
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_facture, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_rapport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_admin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_facture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_rapport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(287, Short.MAX_VALUE))
        );

        viewPanel.setBackground(new java.awt.Color(255, 255, 255));
        viewPanel.setOpaque(false);

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 835, Short.MAX_VALUE)
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(3, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMousePressed
        nagigateTo(btn_home);
    }//GEN-LAST:event_btn_homeMousePressed

    private void btn_factureMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_factureMousePressed
        nagigateTo(btn_facture);
    }//GEN-LAST:event_btn_factureMousePressed

    private void btn_rapportMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_rapportMousePressed
        nagigateTo(btn_rapport);
    }//GEN-LAST:event_btn_rapportMousePressed

    private void btn_adminMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_adminMousePressed
        nagigateTo(btn_admin);
    }//GEN-LAST:event_btn_adminMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_admin;
    private javax.swing.JPanel btn_facture;
    private javax.swing.JPanel btn_home;
    private javax.swing.JPanel btn_rapport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_text;
    private javax.swing.JLabel label_text1;
    private javax.swing.JLabel label_text2;
    private javax.swing.JLabel label_text3;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
