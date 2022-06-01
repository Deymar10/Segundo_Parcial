package com.emergentes.controlador;

import com.emergentes.dao.ParticipanteDAOimpl;
import com.emergentes.modelo.Participante;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.dao.ParticipanteDAO;
import com.emergentes.dao.SeminarioDAO;
import com.emergentes.dao.SeminarioDAOimpl;
import com.emergentes.modelo.Seminario;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ParticipanteControlador", urlPatterns = {"/ParticipanteControlador"})
public class ParticipanteControlador extends HttpServlet {

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ParticipanteDAO dao = new ParticipanteDAOimpl();        
        Participante avi = new Participante();
        SeminarioDAO sem = new SeminarioDAOimpl();
        List<Seminario> lista_seminario = null; 
        int id;
        
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
            {
                try {
                    lista_seminario= sem.getAll();
                } catch (Exception ex) {
                    Logger.getLogger(ParticipanteControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                request.setAttribute("participante", avi);
                request.setAttribute("lista_seminario", lista_seminario);
                request.getRequestDispatcher("frmparticipante.jsp").forward(request, response);
                break;

            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    avi = dao.getById(id);
                    lista_seminario= sem.getAll();
                } catch (Exception ex) {
                    System.out.println("Eror al obtener registro " + ex.getMessage());
                }
                request.setAttribute("lista_seminario", lista_seminario);
                request.setAttribute("participante", avi);
                request.getRequestDispatcher("frmparticipante.jsp").forward(request, response);
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("Error al eliminar: " + ex.getMessage());
                }
                response.sendRedirect("ParticipanteControlador");
                break;
            case "view":
                List<Participante> lista = new ArrayList<Participante>(); 
                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("Error al listar "+ex.getMessage());
                }
                request.setAttribute("participantes", lista);
                request.getRequestDispatcher("participantes.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres =  request.getParameter("nombres");
        String apellidos =  request.getParameter("apellidos");
        String id_seminario =  request.getParameter("id_seminario");
        String confirmado =  request.getParameter("confirmado");
        
        Participante avi = new Participante();
        
        avi.setId(id);
        avi.setNombres(nombres);
        avi.setApellidos(apellidos);
        avi.setId_seminario(id_seminario);
        avi.setConfirmado(confirmado);
        
        ParticipanteDAO dao = new ParticipanteDAOimpl();
        
        if (id == 0){
            try {
                dao.insert(avi);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ ex.getMessage());
            }
        }
        else{
            try {
                dao.update(avi);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("ParticipanteControlador");
    }
}
