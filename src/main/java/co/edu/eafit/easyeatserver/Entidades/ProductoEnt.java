package co.edu.eafit.easyeatserver.Entidades;

/**
 * Created by Julian on 09/11/2015.
 */
public class ProductoEnt {
    int id_producto;
    String nombre;
    int precio;
    int tiempo;
    String categoria;

    public ProductoEnt(int id_producto, String nombre, int precio, int tiempo, String categoria) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.tiempo = tiempo;
        this.categoria = categoria;
    }    
}