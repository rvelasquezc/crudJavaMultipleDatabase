package conexiones;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.PrincipalFormulario;
import vista.frmSelectDb;

public class ConexionMysql {

    //variable conexion darle alcance publico o estatico !!!!!!!!!!!!
    public static Connection miConexion = null;

    public Connection getMiConexion() {
        return miConexion;
    }

    public void setMiConexion(Connection miConexion) {
        this.miConexion = miConexion;
    }

    public void conectar() {
        try {
            String url = "jdbc:mysql://localhost/bd_proyecto";
            String user = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            miConexion = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Conexion exitosa");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }//fin conectar

    public void cerrarConexion() {
        try {
            if (miConexion != null) {
                if (miConexion.isClosed() == false) {
                    miConexion.close();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}//fn conexion
