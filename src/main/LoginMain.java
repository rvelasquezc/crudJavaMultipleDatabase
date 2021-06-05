package main;

import controlador.ControladorUsuario;
import vista.frmLogin;



public class LoginMain {

    public static void main(String[] args) {
        frmLogin login = new frmLogin();       
        ControladorUsuario ctrl = new ControladorUsuario(login);
        
         login.setVisible(true);
         
         
    }
    
}
