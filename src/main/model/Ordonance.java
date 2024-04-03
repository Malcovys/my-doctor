/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

/**
 *
 * @author malco
 */
public class Ordonance {
    public String date = "";
    public String designation = "";
    public String description = "";
    
    public Ordonance(String _designation, String _description, String _date){
        this.designation = _designation;
        this.description = _description;
        this.date = _date;
    }
    
    public void enregister(){}
    public void mettreAJour(){}
}
