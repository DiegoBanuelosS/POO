package com.poo.utils;

/**
 * Utilidades para manipulacion de cadenas.
 */
public class StringUtils {

    /**
     * Determina si una cadena es palindromo (ignorando espacios y mayusculas).
     * 
     * @param texto cadena a evaluar
     * @return true si es palindromo, false en caso contrario
     */
    public static boolean esPalindromo(String texto) {
        String limpio = texto.replaceAll("\\s+", "").toLowerCase();
        return limpio.equals(new StringBuilder(limpio).reverse().toString());
    }

    /**
     * Cuenta el numero de vocales en una cadena.
     * 
     * @param texto cadena a analizar
     * @return cantidad de vocales
     */
    public static long contarVocales(String texto) {
        return texto.toLowerCase().chars()
                .filter(c -> "aeiouaeiou".indexOf(c) >= 0) // Incluye vocales acentuadas
                .count();
    }

    /**
     * Invierte una cadena sin usar reverse().
     * 
     * @param texto cadena a invertir
     * @return cadena invertida
     */
    public static String invertir(String texto) {
        char[] chars = texto.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }

    /**
     * Encuentra la primera posicion de un caracter en una cadena.
     * 
     * @param texto cadena donde buscar
     * @param caracter caracter a buscar
     * @return indice de la primera ocurrencia, -1 si no se encuentra
     */
    public static int encontrarCaracter(String texto, char caracter) {
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == caracter) {
                return i;
            }
        }
        return -1;
    }
}
