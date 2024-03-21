/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mydoctor.model;

/**
 *
 * @author malco
 */
public class Diagnostique {
    private String date;
    private String designation;
    
    public Diagnostique(String _designation, String _date){
        this.designation = _designation;
        this.date = _date;
    }
    
    public void enregistre(){}
    public void mettreAJour(){}
}
