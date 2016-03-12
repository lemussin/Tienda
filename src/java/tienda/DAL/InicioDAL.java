package tienda.DAL;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.DBCursor;
import java.util.ArrayList;
import java.util.List;
import tienda.Entidades.Producto;
/**
 *
 * @author Eduardo Lemus Zavala
 */
public class InicioDAL 
{
    public int registroUsuario(String nombre, String apellidoP, String apellidoM, String nombreUsuario, String password, String fNacimiento, String telefono, String email, int tipoUsuario)
    {
        int status = 0, existeUsuario = 0;
        MongoClient mongo =  new MongoClient("localhost", 27017);
        if(mongo!=null)
        {
            DB db = mongo.getDB("TiendaRopa");
            DBCollection collection;
            if(tipoUsuario == 1)
                collection = db.getCollection("administradores");
            else
                collection = db.getCollection("cajeros");
            
            BasicDBObject query = new BasicDBObject();
            query.put("usuario", nombreUsuario);
            DBCursor cur = collection.find(query);
            while (cur.hasNext()) 
            {
                cur.next().get("usuario");
                existeUsuario = 1;
            }
            
            if(existeUsuario==1)
            {
                status = 2;
                mongo.close();
            }
            else
            {
                double Max = 1, maxT = 1;
                DBCursor cur3 = collection.find();
                while (cur3.hasNext()) 
                {
                    maxT = (double) cur3.next().get("idAdmin");
                    if(maxT > Max)
                        Max = maxT;
                }
                BasicDBObject document = new BasicDBObject();
                document.put("idAdmin", (Max+1));
                document.put("nombre", nombre);
                document.put("apellidoPaterno",apellidoP);
                document.put("apellidoMaterno",apellidoM);
                document.put("usuario", nombreUsuario);
                document.put("password",password);
                document.put("fechaNac", fNacimiento);
                document.put("telefono", telefono);
                document.put("email",email);
                collection.insert(document);
                mongo.close();
                status = 1;
            }
        }
        else
            status = 0;
        
        return status;
    }
    
    public List<Producto> cargaProductos()
    {
        List<Producto> listaProductos = new ArrayList<>();
        Producto producto = null;
        MongoClient mongo = new MongoClient("localhost",27017);
        if(mongo!=null)
        {
            double prod;
            int idProducto;
            DB db = mongo.getDB("TiendaRopa");
            DBCollection collection = db.getCollection("cat_tipo_producto");
            //BasicDBObject query = new BasicDBObject();
            DBCursor cursor = collection.find();
            while(cursor.hasNext())
            {
                prod = (double) cursor.next().get("idProducto");
                idProducto = (int) prod;
                producto = new Producto(idProducto,cursor.curr().get("nombreProducto").toString());
                listaProductos.add(producto);
            }
            mongo.close();
        }
        else
            listaProductos = null;
        
        return listaProductos;
    }
    
}
