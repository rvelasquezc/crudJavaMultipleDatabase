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

public class ConexionSQLITE {

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
            String ruta = "jdbc:sqlite:C:\\sqlite\\bdpfinal.sqlite";
            Class.forName("org.sqlite.JDBC");
            try {
                miConexion = DriverManager.getConnection(ruta);
            } catch (SQLException ex) {
                Logger.getLogger(Conexiones.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("La conexion se ha realizado satisfactoriamente.");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex + "No reconocio el driver");
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
