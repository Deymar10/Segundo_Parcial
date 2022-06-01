package com.emergentes.controlador;

import com.emergentes.dao.SeminarioDAOimpl;
import com.emergentes.modelo.Seminario;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.dao.SeminarioDAO;

@WebServlet(name = "SeminarioControlador", urlPatterns = {"/SeminarioControlador"})
public class SeminarioControlador extends HttpServlet {

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SeminarioDAO dao = new SeminarioDAOimpl();
        
        Seminario avi = new Seminario();
        int id;
        
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("seminario", avi);
                request.getRequestDispatcher("frmseminario.jsp").forward(request, response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    avi = dao.getById(id);
                } catch (Exception ex) {
                    System.out.println("Eror al obtener registro " + ex.getMessage());
                }
                request.setAttribute("seminario", avi);
                request.getRequestDispatcher("frmseminario.jsp").forward(request, response);
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("Error al eliminar: " + ex.getMessage());
                }
                response.sendRedirect("SeminarioControlador");
                break;
            case "view":
                List<Seminario> lista = new ArrayList<Seminario>(); 
                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("Error al listar "+ex.getMessage());
                }
                request.setAttribute("seminarios", lista);
                request.getRequestDispatcher("seminarios.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        Date fecha = Date.valueOf(request.getParameter("fecha"));
        int cupo = Integer.parseInt(request.getParameter("cupo"));
        
        Seminario avi = new Seminario();
        
        avi.setId(id);
        avi.setTitulo(titulo);
        avi.setFecha(fecha);
        avi.setCupo(cupo);
        
        SeminarioDAO dao = new SeminarioDAOimpl();
        
        if (id == 0){
            try {
                // Nuevo
                dao.insert(avi);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ ex.getMessage());
            }
        }
        else{
            try {
                // Edición
                dao.update(avi);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("SeminarioControlador");
    }
}
