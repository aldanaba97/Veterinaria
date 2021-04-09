/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controller.gestorVeterinario;
import Models.cliente;
import Models.especialidad;
import Models.mascotas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aldana
 */
@WebServlet(name = "altoMasco", urlPatterns = {"/altoMasco"})
public class altoMasco extends HttpServlet {

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
        
        gestorVeterinario g = new gestorVeterinario(); 
        ArrayList<cliente> lista = g.obtenerCliente();
        request.setAttribute("cliente", lista);
        request.setAttribute("especie", g.obtenerEspecialidad());
        
         RequestDispatcher rd = request.getRequestDispatcher("/FormularioMascota.jsp");
            rd.forward(request, response);
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
        gestorVeterinario g = new gestorVeterinario(); 
        
        String nombre = request.getParameter("txtNombre");
        int nacimiento = Integer.parseInt(request.getParameter("txtNacimiento"));
        int cliente =  Integer.parseInt(request.getParameter("cboCliente"));
        int especie =  Integer.parseInt(request.getParameter("cboEspecie"));
        
        especialidad e = new especialidad(especie, "");
        cliente c = new cliente("", "", cliente);
        mascotas m = new mascotas(0, nombre, nacimiento, e, c); 
        
        g.Insertar(m);
        
      request.setAttribute("lista", g.listadoMascotas());
       RequestDispatcher rd = request.getRequestDispatcher("/ListadoMascota.jsp");
           rd.forward(request, response);
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
