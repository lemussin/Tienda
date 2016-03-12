package tienda.BLL;
import java.util.List;
import tienda.DAL.InicioDAL;
import tienda.Entidades.Producto;
public class InicioModel {
    
    public int registroUsuario(String nombre, String apellidoP, String apellidoM, String nombreUsuario, String password, String fNacimiento, String telefono, String email, int tipoUsuario)
    {
        InicioDAL id = new InicioDAL();
        return id.registroUsuario(nombre, apellidoP, apellidoM, nombreUsuario, password, fNacimiento, telefono, email, tipoUsuario);
    }
    
    public List<Producto> cargaProductos()
    {
        InicioDAL id = new InicioDAL();
        return id.cargaProductos();
    }
}
