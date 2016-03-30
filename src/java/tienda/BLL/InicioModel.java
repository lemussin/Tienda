package tienda.BLL;
import java.util.List;
import tienda.DAL.InicioDAL;
import tienda.Entidades.Color;
import tienda.Entidades.Marca;
import tienda.Entidades.Mercancia;
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
    
    public List<Marca> cargaMarcas()
    {
        InicioDAL id = new InicioDAL();
        return id.cargaMarcas();
    }
    
    public List<Color> cargaColores()
    {
        InicioDAL id = new InicioDAL();
        return id.cargaColores();
    }
    
    public int registroMercancias(double idMercancia, double idGenero, int cantidad, double idMarca, double idColorBase, double precio, String descripcion, String fecha, double idUsuario, String nombreMercancia)
    {
        InicioDAL id = new InicioDAL();
        return id.registroMercancias(idMercancia, idGenero, cantidad, idMarca, idColorBase, precio, descripcion, fecha, idUsuario, nombreMercancia);
    }
    
    public List<Mercancia> cargaMercancias()
    {
        InicioDAL id = new InicioDAL();
        return id.cargaMercancias();
    }
    
    public Mercancia cargaProductoModificar(double idProdMod)
    {
        InicioDAL id = new InicioDAL();
        return id.cargaProductoModificar(idProdMod);
    }
    
    public int modificaMercancias(double idMercancia, double idGenero, int cantidad, double idMarca, double idColorBase, double precio, String descripcion, String fecha, double idUsuario, String nombreMercancia, double mercanciaModificar)
    {
        InicioDAL id = new InicioDAL();
        return id.modificaMercancias(idMercancia, idGenero, cantidad, idMarca, idColorBase, precio, descripcion, fecha, idUsuario, nombreMercancia, mercanciaModificar);
    }
}
