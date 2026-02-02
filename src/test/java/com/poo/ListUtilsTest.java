package com.poo;

import com.poo.utils.ListUtils;
import java.util.Arrays;
import java.util.List;

/**
 * Tests para ListUtils.
 */
public class ListUtilsTest {

    public static void main(String[] args) {
        testMoverCerosADerecha();
        testMoverCerosADerechaSoloCeros();
        testMoverCerosADerechaSinCeros();
        testContarPares();
        testContarParesListaVacia();
        testContarParesTodosImpares();
        
        System.out.println("✓ Todos los tests de ListUtils pasaron");
    }

    /**
     * Test: mover ceros a la derecha caso basico.
     */
    private static void testMoverCerosADerecha() {
        List<Integer> input = Arrays.asList(0, 2, 1, 4, 0, 2);
        List<Integer> esperado = Arrays.asList(2, 1, 4, 2, 0, 0);
        List<Integer> resultado = ListUtils.moverCerosADerecha(input);
        assert resultado.equals(esperado) 
            : "Test mover ceros fallo: esperado " + esperado + ", obtenido " + resultado;
    }

    /**
     * Test: mover ceros cuando solo hay ceros.
     */
    private static void testMoverCerosADerechaSoloCeros() {
        List<Integer> input = Arrays.asList(0, 0, 0);
        List<Integer> esperado = Arrays.asList(0, 0, 0);
        List<Integer> resultado = ListUtils.moverCerosADerecha(input);
        assert resultado.equals(esperado) 
            : "Test solo ceros fallo";
    }

    /**
     * Test: mover ceros cuando no hay ceros.
     */
    private static void testMoverCerosADerechaSinCeros() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4);
        List<Integer> esperado = Arrays.asList(1, 2, 3, 4);
        List<Integer> resultado = ListUtils.moverCerosADerecha(input);
        assert resultado.equals(esperado) 
            : "Test sin ceros fallo";
    }

    /**
     * Test: contar pares caso basico.
     */
    private static void testContarPares() {
        List<Integer> input = Arrays.asList(3, 4, 5, 7, 6);
        long resultado = ListUtils.contarPares(input);
        assert resultado == 2 
            : "Test contar pares fallo: esperado 2, obtenido " + resultado;
    }

    /**
     * Test: contar pares en lista vacia.
     */
    private static void testContarParesListaVacia() {
        List<Integer> input = Arrays.asList();
        long resultado = ListUtils.contarPares(input);
        assert resultado == 0 
            : "Test lista vacia fallo: esperado 0, obtenido " + resultado;
    }

    /**
     * Test: contar pares cuando todos son impares.
     */
    private static void testContarParesTodosImpares() {
        List<Integer> input = Arrays.asList(1, 3, 5, 7, 9);
        long resultado = ListUtils.contarPares(input);
        assert resultado == 0 
            : "Test todos impares fallo: esperado 0, obtenido " + resultado;
    }
}
