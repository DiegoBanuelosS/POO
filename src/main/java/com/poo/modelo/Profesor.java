package com.poo.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase que representa un profesor, hereda de Persona.
 * Demuestra herencia y composición.
 * 
 * @author Diego
 * @version 1.0
 */
public class Profesor extends Persona {
    
    private String numeroEmpleado;
    private String departamento;
    private double salarioBase;
    private List<String> materiasImpartidas;

    /**
     * Constructor por defecto.
     */
    public Profesor() {
        super();
        this.numeroEmpleado = "";
        this.departamento = "";
        this.salarioBase = 0.0;
        this.materiasImpartidas = new ArrayList<>();
    }

    /**
     * Constructor con parámetros.
     * 
     * @param nombre Nombre del profesor
     * @param apellido Apellido del profesor
     * @param edad Edad del profesor
     * @param identificacion Identificación del profesor
     * @param numeroEmpleado Número de empleado
     * @param departamento Departamento al que pertenece
     * @param salarioBase Salario base del profesor
     */
    public Profesor(String nombre, String apellido, int edad, String identificacion,
                    String numeroEmpleado, String departamento, double salarioBase) {
        super(nombre, apellido, edad, identificacion);
        this.numeroEmpleado = numeroEmpleado;
        this.departamento = departamento;
        setSalarioBase(salarioBase);
        this.materiasImpartidas = new ArrayList<>();
    }

    // Getters y Setters

    /**
     * Obtiene el número de empleado.
     * 
     * @return El número de empleado
     */
    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    /**
     * Establece el número de empleado.
     * 
     * @param numeroEmpleado El nuevo número de empleado
     */
    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    /**
     * Obtiene el departamento del profesor.
     * 
     * @return El departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Establece el departamento del profesor.
     * 
     * @param departamento El nuevo departamento
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Obtiene el salario base del profesor.
     * 
     * @return El salario base
     */
    public double getSalarioBase() {
        return salarioBase;
    }

    /**
     * Establece el salario base del profesor con validación.
     * 
     * @param salarioBase El nuevo salario base (debe ser positivo)
     */
    public void setSalarioBase(double salarioBase) {
        if (salarioBase >= 0) {
            this.salarioBase = salarioBase;
        }
    }

    /**
     * Obtiene las materias impartidas por el profesor.
     * 
     * @return Lista inmutable de materias
     */
    public List<String> getMateriasImpartidas() {
        return Collections.unmodifiableList(materiasImpartidas);
    }

    /**
     * Agrega una materia al profesor.
     * 
     * @param materia La materia a agregar
     * @return true si se agregó correctamente
     */
    public boolean agregarMateria(String materia) {
        if (materia != null && !materia.trim().isEmpty() && !materiasImpartidas.contains(materia)) {
            materiasImpartidas.add(materia);
            return true;
        }
        return false;
    }

    /**
     * Elimina una materia del profesor.
     * 
     * @param materia La materia a eliminar
     * @return true si se eliminó correctamente
     */
    public boolean eliminarMateria(String materia) {
        return materiasImpartidas.remove(materia);
    }

    /**
     * Calcula el salario total incluyendo bonificaciones.
     * Bonificación: 5% por cada materia impartida.
     * 
     * @return El salario total
     */
    public double calcularSalarioTotal() {
        double bonificacion = salarioBase * 0.05 * materiasImpartidas.size();
        return salarioBase + bonificacion;
    }

    /**
     * Obtiene el número de materias que imparte el profesor.
     * 
     * @return Cantidad de materias
     */
    public int obtenerNumeroMaterias() {
        return materiasImpartidas.size();
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", numeroEmpleado='" + numeroEmpleado + '\'' +
                ", departamento='" + departamento + '\'' +
                ", salarioTotal=" + String.format("%.2f", calcularSalarioTotal()) +
                ", materias=" + materiasImpartidas +
                '}';
    }
}
