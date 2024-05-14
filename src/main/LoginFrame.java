package main;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JLayeredPane;
import main.components.Message;
import main.components.login.PanelCover;
import main.components.PanelLoading;
import main.components.login.PanelLogin;
import main.connection.DatabaseConnection;
import main.services.ServiceUser;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
/**
 *
 * @author malco
 */
public class LoginFrame extends javax.swing.JFrame {
    
    private MigLayout layout;
    private PanelLoading loading;
    private PanelCover cover;
    private final float coverSize = 40f;
    private PanelLogin login;
    private final float loginSize = 60f; 
    
    private  ServiceUser service;
    private AppFrame App;

    public LoginFrame() {
        initComponents();
        init();
    }
    
    private void init(){
        service = new ServiceUser();
        
        layout = new MigLayout("fill, insets 0");
        bg.setLayout(layout);
        
        loading = new PanelLoading();
        bg.add(loading, "pos 0 0 100% 100%");
        
        cover = new PanelCover();
        bg.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");
        
        ActionListener loginCommande;
        loginCommande = (ActionEvent e) -> {
            login();
        };
        login = new PanelLogin(loginCommande);
        bg.setLayer(loading, JLayeredPane.POPUP_LAYER);
        bg.add(login, "width " + loginSize + "%, pos 1al 0 n 100%");
    }
    
    private void setAppFrame() {
        App = new AppFrame();
        App.setVisible(true);
        dispose();
    }
    
    private void login(){
        loading.setVisible(true);
        String email = login.getEmail();
        String password = login.getPassword();
        
        try {
            if(service.authUser(email, password)) {
                loading.setVisible(false);
                showMessage(Message.MessageType.SUCCESS, "Authentified");
                
                setAppFrame();
                
            } else {
                loading.setVisible(false);
                showMessage(Message.MessageType.ERROR, "Unauthentified");
            }
        } catch (SQLException e) {
            loading.setVisible(false);
            showMessage(Message.MessageType.ERROR, "Error auth");
            System.err.println(e);
        }
    }
    
    private void showMessage(Message.MessageType messageType, String message){
        Message ms = new Message();
        ms.showMessage(messageType, message);
     
        TimingTarget showMessageBehavior = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if(!ms.isShow())
                {
                    bg.add(ms, "pos 0.5al -30", 0);
                    ms.setVisible(true);
                    ms.setShow(true);
                    bg.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                if(ms.isShow()){
                    float movement = 40 * fraction;

                    layout.setComponentConstraints(ms, "pos 0.5al " +  + (int)(movement - 30));
                    bg.repaint();
                    bg.revalidate();
                }
            }
        };
        
        TimingTarget unShowMessageBehavior = new TimingTargetAdapter() {

            @Override
            public void timingEvent(float fraction) {
                if(ms.isShow()){
                    float movement = 40 * (1f - fraction); //faction : 0 -> 1

                    layout.setComponentConstraints(ms, "pos 0.5al " +  + (int)(movement - 30));
                    bg.repaint();
                    bg.revalidate();
                }
            }

            @Override
            public void end() {
                if(ms.isShow()) {
                   ms.setShow(false);
                   bg.remove(ms);
                   bg.repaint();
                   bg.revalidate();
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

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
        
        try {
            DatabaseConnection.getInstance().connectToDatabase();
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}