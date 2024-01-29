/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collection;

import collection.Problema.Estado;
import controller.CorsFilter;
import controller.Fachada;
import controller.Servlet;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 *
 * @author fabri
 */
public class IniciarServer {

    public static void main(String[] args) throws Exception {

//        Activistas a = new Activistas("caac", "22124", new Date(2005, 1, 1));
//        Fachada f = Fachada.getInstance();
//        Set<Problema> problemas = new HashSet<>();
//        Set<Activista> activistas = new HashSet<>();
//        Activista a = new Activista("hola", "6442590010", new Date(2005, 1, 1), problemas);
//        f.crear(a);
//
//        Problema p = new Problema("hola", Estado.ACTIVO, new Date(2005, 1, 1), new Date(2005, 1, 1), null, activistas);
//        f.crear(p);
//        activistas.add(a);
//        problemas.add(p);
//        
//        a.setProblemas(problemas);
//        f.actualizar(a);
//        
//        p.setActivistas(activistas);
//        f.actualizar(p);
//        List<Problemas> lista = new ArrayList<Problemas>();
//        Clientes c = new Clientes("bruce", "catanai", lista);
//        f.crear(c);
//        Problemas p = new Problemas("problem",  new Date(2020, 1, 1), new Date(2020, 1, 1),Estado.ACTIVO,c);
//        f.crear(p);
//        lista.add(p);
//        c.setProblemas(lista);
//        f.actualizar(c);
        // Crea un servidor Jetty en el puerto 8080
        Server server = new Server(8080);

        ServletContextHandler contextHandler = new ServletContextHandler();
        contextHandler.setContextPath("/aplicacion"); 
        contextHandler.addFilter(CorsFilter.class, "/api/*", null);

        contextHandler.addServlet(new ServletHolder(new Servlet()), "/api/datos/*");
        server.setHandler(contextHandler);

        server.start();
        server.join();
    }
}
