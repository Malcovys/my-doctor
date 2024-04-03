/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

/**
 *
 * @author malco
 */
public class Facture {
    private String date = "";
    private float totale = 0f;
    private boolean envoye = false;
    
    public Facture(String _date){
        this.date = _date;
    }
    
    public void creer() {}
    private void calculerTotale(){}
    public void envoyer() {}
}
