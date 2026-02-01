package com.poo.patrones;

import com.poo.modelo.Persona;
import com.poo.modelo.Estudiante;
import com.poo.modelo.Profesor;

/**
 * Clase Factory para crear diferentes tipos de personas.
 * Demuestra el patrón de diseño Factory.
 * 
 * @author Diego
 * @version 1.0
 */
public class PersonaFactory {
    
    /**
     * Enumeración de tipos de persona que puede crear la fábrica.
     */
    public enum TipoPersona {
        PERSONA,
        ESTUDIANTE,
        PROFESOR
    }

    /**
     * Crea una persona según el tipo especificado.
     * 
     * @param tipo Tipo de persona a crear
     * @return La persona creada
     */
    public Persona crearPersona(TipoPersona tipo) {
        return switch (tipo) {
            case PERSONA -> new Persona();
            case ESTUDIANTE -> new Estudiante();
            case PROFESOR -> new Profesor();
        };
    }

    /**
     * Crea una persona con datos básicos.
     * 
     * @param tipo Tipo de persona
     * @param nombre Nombre de la persona
     * @param apellido Apellido de la persona
     * @param edad Edad de la persona
     * @param identificacion Identificación de la persona
     * @return La persona creada
     */
    public Persona crearPersona(TipoPersona tipo, String nombre, String apellido, 
                                 int edad, String identificacion) {
        Persona persona = crearPersona(tipo);
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setEdad(edad);
        persona.setIdentificacion(identificacion);
        return persona;
    }

    /**
     * Crea un estudiante con todos sus datos.
     * 
     * @param nombre Nombre del estudiante
     * @param apellido Apellido del estudiante
     * @param edad Edad del estudiante
     * @param identificacion Identificación del estudiante
     * @param matricula Matrícula del estudiante
     * @param carrera Carrera del estudiante
     * @param semestre Semestre actual
     * @return El estudiante creado
     */
    public Estudiante crearEstudiante(String nombre, String apellido, int edad,
                                       String identificacion, String matricula,
                                       String carrera, int semestre) {
        return new Estudiante(nombre, apellido, edad, identificacion, 
                              matricula, carrera, semestre);
    }

    /**
     * Crea un profesor con todos sus datos.
     * 
     * @param nombre Nombre del profesor
     * @param apellido Apellido del profesor
     * @param edad Edad del profesor
     * @param identificacion Identificación del profesor
     * @param numeroEmpleado Número de empleado
     * @param departamento Departamento
     * @param salarioBase Salario base
     * @return El profesor creado
     */
    public Profesor crearProfesor(String nombre, String apellido, int edad,
                                   String identificacion, String numeroEmpleado,
                                   String departamento, double salarioBase) {
        return new Profesor(nombre, apellido, edad, identificacion,
                           numeroEmpleado, departamento, salarioBase);
    }
}
