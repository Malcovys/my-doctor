/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package main.views.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author malco
 */
public class PanelCover extends javax.swing.JPanel {
    
    private final Color bg = new Color(35, 166, 97);
    private final Color textForegroundColor = new Color(245,245,245);
    private final Font font = new Font("sansserif", 1, 30);
    private JLabel title;
    private JLabel description1;
    private JLabel description2;
    

    public PanelCover() {
        initComponents();
        setOpaque(false);
        MigLayout layout = new MigLayout("wrap, fill", "[center]", "push[]25[]10[]25[]push");
        setLayout(layout);
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void init(){
        title = new JLabel("Bonjour !");
        title.setFont(font);
        title.setForeground(textForegroundColor);
        add(title);
        
        description1 = new JLabel("Pour vous connecter,");
        description1.setForeground(textForegroundColor);
        add(description1);
        description2 = new JLabel("entrer vos informations personnelles");
        description2.setForeground(textForegroundColor);
        add(description2);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        GradientPaint paintGradient = new GradientPaint(0, 0, bg, 0, getHeight(),  bg);
        g2D.setPaint(paintGradient);
        g2D.fillRect(0, 0, getWidth(), getHeight());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
