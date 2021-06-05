package modelo;

import conexiones.Conexion;
import conexiones.Conexiones;
import conexiones.ConexionMysql;
import conexiones.ConexionOracle;
import conexiones.ConexionPosgre;
import conexiones.ConexionSQLITE;
import conexiones.ConexionSqlServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//public class UsuarioDAO extends ConexionSqlServer{
//public class UsuarioDAO extends ConexionMysql{
// public class UsuarioDAO extends ConexionOracle{
// public class UsuarioDAO extends ConexionPosgre{
//public class UsuarioDAO extends ConexionSQLITE{
public class UsuarioDAO extends Conexion{

    
     
    
    private String sql;
    private PreparedStatement ps;
    private String respuesta;
    private ResultSet rs;
    Usuario vend = new Usuario();

    public String registrarUsuario(Usuario usu) {
        try {
            this.conectar();
            sql = "insert into usuario(idUsuario, cui, nombre, telefono, estado, usuario, password)values(?,?,?,?,?,?,?);";
            ps = this.getMiConexion().prepareStatement(sql);
            ps.setInt(1, usu.getIdUsuario());
            ps.setString(2, usu.getCui());
            ps.setString(3, usu.getNombre());
            ps.setString(4, usu.getTelefono());
            ps.setString(5, usu.getEstado());
            ps.setString(6, usu.getUsuario());
            ps.setString(7, usu.getPassword());
            ps.executeUpdate();
            respuesta = "Registro almacenado correctamente !!";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            respuesta = "No se puede almacenar el registro";
        } finally {
           // this.cerrarConexion();
        }
        return respuesta;
    }//regist

    public Usuario validaUsuario(String usuario, String password) {
        try {
            this.conectar();
            sql = "select * from usuario where usuario=? and password=?";
            ps = this.getMiConexion().prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                vend.setIdUsuario(rs.getInt("idUsuario"));
                vend.setCui(rs.getString("cui"));
                vend.setNombre(rs.getString("nombre"));
                vend.setTelefono(rs.getString("telefono"));
                vend.setEstado(rs.getString("estado"));
                vend.setUsuario(rs.getString("usuario"));
                vend.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return vend;
    }//fn valida
    
    public String modificarUsuario(Usuario usuario) {
        try {
            this.conectar();
            sql = "update usuario set cui=?,nombre=?,telefono=?,estado=?,usuario=? where idusuario=?";
            ps = this.getMiConexion().prepareStatement(sql);
            ps.setString(1, usuario.getCui());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getTelefono());
            ps.setString(4, usuario.getEstado());
            ps.setString(5, usuario.getUsuario());
            ps.setInt(6, usuario.getIdUsuario());
            ps.executeUpdate();
            respuesta = "Registro modificado Correctamente!!";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            respuesta = "El registro no se puedo Modificar!!";
        } finally {
           // this.cerrarConexion();
        }

        return respuesta;
    }

    public String eliminarUsuario(int codigo) {
        try {
            this.conectar();
            sql = "delete from usuario where idusuario=?";
            ps = this.getMiConexion().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            respuesta = "Registro eliminado correctamente !!!";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            respuesta = "No se puede eliminar el regristro!!!";
        } finally {
            //this.cerrarConexion();
        }
        return respuesta;
    }

    public Usuario mostrarUsuario(int codigo) {
        Usuario usuario = new Usuario();
        try {
            this.conectar();
            sql = "select * from usuario where idusuario=?";
            ps = this.getMiConexion().prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            rs.next();
            usuario.setIdUsuario(rs.getInt("idusuario"));
            usuario.setCui(rs.getString("cui"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setTelefono(rs.getString("telefono"));
            usuario.setEstado(rs.getString("estado"));
            usuario.setUsuario(rs.getString("usuario"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //this.cerrarConexion();
        }
        return usuario;
    }

    public ArrayList<Usuario> listaPersona() {
        ArrayList<Usuario> lista = null;
        try {
            this.conectar();
            sql = "select * from usuario";
            ps = this.getMiConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idusuario"));
                usuario.setCui(rs.getString("cui"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setEstado(rs.getString("estado"));
                usuario.setUsuario(rs.getString("usuario"));
                lista.add(usuario);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //this.cerrarConexion();
        }
        return lista;
    }
    
    

}//clase
