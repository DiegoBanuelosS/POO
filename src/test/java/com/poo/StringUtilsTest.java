package com.poo;

import com.poo.utils.StringUtils;

/**
 * Tests para StringUtils.
 */
public class StringUtilsTest {

    public static void main(String[] args) {
        testPalindromo();
        testPalindromoConEspacios();
        testNoPalindromo();
        testContarVocales();
        testInvertir();
        testEncontrarCaracter();
        testEncontrarCaracterNoExiste();
        
        System.out.println("✓ Todos los tests de StringUtils pasaron");
    }

    /**
     * Test: palindromo basico.
     */
    private static void testPalindromo() {
        boolean result = StringUtils.esPalindromo("ana");
        assert result : "Test palindromo fallo: 'ana' deberia ser palindromo";
    }

    /**
     * Test: palindromo con espacios.
     */
    private static void testPalindromoConEspacios() {
        boolean result = StringUtils.esPalindromo("anita lava la tina");
        assert result : "Test palindromo con espacios fallo";
    }

    /**
     * Test: no palindromo.
     */
    private static void testNoPalindromo() {
        boolean result = StringUtils.esPalindromo("hola mundo");
        assert !result : "Test no palindromo fallo: 'hola mundo' no deberia ser palindromo";
    }

    /**
     * Test: contar vocales.
     */
    private static void testContarVocales() {
        long result = StringUtils.contarVocales("hola");
        assert result == 2 : "Test contar vocales fallo: esperado 2, obtenido " + result;
    }

    /**
     * Test: invertir cadena.
     */
    private static void testInvertir() {
        String result = StringUtils.invertir("hola");
        assert "aloh".equals(result) : "Test invertir fallo: esperado 'aloh', obtenido '" + result + "'";
    }

    /**
     * Test: encontrar caracter que existe.
     */
    private static void testEncontrarCaracter() {
        int result = StringUtils.encontrarCaracter("hola", 'o');
        assert result == 1 : "Test encontrar caracter fallo: esperado 1, obtenido " + result;
    }

    /**
     * Test: encontrar caracter que no existe.
     */
    private static void testEncontrarCaracterNoExiste() {
        int result = StringUtils.encontrarCaracter("hola", 'r');
        assert result == -1 : "Test encontrar caracter no existe fallo: esperado -1, obtenido " + result;
    }
}
