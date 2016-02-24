package tienda.Entidades;
/**
 *
 * @author leze667231
 */
public class Usuario {
    String nombre;
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
}
