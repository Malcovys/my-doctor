/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mydoctor;

import mydoctor.controller.Connexion;

/**
 *
 * @author malco
 */
public class MyDoctor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            var con = Connexion.connect(2, "123");
            System.out.println(con);
        } catch(Exception e){
            System.out.println("error");                 
        }
  
    }
        
       
        
    }
    
}
