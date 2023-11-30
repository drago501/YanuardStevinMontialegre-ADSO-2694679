/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

//import controlador.controlador_form;
//import vista.frm_RegistrarProducto;
//import vista.RegistrarFrm;
import vista.Menu1;

/**
 *
 * @author david
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    
   // public static vista.RegistrarFrm frm_rp;
    public static vista.Menu1 Menu1;
   // public static controlador.controlador_form c_frm_rp; 
    
    public static void main(String[] args) {
        
        Menu1 = new Menu1();
        
        Menu1.setVisible(true);

       // frm_rp = new RegistrarFrm();
        
       // frm_rp.setVisible(true);
        
       // frm_rp.setLocationRelativeTo(null);
                
        //c_frm_rp = new controlador_form(frm_rp);

    }
    
}