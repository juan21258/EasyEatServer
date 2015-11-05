package com.saprykin.heroku_spark;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;

// heroku auth:token

public class App {

    public static void main(String[] args) {
        
        //Heroku assigns different port each time, hence reading it from process.
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if(process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 8080;
        }
        setPort(port);

        DaoTest daoTest = new DaoTest();
        final String dbTestString = daoTest.testDb();
        ArrayList<String> datos = new ArrayList<>();
        get("/", (request, response) -> "<html><head><h1>Hello World!</h1></head><body>"
            + "<h2>" + dbTestString + "</h2>" + "</body></html>");
        post("/echo", (request, response) -> {
            datos.add(request.queryParams("text"));
            return "";
        });
        get("/echo", (request, response) -> {
            String aux = "";
            for(String text:datos){
                aux+=(text+"<br/>\n");
            }
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
