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

public class Conexion{

    //variable conexion darle alcance publico o estatico !!!!!!!!!!!!
    public static Connection miConexion = null;
    
   
    public static Connection getMiConexion() {
        return miConexion;
    }

    public void setMiConexion(Connection miConexion) {
        this.miConexion = miConexion;
    }

    public void conectar() {
        // <editor-fold defaultstate="collapsed" desc=" Default inicia con MySql ">
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
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc=" MySql ">
           /* try {
                String url = "jdbc:mysql://localhost/bd_proyecto";
                String user = "root";
                String password = "";
                Class.forName("com.mysql.jdbc.Driver");
                miConexion = (Connection) DriverManager.getConnection(url, user, password);
                System.out.println("Conexion exitosa");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            } */   
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc=" SQLServer ">
          /* try {
                String url = "jdbc:sqlserver://DESKTOP-08N77PA\\SQLEXPRESS\\SQLServerExpress:1433;"
                        + "database=bd_proyecto;"
                        + "user=sa;"
                        + "password=sa;";
                //Class.forName("com.mysql.jdbc.Driver");
                miConexion = (Connection) DriverManager.getConnection(url);
                System.out.println("Conexion exitosa");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }     */   
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc=" Posgres ">
           /* try {
                String url = "jdbc:postgresql://localhost:5432/bdpfinal";
                try {
                    Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
                }
                miConexion = (Connection) DriverManager.getConnection(url, "edgar","123");
                boolean valid = miConexion.isValid(50000);
                System.out.println(valid ? "TEST OK" : "TEST FAIL");
            } catch (java.sql.SQLException sqle) {
                System.out.println("Error: " + sqle);
            } */
           
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc=" SQLITE ">
          /* try {
                String ruta = "jdbc:sqlite:C:\\sqlite\\bdpfinal.sqlite";
                Class.forName("org.sqlite.JDBC");
                try {
                    miConexion = DriverManager.getConnection(ruta);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("La conexion se ha realizado satisfactoriamente.");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex + "No reconocio el driver");
            } */
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc=" ORACLE ">
           /*try {
                String url = "jdbc:oracle:thin:@localhost:1521:XE";
                //Se carga el driver JDBC
                Class.forName("oracle.jdbc.driver.OracleDriver");
                miConexion = DriverManager.getConnection(url, "edgar", "12345");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            } */ 
        // </editor-fold>
        
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
}
