package vista;

import com.sun.jndi.ldap.Connection;
import conexiones.Conexion;
import conexiones.Conexiones;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class frmKpi extends javax.swing.JInternalFrame {

    private String sql;
    private String respuesta;
    private PreparedStatement ps;
    private ResultSet rs;

    Conexion bd = new Conexion();

    FondoPanel fondo = new FondoPanel();

    public frmKpi() {
        this.setContentPane(fondo);
        initComponents();
        setSize(900, 650);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        miPanel = new javax.swing.JPanel();
        btnCircular = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Graficos");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("KPI  Y GRAFICOS ");

        btnConsultar.setText("Barra");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        miPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout miPanelLayout = new javax.swing.GroupLayout(miPanel);
        miPanel.setLayout(miPanelLayout);
        miPanelLayout.setHorizontalGroup(
            miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 844, Short.MAX_VALUE)
        );
        miPanelLayout.setVerticalGroup(
            miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        btnCircular.setText("Pastel");
        btnCircular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCircularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(miPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCircular, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(304, 304, 304))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar)
                    .addComponent(btnCircular))
                .addGap(4, 4, 4)
                .addComponent(miPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:

        try {

            sql = "SELECT COUNT(edad),\n"
                    + "CASE\n"
                    + "WHEN edad BETWEEN 0 AND 3 THEN 'Kinder'\n"
                    + "WHEN edad BETWEEN 4 AND 12 THEN 'Niños'\n"
                    + "WHEN edad BETWEEN 13 AND 18 THEN 'Adolescentes'\n"
                    + "WHEN edad BETWEEN 19 AND 35 THEN 'Jovenes'\n"
                    + "WHEN edad BETWEEN 36 AND 50 THEN 'Madurez'\n"
                    + "WHEN edad BETWEEN 51 AND 60 THEN 'Adulto Mayor'\n"
                    + "WHEN edad BETWEEN 61 AND 100 THEN 'Tercera Edad'\n"
                    + "ELSE 'Ninguno'\n"
                    + "END AS etapa\n"
                    + "FROM usuario\n"
                    + "GROUP BY etapa";
            System.out.println(" Consulta: " + sql);
            ps = bd.getMiConexion().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            while (rs.next()) {
                data.setValue(rs.getInt(1), rs.getString(2), String.valueOf(rs.getInt(1)));
            }

            JFreeChart cha = ChartFactory.createBarChart3D("Rango de Edades", "etapa", "porcentaje", data, PlotOrientation.VERTICAL, true, true, true);

            int alto = 600;
            int ancho = 750;

            ChartUtilities.writeChartAsPNG(out, cha, ancho, alto);

            //JPanel jPanel1 = new JPanel();
            miPanel.setLayout(new java.awt.BorderLayout());
            ChartPanel CP = new ChartPanel(cha);
            
            miPanel.add(CP,BorderLayout.CENTER);
            miPanel.validate();
            
            

            //Limpiar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnCircularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCircularActionPerformed
        // TODO add your handling code here:
        try {

            sql = "SELECT COUNT(edad),\n"
                    + "CASE\n"
                    + "WHEN edad BETWEEN 0 AND 3 THEN 'Kinder'\n"
                    + "WHEN edad BETWEEN 4 AND 12 THEN 'Niños'\n"
                    + "WHEN edad BETWEEN 13 AND 18 THEN 'Adolescentes'\n"
                    + "WHEN edad BETWEEN 19 AND 35 THEN 'Jovenes'\n"
                    + "WHEN edad BETWEEN 36 AND 50 THEN 'Madurez'\n"
                    + "WHEN edad BETWEEN 51 AND 60 THEN 'Adulto Mayor'\n"
                    + "WHEN edad BETWEEN 61 AND 100 THEN 'Tercera Edad'\n"
                    + "ELSE 'Ninguno'\n"
                    + "END AS etapa\n"
                    + "FROM usuario\n"
                    + "GROUP BY etapa";
            System.out.println(" Consulta: " + sql);
            ps = bd.getMiConexion().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            DefaultPieDataset data = new DefaultPieDataset();
            while (rs.next()) {
                data.setValue(rs.getString(2)+": "+String.valueOf(rs.getInt(1)), rs.getInt(1));
            }

            JFreeChart cha = ChartFactory.createPieChart3D("Rango de Edades",data, true, true, true);

            int alto = 600;
            int ancho = 750;

             final PiePlot3D plot = (PiePlot3D)cha.getPlot();
                    plot.setStartAngle(270);
                    plot.setForegroundAlpha(0.80f);
                    plot.setInteriorGap(0.03);
                    
                    ChartUtilities.writeChartAsPNG(out, cha, ancho, alto);

            //JPanel jPanel1 = new JPanel();
            miPanel.setLayout(new java.awt.BorderLayout());
            ChartPanel CP = new ChartPanel(cha);
            
            miPanel.add(CP,BorderLayout.CENTER);
            miPanel.validate();
            
            

            //Limpiar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnCircularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCircular;
    public javax.swing.JButton btnConsultar;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel miPanel;
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
