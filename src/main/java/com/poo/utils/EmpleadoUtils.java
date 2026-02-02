package com.poo.utils;

import com.poo.models.Empleado;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Utilidades para operaciones con empleados.
 */
public class EmpleadoUtils {

    /**
     * Encuentra el empleado con mayor salario.
     * 
     * @param empleados lista de empleados
     * @return empleado con mayor salario
     */
    public static Optional<Empleado> mayorSalario(List<Empleado> empleados) {
        return empleados.stream()
                .max((e1, e2) -> Double.compare(e1.getSalario(), e2.getSalario()));
    }

    /**
     * Encuentra la edad mas comun entre los empleados.
     * 
     * @param empleados lista de empleados
     * @return edad mas frecuente
     */
    public static Optional<Integer> edadMasComun(List<Empleado> empleados) {
        return empleados.stream()
                .collect(Collectors.groupingBy(Empleado::getEdad, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    /**
     * Calcula el promedio de edad.
     * 
     * @param empleados lista de empleados
     * @return promedio de edad
     */
    public static double promedioEdad(List<Empleado> empleados) {
        return empleados.stream()
                .mapToInt(Empleado::getEdad)
                .average()
                .orElse(0.0);
    }

    /**
     * Calcula el promedio de salario.
     * 
     * @param empleados lista de empleados
     * @return promedio de salario
     */
    public static double promedioSalario(List<Empleado> empleados) {
        return empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average()
                .orElse(0.0);
    }

    /**
     * Calcula el promedio de edad de empleados con salario > 25K.
     * 
     * @param empleados lista de empleados
     * @return promedio de edad de empleados con salario > 25000
     */
    public static double promedioEdadSalarioAlto(List<Empleado> empleados) {
        return empleados.stream()
                .filter(e -> e.getSalario() > 25000)
                .mapToInt(Empleado::getEdad)
                .average()
                .orElse(0.0);
    }

    /**
     * Filtra empleados menores de 25 anios.
     * 
     * @param empleados lista de empleados
     * @return lista de empleados menores de 25
     */
    public static List<Empleado> menoresDe25(List<Empleado> empleados) {
        return empleados.stream()
                .filter(e -> e.getEdad() < 25)
                .collect(Collectors.toList());
    }

    /**
     * Cuenta empleados del departamento de sistemas.
     * 
     * @param empleados lista de empleados
     * @return cantidad de empleados en sistemas
     */
    public static long contarSistemas(List<Empleado> empleados) {
        return empleados.stream()
                .filter(e -> "sistemas".equalsIgnoreCase(e.getDepartamento()))
                .count();
    }

    /**
     * Encuentra el empleado con mayor salario y mas de 30 anios.
     * 
     * @param empleados lista de empleados
     * @return empleado con mayor salario y edad > 30
     */
    public static Optional<Empleado> mayorSalarioMayor30(List<Empleado> empleados) {
        return empleados.stream()
                .filter(e -> e.getEdad() > 30)
                .max((e1, e2) -> Double.compare(e1.getSalario(), e2.getSalario()));
    }

    /**
     * Encuentra el empleado con menor salario y edad menos comun.
     * 
     * @param empleados lista de empleados
     * @return empleado con menor salario y edad menos frecuente
     */
    public static Optional<Empleado> menorSalarioEdadMenosComun(List<Empleado> empleados) {
        Map<Integer, Long> frecuenciaEdades = empleados.stream()
                .collect(Collectors.groupingBy(Empleado::getEdad, Collectors.counting()));
        
        long minFrecuencia = frecuenciaEdades.values().stream()
                .min(Long::compare)
                .orElse(0L);
        
        return empleados.stream()
                .filter(e -> frecuenciaEdades.get(e.getEdad()) == minFrecuencia)
                .min((e1, e2) -> Double.compare(e1.getSalario(), e2.getSalario()));
    }
}
