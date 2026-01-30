package com.utils;

import java.util.List;

/**
 * Clase de utilidades para operaciones con listas
 */
public class ListUtils {

    /**
     * Mueve todos los ceros al final de la lista manteniendo el orden relativo
     * de los demás elementos.
     * 
     * @param numeros Lista de números enteros
     */
    public static void moverCerosAlFinal(List<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            return;
        }

        int posicionNoZero = 0;

        // Mover todos los elementos no-cero hacia la izquierda
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) != 0) {
                numeros.set(posicionNoZero, numeros.get(i));
                posicionNoZero++;
            }
        }

        // Rellenar el resto con ceros
        while (posicionNoZero < numeros.size()) {
            numeros.set(posicionNoZero, 0);
            posicionNoZero++;
        }
    }
}
