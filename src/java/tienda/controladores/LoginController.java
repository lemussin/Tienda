package tienda.controladores;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.AsyncContext;
import tienda.BLL.LoginModel;
import tienda.Entidades.Usuario;

/**
 *
 * @author Eduardo Lemus Zavala
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"}, asyncSupported = true)
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String seleccion = request.getParameter("seleccion");
        Gson json= new Gson();
        LoginModel lm = new LoginModel();
        switch(seleccion){
            case "inicioSesion":
                String nombre = request.getParameter("nombre");
                String pass = request.getParameter("pass");
                Usuario usuario = lm.inicioSesion(nombre,pass);
                out.print(json.toJson(usuario));
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
        System.out.println("Hilo Principal:" + Thread.currentThread().getName());
        AsyncContext contextoAsincrono = request.startAsync(request, response);
        contextoAsincrono.start(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    System.out.println("Hilo Tarea Asincrona Antes :"+ Thread.currentThread().getName());
                    processRequest(request, response);
                    contextoAsincrono.complete();
                } catch (ServletException | IOException ex) 
                {Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);}
            }
        });
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
