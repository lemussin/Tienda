package tienda.DAL;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.DBCursor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import tienda.Entidades.Usuario;
/**
 *
 * @author Eduardo Lemus Zavala
 */
public class PerfilDAL {
    public int RegistroUsuarios(String nombre, String apellidoP, String apellidoM, String nombreUsuario, String password, String fNacimiento, String telefono, String email, HttpServletRequest request)
    {
        int status = 0, existeUsuario = 0;
        MongoClient mongo =  new MongoClient("localhost", 27017);
        HttpSession sesion = request.getSession(false);
        Usuario usuario= (Usuario) sesion.getAttribute("Usuario");
        if(mongo!=null)
        {
            DB db = mongo.getDB("TiendaRopa");
            DBCollection collection;
            collection = db.getCollection("administradores");
            
            BasicDBObject actualiza = new BasicDBObject();
            BasicDBObject searchById = new BasicDBObject();
            searchById.append("idAdmin", usuario.getId());
            
            if(!nombre.equals(usuario.getNombre()))
            {
                actualiza.append("$set", new BasicDBObject().append("nombre", nombre));
                collection.updateMulti(searchById, actualiza);
                usuario.setNombre(nombre);
            }
            if(!apellidoP.equals(usuario.getApellidoPaterno()))
            {
                actualiza = new BasicDBObject();
                actualiza.append("$set", new BasicDBObject().append("apellidoPaterno", apellidoP));
                collection.updateMulti(searchById, actualiza);
                usuario.setApellidoPaterno(apellidoP);
            }
            if(!apellidoM.equals(usuario.getApellidoMaterno()))
            {
                actualiza = new BasicDBObject();
                actualiza.append("$set", new BasicDBObject().append("apellidoMaterno", apellidoM));
                collection.updateMulti(searchById, actualiza);
                usuario.setApellidoMaterno(apellidoM);
            }
            if(!nombreUsuario.equals(usuario.getUsuario()))
            {
                actualiza = new BasicDBObject();
                actualiza.append("$set", new BasicDBObject().append("usuario", nombreUsuario));
                collection.updateMulti(searchById, actualiza);
                usuario.setUsuario(nombreUsuario);
            }
            if(!password.equals(usuario.getPassword()))
            {
                actualiza = new BasicDBObject();
                actualiza.append("$set", new BasicDBObject().append("password", password));
                collection.updateMulti(searchById, actualiza);
                usuario.setPassword(password);
            }
            if(!fNacimiento.equals(usuario.getFechaNac()))
            {
                actualiza = new BasicDBObject();
                actualiza.append("$set", new BasicDBObject().append("fechaNac", fNacimiento));
                collection.updateMulti(searchById, actualiza);
                usuario.setFechaNac(fNacimiento);
            }
            if(!telefono.equals(usuario.getTelefono()))
            {
                actualiza = new BasicDBObject();
                actualiza.append("$set", new BasicDBObject().append("telefono", telefono));
                collection.updateMulti(searchById, actualiza);
                usuario.setTelefono(telefono);
            }
            if(!email.equals(usuario.getEmail()))
            {
                actualiza = new BasicDBObject();
                actualiza.append("$set", new BasicDBObject().append("email", email));
                collection.updateMulti(searchById, actualiza);
                usuario.setEmail(email);
            } 
            mongo.close();
        }
        else
        {
            status = 0;
        }
        return status;
    }
    
}
