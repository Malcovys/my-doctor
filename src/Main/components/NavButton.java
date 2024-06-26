package main.components;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author malco
 */
public class NavButton extends javax.swing.JPanel {
    
    private Color sideBarColor = new Color(35,166,97);
    private Color navButtonColor = new Color(59,199,125);
    private Color navButtonColorFocus = new Color(148,215,162); 

    public NavButton() {
        initComponents();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_icon = new javax.swing.JLabel();
        label_text = new javax.swing.JLabel();

        setForeground(new java.awt.Color(255, 255, 255));

        label_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/home.png"))); // NOI18N

        label_text.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        label_text.setForeground(new java.awt.Color(255, 255, 255));
        label_text.setText("Home");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(label_text, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_text, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label_icon;
    private javax.swing.JLabel label_text;
    // End of variables declaration//GEN-END:variables

    public void setLabel_icon(JLabel label_icon) {
        this.label_icon = label_icon;
    }

    public void setLabel_text(JLabel label_text) {
        this.label_text = label_text;
    }
}
