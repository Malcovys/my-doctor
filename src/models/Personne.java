/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author malco
 */
public class Personne {
    protected String nom = "";
    protected String prenom = ""; 
    protected String email = "";
    protected String telephone = "";
    
    public void SetNom(String _nom){ this.nom = _nom; }
    public void SetPrenom(String _prenom){ this.prenom = _prenom; }
    public void SetEmail(String _email){ this.email = _email; }
    public void SetTelephone(String _telephone){ this.telephone = _telephone; }
}
