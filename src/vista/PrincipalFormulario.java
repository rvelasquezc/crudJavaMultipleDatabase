package vista;


import controlador.ControladorUsuario;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;


public class PrincipalFormulario extends javax.swing.JFrame {
    
    public PrincipalFormulario() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane(){
            public void paint(Graphics g) {
                Image imagen = new ImageIcon(getClass().getResource("/image/planogreen.png")).getImage();
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
                setOpaque(false);
                super.paint(g);
            }

        };
        menuBar = new javax.swing.JMenuBar();
        mnuMenu = new javax.swing.JMenu();
        mnuAyuda = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenuItem();
        mnuVentas = new javax.swing.JMenu();
        mnuGenerarVenta = new javax.swing.JMenuItem();
        mnuMantenimiento = new javax.swing.JMenu();
        mnuCliente = new javax.swing.JMenuItem();
        mnuReportes = new javax.swing.JMenu();
        mnuReportesVentas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnuMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home.png"))); // NOI18N
        mnuMenu.setMnemonic('f');
        mnuMenu.setText("Menu");
        mnuMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMenuActionPerformed(evt);
            }
        });

        mnuAyuda.setMnemonic('o');
        mnuAyuda.setText("Ayuda");
        mnuMenu.add(mnuAyuda);

        mnuSalir.setMnemonic('x');
        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        mnuMenu.add(mnuSalir);

        menuBar.add(mnuMenu);

        mnuVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconobd.png"))); // NOI18N
        mnuVentas.setMnemonic('e');
        mnuVentas.setText("BD");

        mnuGenerarVenta.setMnemonic('t');
        mnuGenerarVenta.setText("Base de dato");
        mnuGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGenerarVentaActionPerformed(evt);
            }
        });
        mnuVentas.add(mnuGenerarVenta);

        menuBar.add(mnuVentas);

        mnuMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logomantenimiento.png"))); // NOI18N
        mnuMantenimiento.setMnemonic('h');
        mnuMantenimiento.setText("Mantenimiento");
        mnuMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantenimientoActionPerformed(evt);
            }
        });

        mnuCliente.setMnemonic('c');
        mnuCliente.setText("Usuario");
        mnuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClienteActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mnuCliente);

        menuBar.add(mnuMantenimiento);

        mnuReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reportes.png"))); // NOI18N
        mnuReportes.setText("Graficos");
        mnuReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuReportesActionPerformed(evt);
            }
        });

        mnuReportesVentas.setText("Kpi");
        mnuReportesVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuReportesVentasActionPerformed(evt);
            }
        });
        mnuReportes.add(mnuReportesVentas);

        menuBar.add(mnuReportes);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGenerarVentaActionPerformed
        frmSelectDb select = new frmSelectDb();
        centrarVentana(select);

    }//GEN-LAST:event_mnuGenerarVentaActionPerformed

    private void mnuMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantenimientoActionPerformed


    }//GEN-LAST:event_mnuMantenimientoActionPerformed

    private void mnuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClienteActionPerformed
        frmUsuario usuario = new frmUsuario();
        ControladorUsuario ctrl = new ControladorUsuario(usuario);
        centrarVentana(usuario);
    }//GEN-LAST:event_mnuClienteActionPerformed

    private void mnuReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuReportesActionPerformed

    }//GEN-LAST:event_mnuReportesActionPerformed

    private void mnuMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuMenuActionPerformed

    private void mnuReportesVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuReportesVentasActionPerformed
        // TODO add your handling code here:
        frmKpi kpi = new frmKpi();
        centrarVentana(kpi);
    }//GEN-LAST:event_mnuReportesVentasActionPerformed
    public void centrarVentana(JInternalFrame frame) {
        desktopPane.add(frame);
        Dimension fprincipal = desktopPane.getSize();
        Dimension dimVentasF = frame.getSize();
        frame.setLocation((fprincipal.width - dimVentasF.width) / 2, (fprincipal.height - dimVentasF.height) / 2);
        frame.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalFormulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mnuAyuda;
    private javax.swing.JMenuItem mnuCliente;
    private javax.swing.JMenuItem mnuGenerarVenta;
    private javax.swing.JMenu mnuMantenimiento;
    private javax.swing.JMenu mnuMenu;
    private javax.swing.JMenu mnuReportes;
    private javax.swing.JMenuItem mnuReportesVentas;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenu mnuVentas;
    // End of variables declaration//GEN-END:variables
    
}
