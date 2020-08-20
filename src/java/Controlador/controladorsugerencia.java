/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.sugerencia;
import ModeloDAO.sugerenciaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DaniEDR
 */
public class controladorsugerencia {
    String listarsugerencia = "Vista/Listarsugerencia.jsp";
    String agregarsugerencia = "Vista/Agregarsugerencia.jsp";
    String editarsugerencia = "Vista/Editarsugerencia.jsp";
    sugerencia sugerencia = new sugerencia();
    sugerenciaDAO sugerenciaDAO = new sugerenciaDAO();

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controladorsugerencia</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controladorsugerencia at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String s_accion = request.getParameter("f_accion");
        if (s_accion.equalsIgnoreCase("listarsugerencia")) {
            acceso = listarsugerencia;
        }else if (s_accion.equalsIgnoreCase("agregarsugerencia01")) {
            acceso = agregarsugerencia;
        }else if (s_accion.equalsIgnoreCase("agregarsugerencia02")) { 
            String s_idpersona= request.getParameter("f_idpersona");
            String s_idarea = request.getParameter("f_idarea");
            String s_idrol = request.getParameter("f_idrol");
            String s_sugerencia = request.getParameter("f_sugerencia");
            String s_estado= request.getParameter("f_estado");
            
            
            sugerencia.setIdpersona(s_idpersona);
            sugerencia.setIdarea(s_idarea);
            sugerencia.setIdrol(s_idrol);
            sugerencia.setSugerencia(s_sugerencia);
            sugerencia.setEstado(s_estado);
            
            
            sugerenciaDAO.agregarsugerencia(sugerencia);
            acceso = listarsugerencia;
            
        }else if (s_accion.equalsIgnoreCase("editarsugerencia01")) {
            request.setAttribute("f_idsugerencia", request.getParameter("f_idsugerencia"));
            acceso = editarsugerencia;
        }else if (s_accion.equalsIgnoreCase("editarsugerencia02")) {
            
            String s_idpersona = request.getParameter("f_idpersona");
            String s_idarea = request.getParameter("f_idarea");
            String s_idrol = request.getParameter("f_idrol");
            String s_sugerencia = request.getParameter("f_sugerencia");
            String s_estado = request.getParameter("f_estado");
            
            
                      
            sugerencia.setIdpersona(s_idpersona);
            sugerencia.setIdarea(s_idarea);
            sugerencia.setIdrol(s_idrol);
            sugerencia.setSugerencia(s_sugerencia);
            sugerencia.setEstado(s_estado);
            sugerenciaDAO.editarsugerencia(sugerencia);
            acceso = listarsugerencia;
        }else if (s_accion.equals("eliminarsugerencia")) {
            int s_idsugerencia = Integer.valueOf(request.getParameter("f_idsugerencia"));
            sugerenciaDAO.eliminarsugerencia(s_idsugerencia);
            acceso = listarsugerencia;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
