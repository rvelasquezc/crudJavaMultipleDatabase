
package controlador;

import conexiones.Conexiones;
import static conexiones.ConexionSqlServer.miConexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import vista.PrincipalFormulario;
import vista.frmSelectDb;

/**
 *
 * @author DELL
 */
public class ControladorConexiones implements ActionListener{
    
    frmSelectDb selecBd = new frmSelectDb();
    
    public ControladorConexiones(frmSelectDb selecBd){
        this.selecBd = selecBd;
        this.selecBd.btnMysql.addActionListener(this);
        this.selecBd.btnSqlserver.addActionListener(this);
        this.selecBd.btnPosgres.addActionListener(this);
        this.selecBd.btnSqlite.addActionListener(this);
        this.selecBd.btnOracle.addActionListener(this);
    
    }
    
    

    //eventos de boton
    @Override
    public void actionPerformed(ActionEvent e) {
        
       //-----MYSQL------
        if (e.getSource() == selecBd.btnMysql) {
            
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
            //envia la conexion
           
            
            PrincipalFormulario principal = new PrincipalFormulario();
            principal.setVisible(true);

        }
        //-----SQL SERVER----
        if (e.getSource() == selecBd.btnSqlserver) {
            int op = 2;
            
            PrincipalFormulario principal = new PrincipalFormulario();
            principal.setVisible(true);

        }

        //-----POSGRES------
        if (e.getSource() == selecBd.btnPosgres) {
            int op = 3;
            
            PrincipalFormulario principal = new PrincipalFormulario();
            principal.setVisible(true);
        }

        //-----SQLITE-------
        if (e.getSource() == selecBd.btnSqlite) {
            int op = 4;
            
            PrincipalFormulario principal = new PrincipalFormulario();
            principal.setVisible(true);
        }

        //-----ORACLE------
        if (e.getSource() == selecBd.btnOracle) {
            int op = 5;
            
            PrincipalFormulario principal = new PrincipalFormulario();
            principal.setVisible(true);
        }
        
    }//fn eventos boton
    
}//fn clase principal
