/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

/**
 *
 * @author malco
 */
public class Medecin extends Utilisateur {
    private String specialite = "";
    
    public Medecin(String _specialite){ this.specialite = _specialite; }
    
    public void enregistrer()
    {
        //sql request
    }
}
