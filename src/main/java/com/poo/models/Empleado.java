package com.poo.models;

import java.util.Objects;

/**
 * Representa un empleado con sus atributos basicos.
 */
public class Empleado {
    private final String nombre;
    private final int edad;
    private final double salario;
    private final String departamento;

    /**
     * Crea un nuevo empleado.
     * 
     * @param nombre nombre del empleado
     * @param edad edad del empleado
     * @param salario salario del empleado
     * @param departamento departamento del empleado
     */
    public Empleado(String nombre, int edad, double salario, String departamento) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return edad == empleado.edad &&
               Double.compare(empleado.salario, salario) == 0 &&
               Objects.equals(nombre, empleado.nombre) &&
               Objects.equals(departamento, empleado.departamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad, salario, departamento);
    }

    @Override
    public String toString() {
        return String.format("Empleado{nombre='%s', edad=%d, salario=%.2f, departamento='%s'}",
                nombre, edad, salario, departamento);
    }
}
