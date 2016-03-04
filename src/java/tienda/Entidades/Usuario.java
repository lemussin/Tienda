package tienda.Entidades;
/**
 *
 * @author leze667231
 */
public class Usuario {
    double id;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String usuario;
    String password;
    String fechaNac;
    String telefono;
    String email;
    int tipoUsuario;
    int permiso;
        
    public Usuario(String nombre, int permiso) {
        this.nombre = nombre;
        this.permiso = permiso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPermiso() {
        return permiso;
    }

    public void setPermiso(int permiso) {
        this.permiso = permiso;
    }

    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, String usuario, String password, String fechaNac, String telefono, String email, int tipoUsuario, int permiso) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.usuario = usuario;
        this.password = password;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        this.permiso = permiso;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
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

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }
    
    public Usuario() {
    }
}
