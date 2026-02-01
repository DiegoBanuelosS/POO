package com.poo.geometria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para las clases de figuras geométricas.
 */
@DisplayName("Tests de Figuras Geométricas")
class FigurasTest {

    @Nested
    @DisplayName("Tests de Círculo")
    class CirculoTests {

        private Circulo circulo;

        @BeforeEach
        void setUp() {
            circulo = new Circulo(5);
        }

        @Test
        @DisplayName("Constructor inicializa radio correctamente")
        void constructorInicializaRadio() {
            assertEquals(5, circulo.getRadio());
        }

        @Test
        @DisplayName("calcularArea retorna área correcta")
        void calcularArea() {
            double areaEsperada = Math.PI * 25;
            assertEquals(areaEsperada, circulo.calcularArea(), 0.001);
        }

        @Test
        @DisplayName("calcularPerimetro retorna perímetro correcto")
        void calcularPerimetro() {
            double perimetroEsperado = 2 * Math.PI * 5;
            assertEquals(perimetroEsperado, circulo.calcularPerimetro(), 0.001);
        }

        @Test
        @DisplayName("getDiametro retorna el doble del radio")
        void getDiametro() {
            assertEquals(10, circulo.getDiametro());
        }

        @Test
        @DisplayName("setRadio rechaza valores no positivos")
        void setRadioRechazaNegativos() {
            circulo.setRadio(-5);
            assertEquals(5, circulo.getRadio());
            
            circulo.setRadio(0);
            assertEquals(5, circulo.getRadio());
        }
    }

    @Nested
    @DisplayName("Tests de Rectángulo")
    class RectanguloTests {

        private Rectangulo rectangulo;

        @BeforeEach
        void setUp() {
            rectangulo = new Rectangulo(8, 4);
        }

        @Test
        @DisplayName("Constructor inicializa dimensiones correctamente")
        void constructorInicializaDimensiones() {
            assertEquals(8, rectangulo.getBase());
            assertEquals(4, rectangulo.getAltura());
        }

        @Test
        @DisplayName("calcularArea retorna área correcta")
        void calcularArea() {
            assertEquals(32, rectangulo.calcularArea(), 0.001);
        }

        @Test
        @DisplayName("calcularPerimetro retorna perímetro correcto")
        void calcularPerimetro() {
            assertEquals(24, rectangulo.calcularPerimetro(), 0.001);
        }

        @Test
        @DisplayName("calcularDiagonal retorna diagonal correcta")
        void calcularDiagonal() {
            double diagonalEsperada = Math.sqrt(64 + 16);
            assertEquals(diagonalEsperada, rectangulo.calcularDiagonal(), 0.001);
        }

        @Test
        @DisplayName("esCuadrado retorna false para rectángulo")
        void esCuadradoFalse() {
            assertFalse(rectangulo.esCuadrado());
        }

        @Test
        @DisplayName("esCuadrado retorna true para cuadrado")
        void esCuadradoTrue() {
            Rectangulo cuadrado = new Rectangulo(5, 5);
            assertTrue(cuadrado.esCuadrado());
        }
    }

    @Nested
    @DisplayName("Tests de Triángulo")
    class TrianguloTests {

        @Test
        @DisplayName("Constructor crea triángulo válido")
        void constructorTrianguloValido() {
            Triangulo triangulo = new Triangulo(3, 4, 5);
            assertEquals(3, triangulo.getLadoA());
            assertEquals(4, triangulo.getLadoB());
            assertEquals(5, triangulo.getLadoC());
        }

        @Test
        @DisplayName("Constructor lanza excepción para triángulo inválido")
        void constructorTrianguloInvalido() {
            assertThrows(IllegalArgumentException.class, () -> 
                new Triangulo(1, 2, 10));
        }

        @Test
        @DisplayName("esTrianguloValido valida correctamente")
        void esTrianguloValido() {
            assertTrue(Triangulo.esTrianguloValido(3, 4, 5));
            assertFalse(Triangulo.esTrianguloValido(1, 2, 10));
            assertFalse(Triangulo.esTrianguloValido(-1, 2, 2));
        }

        @Test
        @DisplayName("calcularArea con fórmula de Herón")
        void calcularArea() {
            Triangulo triangulo = new Triangulo(3, 4, 5);
            assertEquals(6, triangulo.calcularArea(), 0.001);
        }

        @Test
        @DisplayName("calcularPerimetro suma los tres lados")
        void calcularPerimetro() {
            Triangulo triangulo = new Triangulo(3, 4, 5);
            assertEquals(12, triangulo.calcularPerimetro(), 0.001);
        }

        @Test
        @DisplayName("obtenerTipo retorna Equilátero")
        void obtenerTipoEquilatero() {
            Triangulo triangulo = new Triangulo(5, 5, 5);
            assertEquals("Equilátero", triangulo.obtenerTipo());
        }

        @Test
        @DisplayName("obtenerTipo retorna Isósceles")
        void obtenerTipoIsosceles() {
            Triangulo triangulo = new Triangulo(5, 5, 3);
            assertEquals("Isósceles", triangulo.obtenerTipo());
        }

        @Test
        @DisplayName("obtenerTipo retorna Escaleno")
        void obtenerTipoEscaleno() {
            Triangulo triangulo = new Triangulo(3, 4, 5);
            assertEquals("Escaleno", triangulo.obtenerTipo());
        }

        @Test
        @DisplayName("esRectangulo detecta triángulo rectángulo")
        void esRectanguloTrue() {
            Triangulo triangulo = new Triangulo(3, 4, 5);
            assertTrue(triangulo.esRectangulo());
        }

        @Test
        @DisplayName("esRectangulo retorna false para no rectángulo")
        void esRectanguloFalse() {
            Triangulo triangulo = new Triangulo(5, 5, 5);
            assertFalse(triangulo.esRectangulo());
        }
    }
}
