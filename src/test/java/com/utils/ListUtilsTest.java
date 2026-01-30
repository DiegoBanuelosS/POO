package com.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Tests para la clase ListUtils
 */
public class ListUtilsTest {

    @Test
    public void testMoverCerosAlFinal_CasoBasico() {
        // Caso del ejemplo: {0,2,1,4,0,2} -> {2,1,4,2,0,0}
        List<Integer> numeros = new ArrayList<>(Arrays.asList(0, 2, 1, 4, 0, 2));
        List<Integer> esperado = Arrays.asList(2, 1, 4, 2, 0, 0);

        ListUtils.moverCerosAlFinal(numeros);

        assertEquals(esperado, numeros);
    }

    @Test
    public void testMoverCerosAlFinal_SinCeros() {
        // Lista sin ceros, debe mantenerse igual
        List<Integer> numeros = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> esperado = Arrays.asList(1, 2, 3, 4);

        ListUtils.moverCerosAlFinal(numeros);

        assertEquals(esperado, numeros);
    }

    @Test
    public void testMoverCerosAlFinal_SoloCeros() {
        // Lista con solo ceros
        List<Integer> numeros = new ArrayList<>(Arrays.asList(0, 0, 0));
        List<Integer> esperado = Arrays.asList(0, 0, 0);

        ListUtils.moverCerosAlFinal(numeros);

        assertEquals(esperado, numeros);
    }

    @Test
    public void testMoverCerosAlFinal_ListaVacia() {
        // Lista vacía
        List<Integer> numeros = new ArrayList<>();

        ListUtils.moverCerosAlFinal(numeros);

        assertTrue(numeros.isEmpty());
    }

    @Test
    public void testMoverCerosAlFinal_ListaNula() {
        // Lista nula - no debe lanzar excepción
        assertDoesNotThrow(() -> ListUtils.moverCerosAlFinal(null));
    }
}
