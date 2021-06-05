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

public class Conexiones implements ActionListener {

    public frmSelectDb vistaSelectDb = new frmSelectDb();
    
    public Conexiones(frmSelectDb vistaSelectDb){
    this.vistaSelectDb = vistaSelectDb;
    this.vistaSelectDb.btnMysql.addActionListener(this);
    this.vistaSelectDb.btnSqlserver.addActionListener(this);
    this.vistaSelectDb.btnPosgres.addActionListener(this);
    this.vistaSelectDb.btnSqlite.addActionListener(this);
    this.vistaSelectDb.btnOracle.addActionListener(this);
    } 
    
    
    
    public static int opcion = 0;
    //variable conexion darle alcance publico o estatico !!!!!!!!!!!!
    public static Connection miConexion = null;
    
   
    public static Connection getMiConexion() {
        return miConexion;
    }

    public Conexiones() {
       
    }

    public void setMiConexion(Connection miConexion) {
        this.miConexion = miConexion;
    }

    public Connection conectar() {
        // <editor-fold defaultstate="collapsed" desc=" Default inicia con MySql ">
        if (opcion == 0) {
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
            return miConexion;
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc=" MySql ">
        if (opcion == 1) {
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
            return miConexion;
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc=" SQLServer ">
        if (opcion == 2) {
            try {
                String url = "jdbc:sqlserver://DESKTOP-08N77PA\\SQLEXPRESS\\SQLServerExpress:1433;"
                        + "database=bd_proyecto;"
                        + "user=sa;"
                        + "password=sa;";
                //Class.forName("com.mysql.jdbc.Driver");
                miConexion = (Connection) DriverManager.getConnection(url);
                System.out.println("Conexion exitosa");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            return miConexion;
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc=" Posgres ">
        if (opcion == 3) {
            try {
                String url = "jdbc:postgresql://localhost:5432/bdpfinal";
                String user = "edgar";
                String password = "123";
                try {
                    Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
                }
                miConexion = (Connection) DriverManager.getConnection(url, user, password);
                System.out.println("Conexion exitosa");
                boolean valid = miConexion.isValid(50000);
                System.out.println(valid ? "TEST OK" : "TEST FAIL");
            } catch (java.sql.SQLException sqle) {
                System.out.println("Error: " + sqle);
            }
            return miConexion;
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc=" SQLITE ">
        if (opcion == 4) {
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
            return miConexion;
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc=" ORACLE ">
        if (opcion == 5) {
            try {
                String url = "jdbc:oracle:thin:@localhost:1521:XE";
                //Se carga el driver JDBC
                Class.forName("oracle.jdbc.driver.OracleDriver");
                miConexion = DriverManager.getConnection(url, "edgar", "12345");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            return miConexion;
        }
        // </editor-fold>
        return miConexion;

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

    public int valor = 0;

    @Override
    public void actionPerformed(ActionEvent e) {

        //-----MYSQL------
        if (e.getSource() == vistaSelectDb.btnMysql) {
            int op = 1;
            opcion = op;
            PrincipalFormulario principal = new PrincipalFormulario();
            principal.setVisible(true);

        }
        //-----SQL SERVER----
        if (e.getSource() == vistaSelectDb.btnSqlserver) {
            int op = 2;
            opcion = op;
            PrincipalFormulario principal = new PrincipalFormulario();
            principal.setVisible(true);

        }

        //-----POSGRES------
        if (e.getSource() == vistaSelectDb.btnPosgres) {
            int op = 3;
            opcion = op;
            PrincipalFormulario principal = new PrincipalFormulario();
            principal.setVisible(true);
        }

        //-----SQLITE-------
        if (e.getSource() == vistaSelectDb.btnSqlite) {
            int op = 4;
            opcion = op;
            PrincipalFormulario principal = new PrincipalFormulario();
            principal.setVisible(true);
        }

        //-----ORACLE------
        if (e.getSource() == vistaSelectDb.btnOracle) {
            int op = 5;
            opcion = op;
            PrincipalFormulario principal = new PrincipalFormulario();
            principal.setVisible(true);
        }

       // opcion = valor;
    }//Eventos
    //opcion = opcion;
}
