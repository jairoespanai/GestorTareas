/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.TareasEntities;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelos.TareasModels;

/**
 *
 * @author lenovo
 */
@WebServlet(name = "TareasControllers", urlPatterns = {"/TareasControllers"})
public class TareasControllers extends HttpServlet {

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

        String action = request.getParameter("action");

        if (action == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (action.equals("crear")) {
            String descripcion = request.getParameter("descripcion");
            String nombre = request.getParameter("nombre");
            int estado = 1;
            //Date date = new Date();
            //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            //String inicio = dateFormat.format(date); 
            //System.out.println(inicio);                   
            String inicio = "NULL";
            String fin = "NULL";
            String responsable = "";

            TareasEntities tarea = new TareasEntities(nombre, descripcion, estado, inicio, fin, responsable);
            TareasModels taream = new TareasModels();
            if (taream.agregar(tarea)) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("msjerror.jsp").forward(request, response);
            }
        } else if (action.equals("aprocesar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String inicio = dateFormat.format(date); 
            //System.out.println(inicio);                   
            String responsable = "Jairo España";

            TareasEntities tarea = new TareasEntities();
            tarea.setId(id);
            tarea.setInicio(inicio);
            tarea.setResponsable(responsable);
            tarea.setEstado(2);
            TareasModels taream = new TareasModels();
            if (taream.aprocesar(tarea)) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("msjerror.jsp").forward(request, response);
            }
        }else if (action.equals("afinalizar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String fin = dateFormat.format(date); 
            //System.out.println(fin);                   
            //String responsable = "Jairo España";

            TareasEntities tarea = new TareasEntities();
            tarea.setId(id);
            tarea.setFin(fin);
            tarea.setEstado(5);
            TareasModels taream = new TareasModels();
            if (taream.afinalizar(tarea)) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("msjerror.jsp").forward(request, response);
            }
        }else if (action.equals("asuspender")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String fin = dateFormat.format(date); 
            //System.out.println(fin);                   
            //String responsable = "Jairo España";

            TareasEntities tarea = new TareasEntities();
            tarea.setId(id);
            tarea.setFin(fin);
            tarea.setEstado(3);
            TareasModels taream = new TareasModels();
            if (taream.afinalizar(tarea)) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("msjerror.jsp").forward(request, response);
            }
        }else if (action.equals("acancelar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String fin = dateFormat.format(date); 
            //System.out.println(fin);                   
            //String responsable = "Jairo España";

            TareasEntities tarea = new TareasEntities();
            tarea.setId(id);
            tarea.setFin(fin);
            tarea.setEstado(4);
            TareasModels taream = new TareasModels();
            if (taream.afinalizar(tarea)) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("msjerror.jsp").forward(request, response);
            }
        }else if (action.equals("aeliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            TareasEntities tarea = new TareasEntities();
            tarea.setId(id);
            tarea.setEstado(0);
            TareasModels taream = new TareasModels();
            if (taream.aeliminar(tarea)) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("msjerror.jsp").forward(request, response);
            }
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
