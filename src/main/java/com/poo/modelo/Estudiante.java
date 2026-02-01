package com.poo.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase que representa un estudiante, hereda de Persona.
 * Demuestra herencia, polimorfismo y uso de colecciones.
 * 
 * @author Diego
 * @version 1.0
 */
public class Estudiante extends Persona {
    
    private String matricula;
    private String carrera;
    private int semestre;
    private List<Double> calificaciones;

    /**
     * Constructor por defecto.
     */
    public Estudiante() {
        super();
        this.matricula = "";
        this.carrera = "";
        this.semestre = 1;
        this.calificaciones = new ArrayList<>();
    }

    /**
     * Constructor con parámetros.
     * 
     * @param nombre Nombre del estudiante
     * @param apellido Apellido del estudiante
     * @param edad Edad del estudiante
     * @param identificacion Identificación del estudiante
     * @param matricula Número de matrícula
     * @param carrera Carrera que estudia
     * @param semestre Semestre actual
     */
    public Estudiante(String nombre, String apellido, int edad, String identificacion,
                      String matricula, String carrera, int semestre) {
        super(nombre, apellido, edad, identificacion);
        this.matricula = matricula;
        this.carrera = carrera;
        setSemestre(semestre);
        this.calificaciones = new ArrayList<>();
    }

    // Getters y Setters

    /**
     * Obtiene la matrícula del estudiante.
     * 
     * @return La matrícula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula del estudiante.
     * 
     * @param matricula La nueva matrícula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Obtiene la carrera del estudiante.
     * 
     * @return La carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Establece la carrera del estudiante.
     * 
     * @param carrera La nueva carrera
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * Obtiene el semestre actual del estudiante.
     * 
     * @return El semestre
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Establece el semestre del estudiante con validación.
     * 
     * @param semestre El nuevo semestre (debe estar entre 1 y 12)
     */
    public void setSemestre(int semestre) {
        if (semestre >= 1 && semestre <= 12) {
            this.semestre = semestre;
        }
    }

    /**
     * Obtiene una copia inmutable de las calificaciones.
     * 
     * @return Lista de calificaciones
     */
    public List<Double> getCalificaciones() {
        return Collections.unmodifiableList(calificaciones);
    }

    /**
     * Agrega una calificación al estudiante.
     * 
     * @param calificacion Calificación a agregar (0.0 a 10.0)
     * @return true si se agregó correctamente, false si no es válida
     */
    public boolean agregarCalificacion(double calificacion) {
        if (calificacion >= 0.0 && calificacion <= 10.0) {
            calificaciones.add(calificacion);
            return true;
        }
        return false;
    }

    /**
     * Calcula el promedio de calificaciones del estudiante.
     * 
     * @return El promedio o 0.0 si no hay calificaciones
     */
    public double calcularPromedio() {
        if (calificaciones.isEmpty()) {
            return 0.0;
        }
        double suma = 0.0;
        for (Double calificacion : calificaciones) {
            suma += calificacion;
        }
        return suma / calificaciones.size();
    }

    /**
     * Verifica si el estudiante está aprobado (promedio >= 6.0).
     * 
     * @return true si está aprobado, false en caso contrario
     */
    public boolean estaAprobado() {
        return calcularPromedio() >= 6.0;
    }

    /**
     * Obtiene la calificación más alta del estudiante.
     * 
     * @return La calificación más alta o 0.0 si no hay calificaciones
     */
    public double obtenerCalificacionMaxima() {
        if (calificaciones.isEmpty()) {
            return 0.0;
        }
        return Collections.max(calificaciones);
    }

    /**
     * Obtiene la calificación más baja del estudiante.
     * 
     * @return La calificación más baja o 0.0 si no hay calificaciones
     */
    public double obtenerCalificacionMinima() {
        if (calificaciones.isEmpty()) {
            return 0.0;
        }
        return Collections.min(calificaciones);
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", edad=" + getEdad() +
                ", matricula='" + matricula + '\'' +
                ", carrera='" + carrera + '\'' +
                ", semestre=" + semestre +
                ", promedio=" + String.format("%.2f", calcularPromedio()) +
                '}';
    }
}
