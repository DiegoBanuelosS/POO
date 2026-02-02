package com.poo.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Utilidades para operaciones con listas.
 */
public class ListUtils {

    /**
     * Mueve todos los ceros al final de la lista manteniendo el orden de los demas elementos.
     * 
     * @param numeros lista de numeros enteros
     * @return nueva lista con ceros movidos a la derecha
     */
    public static List<Integer> moverCerosADerecha(List<Integer> numeros) {
        List<Integer> resultado = new ArrayList<>();
        int contadorCeros = 0;
        
        // Agregar elementos no-cero
        for (Integer num : numeros) {
            if (num == 0) {
                contadorCeros++;
            } else {
                resultado.add(num);
            }
        }
        
        // Agregar ceros al final
        for (int i = 0; i < contadorCeros; i++) {
            resultado.add(0);
        }
        
        return resultado;
    }

    /**
     * Cuenta la cantidad de numeros pares en una lista.
     * 
     * @param numeros lista de numeros enteros
     * @return cantidad de numeros pares
     */
    public static long contarPares(List<Integer> numeros) {
        return numeros.stream()
                .filter(n -> n % 2 == 0)
                .count();
    }
}
