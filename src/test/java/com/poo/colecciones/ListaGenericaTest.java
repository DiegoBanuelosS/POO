package com.poo.colecciones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para la clase ListaGenerica.
 */
@DisplayName("Tests de ListaGenerica")
class ListaGenericaTest {

    private ListaGenerica<Integer> lista;

    @BeforeEach
    void setUp() {
        lista = new ListaGenerica<>();
    }

    @Nested
    @DisplayName("Tests de Operaciones Básicas")
    class OperacionesBasicasTests {

        @Test
        @DisplayName("agregar añade elemento a la lista")
        void agregar() {
            assertTrue(lista.agregar(5));
            assertEquals(1, lista.tamanio());
        }

        @Test
        @DisplayName("agregar rechaza elementos nulos")
        void agregarNull() {
            assertFalse(lista.agregar(null));
            assertEquals(0, lista.tamanio());
        }

        @Test
        @DisplayName("agregarVarios añade múltiples elementos")
        void agregarVarios() {
            int agregados = lista.agregarVarios(1, 2, 3, 4, 5);
            assertEquals(5, agregados);
            assertEquals(5, lista.tamanio());
        }

        @Test
        @DisplayName("eliminar remueve elemento existente")
        void eliminar() {
            lista.agregarVarios(1, 2, 3);
            assertTrue(lista.eliminar(2));
            assertEquals(2, lista.tamanio());
            assertFalse(lista.contiene(2));
        }

        @Test
        @DisplayName("eliminarEn remueve por índice")
        void eliminarEn() {
            lista.agregarVarios(1, 2, 3);
            Integer eliminado = lista.eliminarEn(1);
            assertEquals(2, eliminado);
            assertEquals(2, lista.tamanio());
        }

        @Test
        @DisplayName("eliminarEn retorna null para índice inválido")
        void eliminarEnIndiceInvalido() {
            lista.agregarVarios(1, 2);
            assertNull(lista.eliminarEn(10));
            assertNull(lista.eliminarEn(-1));
        }

        @Test
        @DisplayName("obtener retorna Optional con elemento")
        void obtener() {
            lista.agregarVarios(1, 2, 3);
            Optional<Integer> resultado = lista.obtener(1);
            assertTrue(resultado.isPresent());
            assertEquals(2, resultado.get());
        }

        @Test
        @DisplayName("obtener retorna Optional vacío para índice inválido")
        void obtenerIndiceInvalido() {
            lista.agregar(1);
            assertTrue(lista.obtener(5).isEmpty());
            assertTrue(lista.obtener(-1).isEmpty());
        }

        @Test
        @DisplayName("contiene verifica existencia de elemento")
        void contiene() {
            lista.agregarVarios(1, 2, 3);
            assertTrue(lista.contiene(2));
            assertFalse(lista.contiene(5));
        }

        @Test
        @DisplayName("buscar retorna índice correcto")
        void buscar() {
            lista.agregarVarios(10, 20, 30);
            assertEquals(1, lista.buscar(20));
            assertEquals(-1, lista.buscar(50));
        }

        @Test
        @DisplayName("limpiar elimina todos los elementos")
        void limpiar() {
            lista.agregarVarios(1, 2, 3);
            lista.limpiar();
            assertTrue(lista.estaVacia());
            assertEquals(0, lista.tamanio());
        }
    }

    @Nested
    @DisplayName("Tests de Operaciones Funcionales")
    class OperacionesFuncionalesTests {

        @BeforeEach
        void setUpLista() {
            lista.agregarVarios(1, 2, 3, 4, 5, 6);
        }

        @Test
        @DisplayName("filtrar retorna elementos que cumplen condición")
        void filtrar() {
            List<Integer> pares = lista.filtrar(n -> n % 2 == 0);
            assertEquals(3, pares.size());
            assertTrue(pares.containsAll(List.of(2, 4, 6)));
        }

        @Test
        @DisplayName("transformar aplica función a cada elemento")
        void transformar() {
            List<Integer> cuadrados = lista.transformar(n -> n * n);
            assertEquals(List.of(1, 4, 9, 16, 25, 36), cuadrados);
        }

        @Test
        @DisplayName("buscarPrimero encuentra primer elemento que cumple")
        void buscarPrimero() {
            Optional<Integer> resultado = lista.buscarPrimero(n -> n > 3);
            assertTrue(resultado.isPresent());
            assertEquals(4, resultado.get());
        }

        @Test
        @DisplayName("buscarPrimero retorna vacío si ninguno cumple")
        void buscarPrimeroSinResultado() {
            Optional<Integer> resultado = lista.buscarPrimero(n -> n > 100);
            assertTrue(resultado.isEmpty());
        }

        @Test
        @DisplayName("todosCumplen verifica que todos cumplan condición")
        void todosCumplen() {
            assertTrue(lista.todosCumplen(n -> n > 0));
            assertFalse(lista.todosCumplen(n -> n > 3));
        }

        @Test
        @DisplayName("algunoCumple verifica que al menos uno cumpla")
        void algunoCumple() {
            assertTrue(lista.algunoCumple(n -> n == 5));
            assertFalse(lista.algunoCumple(n -> n > 100));
        }
    }

    @Nested
    @DisplayName("Tests de Ordenamiento")
    class OrdenamientoTests {

        @Test
        @DisplayName("ordenar ordena con comparador")
        void ordenar() {
            lista.agregarVarios(3, 1, 4, 1, 5, 9);
            lista.ordenar(Integer::compareTo);
            assertEquals(List.of(1, 1, 3, 4, 5, 9), lista.obtenerTodos());
        }

        @Test
        @DisplayName("invertir invierte el orden")
        void invertir() {
            lista.agregarVarios(1, 2, 3);
            lista.invertir();
            assertEquals(List.of(3, 2, 1), lista.obtenerTodos());
        }
    }
}
