package tienda.BLL;
import tienda.Entidades.Usuario;
/**
 *
 * @author leze667231
 */
public class LoginModel {
    
    public Usuario inicioSesion(String nombre, String pass){
        Usuario usuario = new Usuario(nombre, 1);
        return usuario;
    }
    
}
