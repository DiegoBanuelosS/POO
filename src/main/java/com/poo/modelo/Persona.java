package com.poo.modelo;

/**
 * Clase que representa una persona con sus atributos básicos.
 * Demuestra encapsulamiento, constructores y métodos de acceso.
 * 
 * @author Diego
 * @version 1.0
 */
public class Persona {
    
    // Atributos privados (encapsulamiento)
    private String nombre;
    private String apellido;
    private int edad;
    private String identificacion;

    /**
     * Constructor por defecto.
     */
    public Persona() {
        this.nombre = "";
        this.apellido = "";
        this.edad = 0;
        this.identificacion = "";
    }

    /**
     * Constructor con parámetros.
     * 
     * @param nombre Nombre de la persona
     * @param apellido Apellido de la persona
     * @param edad Edad de la persona
     * @param identificacion Identificación única de la persona
     */
    public Persona(String nombre, String apellido, int edad, String identificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        setEdad(edad);
        this.identificacion = identificacion;
    }

    // Getters y Setters

    /**
     * Obtiene el nombre de la persona.
     * 
     * @return El nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     * 
     * @param nombre El nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido de la persona.
     * 
     * @return El apellido de la persona
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido de la persona.
     * 
     * @param apellido El nuevo apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene la edad de la persona.
     * 
     * @return La edad de la persona
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad de la persona con validación.
     * 
     * @param edad La nueva edad (debe ser mayor o igual a 0)
     */
    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        }
    }

    /**
     * Obtiene la identificación de la persona.
     * 
     * @return La identificación de la persona
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * Establece la identificación de la persona.
     * 
     * @param identificacion La nueva identificación
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * Obtiene el nombre completo de la persona.
     * 
     * @return Nombre y apellido concatenados
     */
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    /**
     * Verifica si la persona es mayor de edad.
     * 
     * @return true si es mayor de 18 años, false en caso contrario
     */
    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", identificacion='" + identificacion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Persona persona = (Persona) obj;
        return identificacion != null && identificacion.equals(persona.identificacion);
    }

    @Override
    public int hashCode() {
        return identificacion != null ? identificacion.hashCode() : 0;
    }
}
