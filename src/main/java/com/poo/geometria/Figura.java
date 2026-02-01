package com.poo.geometria;

import com.poo.interfaces.Calculable;
import com.poo.interfaces.Dibujable;

/**
 * Clase abstracta que representa una figura geométrica.
 * Demuestra abstracción e implementación de interfaces.
 * 
 * @author Diego
 * @version 1.0
 */
public abstract class Figura implements Calculable, Dibujable {
    
    private String nombre;
    private String color;

    /**
     * Constructor por defecto.
     */
    protected Figura() {
        this.nombre = "Figura";
        this.color = "Negro";
    }

    /**
     * Constructor con parámetros.
     * 
     * @param nombre Nombre de la figura
     * @param color Color de la figura
     */
    protected Figura(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    /**
     * Obtiene el nombre de la figura.
     * 
     * @return El nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la figura.
     * 
     * @param nombre El nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el color de la figura.
     * 
     * @return El color
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color de la figura.
     * 
     * @param color El nuevo color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Muestra información de la figura.
     */
    public void mostrarInformacion() {
        System.out.println("=== " + nombre + " ===");
        System.out.println("Color: " + color);
        System.out.println("Área: " + String.format("%.2f", calcularArea()));
        System.out.println("Perímetro: " + String.format("%.2f", calcularPerimetro()));
    }

    @Override
    public void dibujar() {
        System.out.println(obtenerRepresentacionASCII());
    }

    @Override
    public String toString() {
        return nombre + "{color='" + color + "', área=" + 
               String.format("%.2f", calcularArea()) + ", perímetro=" + 
               String.format("%.2f", calcularPerimetro()) + "}";
    }
}
