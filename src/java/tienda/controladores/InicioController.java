package tienda.controladores;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tienda.Entidades.Usuario;
import tienda.Entidades.Producto;
import tienda.Entidades.Marca;
import tienda.Entidades.Color;
import tienda.BLL.InicioModel;
import tienda.Entidades.Mercancia;
import java.util.GregorianCalendar;

/**
 *
 * @author Eduardo Lemus Zavala
 */
@WebServlet(name = "InicioController", urlPatterns = {"/InicioController"}, asyncSupported = true)
public class InicioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String seleccion = request.getParameter("seleccion");
        Gson json= new Gson();
        HttpSession sesion = request.getSession(false);
        Usuario usuario= (Usuario) sesion.getAttribute("Usuario");
        PrintWriter out = response.getWriter();
        
        InicioModel im = new InicioModel();
        
        switch(seleccion){
            case "RegistroUsuarios":
                String nombre = request.getParameter("nombre");
                String apellidoP = request.getParameter("apellidoP");
                String apellidoM = request.getParameter("apellidoM");
                String nombreUsuario = request.getParameter("usuario");
                String password = request.getParameter("password");
                String fNacimiento = request.getParameter("fecha");
                String telefono = request.getParameter("telefono");
                String email = request.getParameter("email");
                int tipoUsuario = Integer.parseInt(request.getParameter("tipoUsuario"));
                int registro = im.registroUsuario(nombre, apellidoP, apellidoM, nombreUsuario, password, fNacimiento, telefono, email, tipoUsuario);
                out.print(json.toJson(registro));
                break;
            case "registrarMercancia":
                Calendar fecha = new GregorianCalendar();
                int año = fecha.get(Calendar.YEAR);
                int mes = fecha.get(Calendar.MONTH);
                int dia = fecha.get(Calendar.DAY_OF_MONTH);
                String fechaReg;
                if((mes+1)>=10)
                    fechaReg = año+"-"+(mes+1)+"-"+dia;
                else
                    fechaReg = año+"-0"+(mes+1)+"-"+dia;
                
                double idMercancia = Double.parseDouble(request.getParameter("tipoMercancia"));
                double idGenero = Double.parseDouble(request.getParameter("genero"));
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                double idMarca = Double.parseDouble(request.getParameter("marca"));
                double idColorBase = Double.parseDouble(request.getParameter("colorBase"));
                double precio = Double.parseDouble(request.getParameter("precio"));
                String descripcion = request.getParameter("descripcion");
                String nombreMercancia = request.getParameter("nombreMerc");
                int registroMercancia = im.registroMercancias(idMercancia, idGenero, cantidad, idMarca, idColorBase, precio, descripcion, fechaReg, usuario.getId(),nombreMercancia);
                out.print(json.toJson(registroMercancia));
                break;
            case "cargaTipoProductos":
                List<Producto> listaProductos = null;
                listaProductos = im.cargaProductos();
                out.print(json.toJson(listaProductos));
                break;
            case "cargarMarcas":
                List<Marca> listaMarcas = null;
                listaMarcas = im.cargaMarcas();
                out.print(json.toJson(listaMarcas));
                break;
            case "cargarColores":
                List<Color> listaColores = null;
                listaColores = im.cargaColores();
                out.print(json.toJson(listaColores));
                break;
            case "cargaMercancias":
                List<Mercancia> listaMercancias = null;
                listaMercancias = im.cargaMercancias();
                out.print(json.toJson(listaMercancias));
                break;
            case "cargaProductoModificar":
                Mercancia mercancia = null;
                double idProdMod = Double.parseDouble(request.getParameter("idMercancia"));
                mercancia = im.cargaProductoModificar(idProdMod);
                out.print(json.toJson(mercancia));
                break;
            case "ModificarMercancia":
                Calendar fechaMod = new GregorianCalendar();
                int añoMod = fechaMod.get(Calendar.YEAR);
                int mesMod = fechaMod.get(Calendar.MONTH);
                int diaMod = fechaMod.get(Calendar.DAY_OF_MONTH);
                String fechaRegMod;
                if((mesMod+1)>=10)
                    fechaRegMod = añoMod+"-"+(mesMod+1)+"-"+diaMod;
                else
                    fechaRegMod = añoMod+"-0"+(mesMod+1)+"-"+diaMod;
                
                double idMercanciaMod = Double.parseDouble(request.getParameter("tipoMercancia"));
                double idGeneroMod = Double.parseDouble(request.getParameter("genero"));
                int cantidadMod = Integer.parseInt(request.getParameter("cantidad"));
                double idMarcaMod = Double.parseDouble(request.getParameter("marca"));
                double idColorBaseMod = Double.parseDouble(request.getParameter("colorBase"));
                double precioMod = Double.parseDouble(request.getParameter("precio"));
                String descripcionMod = request.getParameter("descripcion");
                String nombreMercanciaMod = request.getParameter("nombreMerc");
                double mercanciaModificar = Double.parseDouble(request.getParameter("mercanciaModificar"));
                int modificaMercancia = im.modificaMercancias(idMercanciaMod, idGeneroMod, cantidadMod, idMarcaMod, idColorBaseMod, precioMod, descripcionMod, fechaRegMod, usuario.getId(),nombreMercanciaMod, mercanciaModificar);
                out.print(json.toJson(modificaMercancia));
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
