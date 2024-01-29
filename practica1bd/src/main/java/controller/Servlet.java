/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import collection.Activista;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabri
 */
@WebServlet("/api/datos")
public class Servlet extends HttpServlet {

    private final Fachada fachada = Fachada.getInstance();

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipo = request.getParameter("tipo");
        int dato2 = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");

        if ("activista".equals(tipo)) {
            List<Activista> activistas = fachada.obtenerTodos(Activista.class);
            for (Activista a : activistas) {
                if (a.getId() == dato2) {
                    a.setNombre(nombre);
                    a.setTelefono(telefono);
                    // setear fecha
                    fachada.actualizar(a);
                    response.setContentType("text/plain");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write("Activista creado exitosamente");
                }
            }

        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Tipo de solicitud invalida");
        }

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipo = request.getParameter("tipo");
        int dato2 = Integer.parseInt(request.getParameter("id"));

        if ("activista".equals(tipo)) {
            List<Activista> activistas = fachada.obtenerTodos(Activista.class);
            for (Activista a : activistas) {
                if (a.getId() == dato2) {
                    fachada.eliminar(Activista.class, a.getId());
                    response.setContentType("text/plain");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write("Activista creado exitosamente");
                }
            }

        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Tipo de solicitud invalida");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipo = request.getParameter("tipo");

        if ("activista".equals(tipo)) {
            String nombre = request.getParameter("nombre");
            String telefono = request.getParameter("telefono");
            // String fechaInicio = request.getParameter("fechaInicio");
            Activista a = new Activista();
            a.setNombre(nombre);
            a.setTelefono(telefono);
            //  a.setFechaInicio(fechaInicio);
            fachada.crear(a);
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Activista creado exitosamente");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Tipo de solicitud invalida");
        }

    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dato = request.getParameter("tipo");

        if ("activista".equals(dato)) {
            String dato2 = request.getParameter("nombre");
            List<Activista> activistas = fachada.obtenerTodos(Activista.class);
            Activista act = null;
            for (Activista a : activistas) {
                if (a.getNombre().equals(dato2)) {
                    act = (Activista) fachada.obtenerPorId(Activista.class, a.getId());

                }
            }

            // responderConJSON(response, activistas);
            try (PrintWriter out = response.getWriter()) {
                //out.print(activistas.toString());
                out.print(act.toString());
            }
        } else if ("idsearch".equals(dato)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Activista act = (Activista) fachada.obtenerPorId(Activista.class, id);
            try (PrintWriter out = response.getWriter()) {
                //out.print(activistas.toString());
                out.print(act.toString());
            }

        }

    }

    private void responderConJSON(HttpServletResponse response, Object datos) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.print(new Gson().toJson(datos));
        } catch (Exception e) {
            // Manejo de excepciones
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al generar la respuesta JSON");
        }
    }

}
