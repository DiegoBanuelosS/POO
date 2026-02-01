package com.poo;

import com.poo.models.Empleado;
import com.poo.utils.EmpleadoUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Tests para EmpleadoUtils.
 */
public class EmpleadoUtilsTest {

    public static void main(String[] args) {
        testMayorSalario();
        testEdadMasComun();
        testPromedioEdad();
        testPromedioSalario();
        testPromedioEdadSalarioAlto();
        testMenoresDe25();
        testContarSistemas();
        testMayorSalarioMayor30();
        testMenorSalarioEdadMenosComun();
        
        System.out.println("✓ Todos los tests de EmpleadoUtils pasaron");
    }

    private static List<Empleado> crearEmpleadosPrueba() {
        return Arrays.asList(
            new Empleado("Ana", 28, 30000, "Sistemas"),
            new Empleado("Carlos", 35, 45000, "Ventas"),
            new Empleado("Diana", 22, 20000, "Sistemas"),
            new Empleado("Eduardo", 28, 32000, "RRHH"),
            new Empleado("Fernanda", 40, 50000, "Gerencia"),
            new Empleado("Gabriel", 24, 22000, "Sistemas"),
            new Empleado("Helena", 28, 28000, "Marketing"),
            new Empleado("Ignacio", 31, 35000, "Sistemas")
        );
    }

    /**
     * Test: empleado con mayor salario.
     */
    private static void testMayorSalario() {
        List<Empleado> empleados = crearEmpleadosPrueba();
        Optional<Empleado> result = EmpleadoUtils.mayorSalario(empleados);
        assert result.isPresent() && result.get().getNombre().equals("Fernanda") 
            : "Test mayor salario fallo";
    }

    /**
     * Test: edad mas comun.
     */
    private static void testEdadMasComun() {
        List<Empleado> empleados = crearEmpleadosPrueba();
        Optional<Integer> result = EmpleadoUtils.edadMasComun(empleados);
        assert result.isPresent() && result.get() == 28 
            : "Test edad mas comun fallo: esperado 28, obtenido " + result.get();
    }

    /**
     * Test: promedio de edad.
     */
    private static void testPromedioEdad() {
        List<Empleado> empleados = crearEmpleadosPrueba();
        double result = EmpleadoUtils.promedioEdad(empleados);
        assert Math.abs(result - 29.5) < 0.1 
            : "Test promedio edad fallo: esperado ~29.5, obtenido " + result;
    }

    /**
     * Test: promedio de salario.
     */
    private static void testPromedioSalario() {
        List<Empleado> empleados = crearEmpleadosPrueba();
        double result = EmpleadoUtils.promedioSalario(empleados);
        assert result > 30000 && result < 35000 
            : "Test promedio salario fallo: obtenido " + result;
    }

    /**
     * Test: promedio de edad con salario > 25K.
     */
    private static void testPromedioEdadSalarioAlto() {
        List<Empleado> empleados = crearEmpleadosPrueba();
        double result = EmpleadoUtils.promedioEdadSalarioAlto(empleados);
        assert result > 30 
            : "Test promedio edad salario alto fallo: obtenido " + result;
    }

    /**
     * Test: filtrar menores de 25 anios.
     */
    private static void testMenoresDe25() {
        List<Empleado> empleados = crearEmpleadosPrueba();
        List<Empleado> result = EmpleadoUtils.menoresDe25(empleados);
        assert result.size() == 2 
            : "Test menores de 25 fallo: esperado 2, obtenido " + result.size();
    }

    /**
     * Test: contar empleados de sistemas.
     */
    private static void testContarSistemas() {
        List<Empleado> empleados = crearEmpleadosPrueba();
        long result = EmpleadoUtils.contarSistemas(empleados);
        assert result == 4 
            : "Test contar sistemas fallo: esperado 4, obtenido " + result;
    }

    /**
     * Test: mayor salario con mas de 30 anios.
     */
    private static void testMayorSalarioMayor30() {
        List<Empleado> empleados = crearEmpleadosPrueba();
        Optional<Empleado> result = EmpleadoUtils.mayorSalarioMayor30(empleados);
        assert result.isPresent() && result.get().getNombre().equals("Fernanda") 
            : "Test mayor salario > 30 anios fallo";
    }

    /**
     * Test: menor salario con edad menos comun.
     */
    private static void testMenorSalarioEdadMenosComun() {
        List<Empleado> empleados = crearEmpleadosPrueba();
        Optional<Empleado> result = EmpleadoUtils.menorSalarioEdadMenosComun(empleados);
        assert result.isPresent() 
            : "Test menor salario edad menos comun fallo";
    }
}
