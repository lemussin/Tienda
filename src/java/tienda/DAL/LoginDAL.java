package tienda.DAL;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import tienda.Entidades.Usuario;
/**
 *
 * @author Eduardo Lemus Zavala
 */
public class LoginDAL {
    public Usuario inicioSesion(String nomUsuario, String pass)
    {
        MongoClient mongo =  new MongoClient("localhost", 27017);
        Usuario usuario = new Usuario();
        if(mongo != null) 
        {
            DB db = mongo.getDB("TiendaRopa");
            DBCollection tabla = db.getCollection("administradores");
            BasicDBObject query = new BasicDBObject();
            query.put("usuario", nomUsuario);
            query.put("password", pass);
            DBCursor cur = tabla.find(query);
            while (cur.hasNext()) {
                //System.out.println("Genial me conecte a mongo "+cur.next().get("nombre") + " " + cur.curr().get("password"));
                usuario.setNombre(cur.next().get("nombre").toString());
                usuario.setApellidoPaterno(cur.curr().get("apellidoPaterno").toString());
                usuario.setApellidoMaterno(cur.curr().get("apellidoMaterno").toString());
                usuario.setUsuario(cur.curr().get("usuario").toString());
                usuario.setPassword(cur.curr().get("password").toString());
                usuario.setFechaNac(cur.curr().get("fechaNac").toString());
                usuario.setTelefono(cur.curr().get("telefono").toString());
                usuario.setEmail(cur.curr().get("email").toString());
                usuario.setTipoUsuario(1);
                usuario.setPermiso(1);
                usuario.setId(Double.parseDouble((cur.curr().get("idAdmin").toString())));
            }
        }
        else
        {
            System.out.println("Error en conexion con mongo");
        }
        mongo.close();
        return usuario;
    }
}
