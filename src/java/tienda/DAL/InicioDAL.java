package tienda.DAL;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.DBCursor;
import java.util.ArrayList;
import java.util.List;
import tienda.Entidades.Color;
import tienda.Entidades.Marca;
import tienda.Entidades.Mercancia;
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
    
    public List<Marca> cargaMarcas()
    {
        List<Marca> listaMarcas = new ArrayList<>();
        Marca marca = null;
        MongoClient mongo = new MongoClient("localhost",27017);
        if(mongo!=null)
        {
            double marka;
            int idMarca;
            DB db = mongo.getDB("TiendaRopa");
            DBCollection collection = db.getCollection("cat_marca");
            DBCursor cursor = collection.find();
            while(cursor.hasNext())
            {
                marka = (double) cursor.next().get("idMarca");
                idMarca = (int) marka;
                marca = new Marca(idMarca,cursor.curr().get("nombreMarca").toString(),cursor.curr().get("paisOrigen").toString());
                listaMarcas.add(marca);
                
            }
            mongo.close();
        }
        else
            listaMarcas = null;
        
        return listaMarcas;
    }
    
    public List<Color> cargaColores()
    {
        List<Color> listaColores = new ArrayList();
        Color color = null;
        MongoClient mongo = new MongoClient("localhost",27017);
        if(mongo!=null)
        {
            double colour;
            int idColorBase;
            DB db = mongo.getDB("TiendaRopa");
            DBCollection collection = db.getCollection("cat_color_base");
            DBCursor cursor = collection.find();
            while(cursor.hasNext())
            {
                colour = (double) cursor.next().get("idColorBase");
                idColorBase = (int) colour;
                color = new Color(idColorBase,cursor.curr().get("Color").toString());
                listaColores.add(color);
            }
            mongo.close();
        }
        else
            listaColores = null;
        
        return listaColores;
    }
    
    public int registroMercancias(double idMercancia, double idGenero, int cantidad, double idMarca, double idColorBase, double precio, String descripcion, String fecha, double idUsuario, String nombreMercancia)
    {
        int status = 0;
        MongoClient mongo =  new MongoClient("localhost", 27017);
        if(mongo!=null)
        {
            DB db = mongo.getDB("TiendaRopa");
            DBCollection collection;
            collection = db.getCollection("tbl_mercancia_registrada");
            double Max = 1, maxT = 1;
            DBCursor cur3 = collection.find();
            while (cur3.hasNext()) 
            {
                maxT = (double) cur3.next().get("idMercanciaRegistrada");
                if(maxT > Max)
                    Max = maxT;
            }
            BasicDBObject document = new BasicDBObject();
            document.put("idMercanciaRegistrada", (Max+1));
            document.put("idMercancia", idMercancia);
            document.put("idGenero",idGenero);
            document.put("nombreMercancia", nombreMercancia);
            document.put("cantidad", cantidad);
            document.put("idMarca", idMarca);
            document.put("idColorBase", idColorBase);
            document.put("precio", precio);
            document.put("descripcion", descripcion);
            document.put("fechaRegistro", fecha);
            document.put("usuarioRegistro", idUsuario);
            collection.insert(document);
            mongo.close();
            status = 1;
        }
        else
            status = 0;
        
        return status;
    }
    
    public List<Mercancia> cargaMercancias()
    {
        List<Mercancia> listaMercancias = new ArrayList();
        Mercancia mercancia = null;
        MongoClient mongo = new MongoClient("localhost",27017);
        if(mongo!=null)
        {
            double mercanciaReg;
            int idmercanciaReg;
            double idsMercancia;
            int idMercancia;
            double idsGenero;
            int idGenero;
            double marka;
            int idMarca;
            double colour;
            int idColorBase;
            int cantidad;
            DB db = mongo.getDB("TiendaRopa");
            DBCollection collection = db.getCollection("tbl_mercancia_registrada");
            DBCursor cursor = collection.find();
            while(cursor.hasNext())
            {
                mercanciaReg = (double) cursor.next().get("idMercanciaRegistrada");
                idmercanciaReg = (int) mercanciaReg;
                idsMercancia = (double) cursor.curr().get("idMercancia");
                idMercancia = (int) idsMercancia;
                idsGenero = (double) cursor.curr().get("idGenero");
                idGenero = (int) idsGenero;
                marka = (double) cursor.curr().get("idMarca");
                idMarca = (int) marka;
                colour = (double) cursor.curr().get("idColorBase");
                idColorBase = (int) colour;
                cantidad = (int)cursor.curr().get("cantidad");
                mercancia = new Mercancia(idmercanciaReg,idMercancia,idGenero,cursor.curr().get("nombreMercancia").toString(),cantidad,idMarca,idColorBase,(double)cursor.curr().get("precio"),cursor.curr().get("descripcion").toString(),cursor.curr().get("fechaRegistro").toString(),(double)cursor.curr().get("usuarioRegistro"));
                listaMercancias.add(mercancia);
            }
            mongo.close();
        }
        else
            listaMercancias = null;
        
        return listaMercancias;
    }
    
    public Mercancia cargaProductoModificar(double idProdMod)
    {
        Mercancia mercancia = null;
        MongoClient mongo =  new MongoClient("localhost", 27017);
        if(mongo!=null)
        {
            double mercanciaReg;
            int idmercanciaReg;
            double idsMercancia;
            int idMercancia;
            double idsGenero;
            int idGenero;
            double marka;
            int idMarca;
            double colour;
            int idColorBase;
            int cantidad;
            DB db = mongo.getDB("TiendaRopa");
            DBCollection collection;
            collection = db.getCollection("tbl_mercancia_registrada");
            BasicDBObject query = new BasicDBObject();
            query.put("idMercanciaRegistrada", idProdMod);
            DBCursor cursor = collection.find(query);
            while (cursor.hasNext()) 
            {
                 mercanciaReg = (double) cursor.next().get("idMercanciaRegistrada");
                idmercanciaReg = (int) mercanciaReg;
                idsMercancia = (double) cursor.curr().get("idMercancia");
                idMercancia = (int) idsMercancia;
                idsGenero = (double) cursor.curr().get("idGenero");
                idGenero = (int) idsGenero;
                marka = (double) cursor.curr().get("idMarca");
                idMarca = (int) marka;
                colour = (double) cursor.curr().get("idColorBase");
                idColorBase = (int) colour;
                cantidad = (int)cursor.curr().get("cantidad");
                mercancia = new Mercancia(idmercanciaReg,idMercancia,idGenero,cursor.curr().get("nombreMercancia").toString(),cantidad,idMarca,idColorBase,(double)cursor.curr().get("precio"),cursor.curr().get("descripcion").toString(),cursor.curr().get("fechaRegistro").toString(),(double)cursor.curr().get("usuarioRegistro"));
            }
        }
        else
            mercancia = null;
        
        return mercancia;
    }
    
    public int modificaMercancias(double idMercancia, double idGenero, int cantidad, double idMarca, double idColorBase, double precio, String descripcion, String fecha, double idUsuario, String nombreMercancia, double mercanciaModificar)
    {
        int status = 0, existeMercancia = 0;
        MongoClient mongo =  new MongoClient("localhost", 27017);
        if(mongo!=null)
        {
            DB db = mongo.getDB("TiendaRopa");
            DBCollection collection;
            collection = db.getCollection("tbl_mercancia_registrada");
            BasicDBObject actualiza = new BasicDBObject();
            BasicDBObject searchById = new BasicDBObject();
            searchById.append("idMercanciaRegistrada", mercanciaModificar);
            
            actualiza.append("$set", new BasicDBObject().append("idMercancia", idMercancia));
            collection.updateMulti(searchById, actualiza);
            actualiza = new BasicDBObject();
            
            actualiza.append("$set", new BasicDBObject().append("idGenero", idGenero));
            collection.updateMulti(searchById, actualiza);
            actualiza = new BasicDBObject();
            
            actualiza.append("$set", new BasicDBObject().append("nombreMercancia", nombreMercancia));
            collection.updateMulti(searchById, actualiza);
            actualiza = new BasicDBObject();
            
            actualiza.append("$set", new BasicDBObject().append("cantidad", cantidad));
            collection.updateMulti(searchById, actualiza);
            actualiza = new BasicDBObject();
            
            actualiza.append("$set", new BasicDBObject().append("idMarca", idMarca));
            collection.updateMulti(searchById, actualiza);
            actualiza = new BasicDBObject();
            
            actualiza.append("$set", new BasicDBObject().append("idColorBase", idColorBase));
            collection.updateMulti(searchById, actualiza);
            actualiza = new BasicDBObject();
            
            actualiza.append("$set", new BasicDBObject().append("precio", precio));
            collection.updateMulti(searchById, actualiza);
            actualiza = new BasicDBObject();
            
            actualiza.append("$set", new BasicDBObject().append("descripcion", descripcion));
            collection.updateMulti(searchById, actualiza);
            actualiza = new BasicDBObject();
            
            mongo.close();
            
            status = 1;
        }
        else
            status = 0;
        
        return status;
    }
}
