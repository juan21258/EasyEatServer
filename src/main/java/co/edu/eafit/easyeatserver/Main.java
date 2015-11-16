//package com.saprykin.heroku_spark;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.template.velocity.VelocityTemplateEngine;

// heroku auth:token
@WebServlet("/loginServlet")
public class Main extends HttpServlet{

    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        String producto = request.getParameter("producto");
       
    }

    public static void main(String[] args) {
        
        Colocar col = new doPost();
        //Heroku assigns different port each time, hence reading it from process.
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if(process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 8080;
        }
        setPort(port);

        //DaoTest daoTest = new DaoTest();
        //final String dbTestString = daoTest.testDb();
        ArrayList<String> datos = new ArrayList<>();
        
        get("/", (request, response) ->{ /*"<html><head><h1>API: EasyEat)</h1></head><body bgcolor=\"#e34234\">"
            + "<h2>" + "</h2>" + "<p>fjaf</p>" + "</body></html>")*/
            return new ModelAndView(new HashMap(),"Vistas/site/index.ftl.html");
        }, new VelocityTemplateEngine());
        
        get("/index-1", (request, response) ->{ /*"<html><head><h1>API: EasyEat)</h1></head><body bgcolor=\"#e34234\">"
            + "<h2>" + "</h2>" + "<p>fjaf</p>" + "</body></html>")*/
            return new ModelAndView(new HashMap(),"Vistas/site/index-1.ftl.html");
        }, new VelocityTemplateEngine());
        
        get("/index-2", (request, response) ->{ /*"<html><head><h1>API: EasyEat)</h1></head><body bgcolor=\"#e34234\">"
            + "<h2>" + "</h2>" + "<p>fjaf</p>" + "</body></html>")*/
            return new ModelAndView(new HashMap(),"Vistas/site/index-2.ftl.html");
        }, new VelocityTemplateEngine());
        
        get("/index", (request, response) ->{ /*"<html><head><h1>API: EasyEat)</h1></head><body bgcolor=\"#e34234\">"
            + "<h2>" + "</h2>" + "<p>fjaf</p>" + "</body></html>")*/
            return new ModelAndView(new HashMap(),"Vistas/site/index-3.ftl.html");
        }, new VelocityTemplateEngine());
        
        get("/index-4", (request, response) ->{ /*"<html><head><h1>API: EasyEat)</h1></head><body bgcolor=\"#e34234\">"
            + "<h2>" + "</h2>" + "<p>fjaf</p>" + "</body></html>")*/
            return new ModelAndView(new HashMap(),"Vistas/site/index-4.ftl.html");
        }, new VelocityTemplateEngine());
        
        get("/index-5", (request, response) ->{ /*"<html><head><h1>API: EasyEat)</h1></head><body bgcolor=\"#e34234\">"
            + "<h2>" + "</h2>" + "<p>fjaf</p>" + "</body></html>")*/
            return new ModelAndView(new HashMap(),"Vistas/site/index-5.ftl.html");
        }, new VelocityTemplateEngine());
        
        post("/echo", (request, response) -> {
            datos.add(request.queryParams("text"));
            return "";
        });
        get("/echo", (request, response) -> {
            String aux = "<html><head><center><h1>Sistema de Pedidos jajajajajaja</h1></center></head><body bgcolor=\"#e34234\">"
            + "<h1>" +"Pedidos en cola:" + "</h1>" + "</body></html>";
            for(String text:datos){
                aux+=(text.substring(1, text.length()-1)+"<br/>\n");
            }
            return aux;
        });

        post("/form", (request, response) -> {
            datos.add(request.queryParams("producto"));
            return "";
        });
        get("/form", (request, response) -> {
            String aux = "<html><head><center><h1>Sistema de Productos: </h1></center></head><body bgcolor=\"#e34234\">"
            + "<h1>" +"Productos:" + "</h1>" + "</body></html>";
            for(String producto:datos){
                aux+=(producto.substring(1, producto.length()-1)+"<br/>\n");
            }
            return aux;
        });

        get("/echo/clean", (request, response) -> {
            String aux = "<html><head><center><h1>Eliminado</h1></center></head><body bgcolor=\"#e34234\">"
            + "<h1>" +"" + "</h1>" + "</body></html>";
            datos.clear();
            return aux;
        });
        get("/demo", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            // The hello.ftl file is located in directory:
            // src/test/resources/spark/template/freemarker
            return new ModelAndView(attributes, "hello.ftl");
        }, new FreeMarkerEngine());
    }


}
