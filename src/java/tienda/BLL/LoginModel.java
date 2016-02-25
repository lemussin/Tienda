package tienda.BLL;
import tienda.Entidades.Usuario;
import tienda.DAL.LoginDAL;
/**
 *
 * @author leze667231
 */
public class LoginModel {
    
    LoginDAL ld = new LoginDAL();
    
    public Usuario inicioSesion(String nombre, String pass){
        Usuario usuario = ld.inicioSesion(nombre, pass);
        return usuario;
    }
    
}
