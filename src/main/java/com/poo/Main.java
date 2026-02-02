package com.poo;

import com.poo.models.Empleado;
import com.poo.utils.EmpleadoUtils;
import com.poo.utils.ListUtils;
import com.poo.utils.StringUtils;
import java.util.Arrays;
import java.util.List;

/**
 * Clase principal con ejemplos de uso.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Ejemplos de ListUtils ===");
        demostrarListUtils();
        
        System.out.println("\n=== Ejemplos de StringUtils ===");
        demostrarStringUtils();
        
        System.out.println("\n=== Ejemplos de EmpleadoUtils ===");
        demostrarEmpleadoUtils();
    }

    private static void demostrarListUtils() {
        List<Integer> numeros = Arrays.asList(0, 2, 1, 4, 0, 2);
        System.out.println("Lista original: " + numeros);
        System.out.println("Ceros a la derecha: " + ListUtils.moverCerosADerecha(numeros));
        
        List<Integer> pares = Arrays.asList(3, 4, 5, 7, 6);
        System.out.println("Numeros pares en " + pares + ": " + ListUtils.contarPares(pares));
    }

    private static void demostrarStringUtils() {
        System.out.println("'ana' es palindromo? " + StringUtils.esPalindromo("ana"));
        System.out.println("'hola mundo' es palindromo? " + StringUtils.esPalindromo("hola mundo"));
        System.out.println("Vocales en 'hola': " + StringUtils.contarVocales("hola"));
        System.out.println("'hola' invertido: " + StringUtils.invertir("hola"));
        System.out.println("Posicion de 'o' en 'hola': " + StringUtils.encontrarCaracter("hola", 'o'));
        System.out.println("Posicion de 'r' en 'hola': " + StringUtils.encontrarCaracter("hola", 'r'));
    }

    private static void demostrarEmpleadoUtils() {
        List<Empleado> empleados = Arrays.asList(
            new Empleado("Ana", 28, 30000, "Sistemas"),
            new Empleado("Carlos", 35, 45000, "Ventas"),
            new Empleado("Diana", 22, 20000, "Sistemas"),
            new Empleado("Eduardo", 28, 32000, "RRHH")
        );

        EmpleadoUtils.mayorSalario(empleados)
            .ifPresent(e -> System.out.println("Mayor salario: " + e));
        
        EmpleadoUtils.edadMasComun(empleados)
            .ifPresent(edad -> System.out.println("Edad mas comun: " + edad));
        
        System.out.println("Promedio edad: " + EmpleadoUtils.promedioEdad(empleados));
        System.out.println("Promedio salario: " + EmpleadoUtils.promedioSalario(empleados));
        System.out.println("Empleados en Sistemas: " + EmpleadoUtils.contarSistemas(empleados));
    }
}
