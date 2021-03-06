package modelo;

public class Usuario {

    private Integer idUsuario;
    private String cui;
    private String nombre;
    private String telefono;
    private String estado;
    private String usuario;
    private String password;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String cui, String nombre, String telefono, String estado, String usuario, String password) {
        this.idUsuario = idUsuario;
        this.cui = cui;
        this.nombre = nombre;
        this.telefono = telefono;
        this.estado = estado;
        this.usuario = usuario;
        this.password = password;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
