package main.components;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author malco
 */
public class Message extends javax.swing.JPanel {
    
    private MessageType messageType = MessageType.SUCCESS;
    private boolean show;  

    public void setShow(boolean show) {
        this.show = show;
    }

    public boolean isShow() {
        return show;
    }
    
    
    public void showMessage(MessageType messageType, String message){
        this.messageType = messageType;
        labelMessage.setText(message);
        
        if(messageType==MessageType.SUCCESS){
            labelMessage.setIcon(new ImageIcon(getClass().getResource("/assets/icons/success.png")));
        }else{
            labelMessage.setIcon(new ImageIcon(getClass().getResource("/assets/icons/error.png")));
        }
    }
    
    public Message() {
        initComponents();
        setOpaque(false);
        setVisible(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D graphics2D = (Graphics2D)g;
        
        if(messageType==MessageType.SUCCESS){
            graphics2D.setColor(new Color(15,174,31));
        }else{
            graphics2D.setColor(new Color(240,25,53));
        }
        
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));
        graphics2D.fillRect(0, 0, getWidth(), getHeight());
        graphics2D.setComposite(AlphaComposite.SrcOver);
        
        graphics2D.setColor(new Color(245,245,245));
        graphics2D.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        labelMessage = new javax.swing.JLabel();

        labelMessage.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        labelMessage.setForeground(new java.awt.Color(248, 248, 248));
        labelMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMessage.setText("Message");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>                        

    public static enum MessageType {
        SUCCESS, ERROR
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JLabel labelMessage;
    // End of variables declaration                   
}
