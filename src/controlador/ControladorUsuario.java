package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.UsuarioDAO;
import modelo.Usuario;
import vista.PrincipalFormulario;
import vista.frmLogin;
import vista.frmUsuario;


public class ControladorUsuario implements ActionListener, MouseListener {

    frmLogin vlogin = new frmLogin();
    UsuarioDAO vDAO = new UsuarioDAO();
    Usuario usuario = new Usuario();
    frmUsuario vUsuario = new frmUsuario();

    public ControladorUsuario(frmLogin vlogin, UsuarioDAO vDAO, Usuario usuario, frmUsuario vUsuario) {
        this.vlogin = vlogin;
        this.vDAO = vDAO;
        this.usuario = usuario;
        this.vUsuario = vUsuario;
    }

    public ControladorUsuario(frmLogin login) {
        this.vlogin = login;
        this.vlogin.btnLogin.addActionListener(this);
        this.vlogin.btnRegresar.addActionListener(this);
    }

    public ControladorUsuario(frmUsuario vUsuario) {
        this.vUsuario = vUsuario;
        this.vUsuario.btnAgregar.addActionListener(this);
        this.vUsuario.btnLimpiar.addActionListener(this);
        this.vUsuario.btnModificar.addActionListener(this);
        this.vUsuario.btnEliminar.addActionListener(this);
        this.vUsuario.btnConsultar.addActionListener(this);
        this.llenarTabla(vUsuario.miTabla);
        this.vUsuario.miTabla.addMouseListener(this);
    }

    public void validar() {
        String user = vlogin.txtUsuario.getText();
        String pass = vlogin.txtPassword.getText();
        if (vlogin.txtUsuario.getText().equals("") || vlogin.txtPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "credenciales vacio intenta de nuevo ");
        } else {
            usuario = vDAO.validaUsuario(user, pass);
            System.out.println("user y pass " + user + " " + pass);
            if ((usuario.getUsuario() != null) && (usuario.getPassword() != null)) {
                PrincipalFormulario principal = new PrincipalFormulario();
                principal.setVisible(true);
                //dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un usuario y contraseña valida");
                vlogin.txtUsuario.requestFocus();
            }
        }
    }

    public void insertarUsuario() {
        usuario.setIdUsuario(Integer.parseInt(vUsuario.txtCodigo.getText()));
        usuario.setCui(vUsuario.txtCui.getText());
        usuario.setNombre(vUsuario.txtNombre.getText());
        usuario.setTelefono(vUsuario.txtTelefono.getText());
        usuario.setEstado(vUsuario.txtEstado.getText());
        usuario.setUsuario(vUsuario.txtUsuario.getText());
        usuario.setPassword(vUsuario.txtPassword.getText());
        String respuesta = vDAO.registrarUsuario(usuario);
        if (respuesta != null) {
            JOptionPane.showMessageDialog(null, "Usuario ingresado !");
        }
    }

    public void modificarUsuario() {
        usuario.setIdUsuario(Integer.parseInt(vUsuario.txtCodigo.getText()));
        usuario.setCui(vUsuario.txtCui.getText());
        usuario.setNombre(vUsuario.txtNombre.getText());
        usuario.setTelefono(vUsuario.txtTelefono.getText());
        usuario.setEstado(vUsuario.txtEstado.getText());
        usuario.setUsuario(vUsuario.txtUsuario.getText());
        String respuestaActualizar = vDAO.modificarUsuario(usuario);
        if (respuestaActualizar != null) {
            JOptionPane.showMessageDialog(null, respuestaActualizar);
            this.llenarTabla(vUsuario.miTabla);
            limpiar();

        }
    }

    public void eliminarUsuario() {
        usuario.setIdUsuario(Integer.parseInt(vUsuario.txtCodigo.getText()));
        String respuestaEliminar = vDAO.eliminarUsuario(usuario.getIdUsuario());
        this.llenarTabla(vUsuario.miTabla);
        if (respuestaEliminar != null) {
            JOptionPane.showMessageDialog(null, "Registro Eliminado Correctamente!!!");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "Registro no fue eliminado");
        }
    }

    public void mostrarUsuario() {
        usuario.setIdUsuario(Integer.parseInt(vUsuario.txtCodigo.getText()));
        usuario = vDAO.mostrarUsuario(usuario.getIdUsuario());
        vUsuario.txtCui.setText(usuario.getCui());
        vUsuario.txtNombre.setText(usuario.getNombre());
        vUsuario.txtTelefono.setText(usuario.getTelefono());
        vUsuario.txtEstado.setText(usuario.getEstado());
        vUsuario.txtUsuario.setText(usuario.getUsuario());

    }

    public void llenarTabla(JTable datoTabla) {
        DefaultTableModel modeloTable = new DefaultTableModel();
        datoTabla.setModel(modeloTable);
        modeloTable.addColumn("Codigo");
        modeloTable.addColumn("Cui");
        modeloTable.addColumn("Nombre");
        modeloTable.addColumn("Telefono");
        modeloTable.addColumn("Estado");
        modeloTable.addColumn("Usuario");
        Object[] columna = new Object[6];
        int numFilas = vDAO.listaPersona().size();
        for (int i = 0; i < numFilas; i++) {
            columna[0] = vDAO.listaPersona().get(i).getIdUsuario();
            columna[1] = vDAO.listaPersona().get(i).getCui();
            columna[2] = vDAO.listaPersona().get(i).getNombre();
            columna[3] = vDAO.listaPersona().get(i).getTelefono();
            columna[4] = vDAO.listaPersona().get(i).getEstado();
            columna[5] = vDAO.listaPersona().get(i).getUsuario();

            modeloTable.addRow(columna);

        }

    }

    public void limpiar() {
        vUsuario.txtCodigo.setText(null);
        vUsuario.txtCui.setText(null);
        vUsuario.txtNombre.setText(null);
        vUsuario.txtTelefono.setText(null);
        vUsuario.txtEstado.setText(null);
        vUsuario.txtUsuario.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vlogin.btnLogin) {
            validar();
        }
        if (e.getSource() == vUsuario.btnAgregar) {
            insertarUsuario();
        }
        if (e.getSource() == vUsuario.btnLimpiar) {
            limpiar();
        }
        if (e.getSource() == vUsuario.btnModificar) {
            modificarUsuario();
        }
        if (e.getSource() == vUsuario.btnEliminar) {
            eliminarUsuario();
        }
        if (e.getSource() == vUsuario.btnConsultar) {
            mostrarUsuario();

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        vUsuario.txtCodigo.setText(vUsuario.miTabla.getValueAt(vUsuario.miTabla.getSelectedRow(), 0).toString());
        vUsuario.txtCui.setText(vUsuario.miTabla.getValueAt(vUsuario.miTabla.getSelectedRow(), 1).toString());
        vUsuario.txtNombre.setText(vUsuario.miTabla.getValueAt(vUsuario.miTabla.getSelectedRow(), 2).toString());
        vUsuario.txtTelefono.setText(vUsuario.miTabla.getValueAt(vUsuario.miTabla.getSelectedRow(), 3).toString());
        vUsuario.txtEstado.setText(vUsuario.miTabla.getValueAt(vUsuario.miTabla.getSelectedRow(), 4).toString());
        vUsuario.txtUsuario.setText(vUsuario.miTabla.getValueAt(vUsuario.miTabla.getSelectedRow(), 5).toString());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
