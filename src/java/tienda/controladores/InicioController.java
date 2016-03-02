/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.controladores;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tienda.Entidades.Usuario;
import tienda.BLL.InicioModel;

/**
 *
 * @author Eduardo Lemus Zavala
 */
@WebServlet(name = "InicioController", urlPatterns = {"/InicioController"})
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
                InicioModel im = new InicioModel();
                int registro = im.registroUsuario(nombre, apellidoP, apellidoM, nombreUsuario, password, fNacimiento, telefono, email, tipoUsuario);
                out.print(json.toJson(registro));
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
