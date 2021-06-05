package vista;

import conexiones.Conexiones;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class frmSelectDb extends javax.swing.JInternalFrame {

    FondoPanel fondo = new FondoPanel();

    public frmSelectDb() {
        this.setContentPane(fondo);
        setSize(700, 550);
        initComponents();
    }

    public static Connection sqlServerConn() {
        Connection conexion = null;
        try {
            String url = "jdbc:sqlserver://DESKTOP-08N77PA\\SQLEXPRESS\\SQLServerExpress:1433;"
                    + "database=bd_proyecto;"
                    + "user=sa;"
                    + "password=sa;";
            //Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url);
            System.out.println("Conexion exitosa");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return conexion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnMysql = new javax.swing.JButton();
        btnSqlserver = new javax.swing.JButton();
        btnPosgres = new javax.swing.JButton();
        btnSqlite = new javax.swing.JButton();
        btnOracle = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Seleccionar Base de Dato");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setText("VENTANA DE CONFIGURACION");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 204));
        jLabel2.setText("SELECCIONA BASE DE DATO");

        btnMysql.setText("mysql");
        btnMysql.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMysqlActionPerformed(evt);
            }
        });

        btnSqlserver.setText("sqlserver");
        btnSqlserver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSqlserverActionPerformed(evt);
            }
        });

        btnPosgres.setText("posgres");
        btnPosgres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPosgresActionPerformed(evt);
            }
        });

        btnSqlite.setText("sqlite");
        btnSqlite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSqliteActionPerformed(evt);
            }
        });

        btnOracle.setText("oracle");
        btnOracle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOracleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSqlite, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMysql, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOracle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSqlserver, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addComponent(btnPosgres, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(220, 220, 220))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(240, 240, 240))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMysql)
                    .addComponent(btnSqlserver)
                    .addComponent(btnPosgres))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSqlite)
                    .addComponent(btnOracle))
                .addContainerGap(229, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMysqlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMysqlActionPerformed
        
    }//GEN-LAST:event_btnMysqlActionPerformed

    private void btnSqlserverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSqlserverActionPerformed
        
    }//GEN-LAST:event_btnSqlserverActionPerformed

    private void btnPosgresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPosgresActionPerformed
        
    }//GEN-LAST:event_btnPosgresActionPerformed

    private void btnSqliteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSqliteActionPerformed
        
    }//GEN-LAST:event_btnSqliteActionPerformed

    private void btnOracleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOracleActionPerformed
        
    }//GEN-LAST:event_btnOracleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnMysql;
    public javax.swing.JButton btnOracle;
    public javax.swing.JButton btnPosgres;
    public javax.swing.JButton btnSqlite;
    public javax.swing.JButton btnSqlserver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/image/bg2.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);

            super.paint(g);

        }
    }
}
