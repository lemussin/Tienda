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
    public Usuario inicioSesion(String nombre, String pass)
    {
        MongoClient mongo =  new MongoClient("localhost", 27017);
        Usuario usuario = new Usuario(nombre, 0);
        if(mongo != null) 
        {
            DB db = mongo.getDB("TiendaRopa");
            DBCollection tabla = db.getCollection("administradores");
            BasicDBObject query = new BasicDBObject();
            query.put("usuario", nombre);
            query.put("password", pass);
            DBCursor cur = tabla.find(query);
            while (cur.hasNext()) {
                System.out.println("Genial me conecte a mongo "+cur.next().get("nombre") + " " + cur.curr().get("password"));
                usuario.setPermiso(1);
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
