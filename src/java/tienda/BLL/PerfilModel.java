package tienda.BLL;
import javax.servlet.http.HttpServletRequest;
import tienda.DAL.PerfilDAL;
/**
 *
 * @author Eduardo Lemus Zavala
 */
public class PerfilModel {
    
    public int RegistroUsuarios(String nombre, String apellidoP, String apellidoM, String nombreUsuario, String password, String fNacimiento, String telefono, String email, HttpServletRequest request)
    {
        PerfilDAL pd = new PerfilDAL();
        return pd.RegistroUsuarios(nombre, apellidoP, apellidoM, nombreUsuario, password, fNacimiento, telefono, email, request);
    }
}
