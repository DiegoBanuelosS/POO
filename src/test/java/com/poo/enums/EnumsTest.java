package com.poo.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para las enumeraciones.
 */
@DisplayName("Tests de Enumeraciones")
class EnumsTest {

    @Nested
    @DisplayName("Tests de DiaSemana")
    class DiaSemanaTests {

        @Test
        @DisplayName("isEsLaboral retorna true para días laborales")
        void isEsLaboralTrue() {
            assertTrue(DiaSemana.LUNES.isEsLaboral());
            assertTrue(DiaSemana.VIERNES.isEsLaboral());
        }

        @Test
        @DisplayName("isEsLaboral retorna false para fin de semana")
        void isEsLaboralFalse() {
            assertFalse(DiaSemana.SABADO.isEsLaboral());
            assertFalse(DiaSemana.DOMINGO.isEsLaboral());
        }

        @Test
        @DisplayName("getSiguiente retorna el día siguiente")
        void getSiguiente() {
            assertEquals(DiaSemana.MARTES, DiaSemana.LUNES.getSiguiente());
            assertEquals(DiaSemana.LUNES, DiaSemana.DOMINGO.getSiguiente());
        }

        @Test
        @DisplayName("getAnterior retorna el día anterior")
        void getAnterior() {
            assertEquals(DiaSemana.LUNES, DiaSemana.MARTES.getAnterior());
            assertEquals(DiaSemana.DOMINGO, DiaSemana.LUNES.getAnterior());
        }

        @Test
        @DisplayName("diasHasta calcula días correctamente")
        void diasHasta() {
            assertEquals(4, DiaSemana.LUNES.diasHasta(DiaSemana.VIERNES));
            assertEquals(2, DiaSemana.VIERNES.diasHasta(DiaSemana.DOMINGO));
            assertEquals(0, DiaSemana.LUNES.diasHasta(DiaSemana.LUNES));
        }

        @Test
        @DisplayName("esFinDeSemana identifica sábado y domingo")
        void esFinDeSemana() {
            assertTrue(DiaSemana.SABADO.esFinDeSemana());
            assertTrue(DiaSemana.DOMINGO.esFinDeSemana());
            assertFalse(DiaSemana.VIERNES.esFinDeSemana());
        }

        @Test
        @DisplayName("obtenerPorNumero retorna día correcto")
        void obtenerPorNumero() {
            assertEquals(DiaSemana.LUNES, DiaSemana.obtenerPorNumero(1));
            assertEquals(DiaSemana.DOMINGO, DiaSemana.obtenerPorNumero(7));
            assertNull(DiaSemana.obtenerPorNumero(0));
            assertNull(DiaSemana.obtenerPorNumero(8));
        }
    }

    @Nested
    @DisplayName("Tests de Prioridad")
    class PrioridadTests {

        @Test
        @DisplayName("esMayorQue compara prioridades correctamente")
        void esMayorQue() {
            assertTrue(Prioridad.CRITICA.esMayorQue(Prioridad.ALTA));
            assertTrue(Prioridad.ALTA.esMayorQue(Prioridad.MEDIA));
            assertFalse(Prioridad.BAJA.esMayorQue(Prioridad.ALTA));
        }

        @Test
        @DisplayName("esMenorQue compara prioridades correctamente")
        void esMenorQue() {
            assertTrue(Prioridad.BAJA.esMenorQue(Prioridad.ALTA));
            assertFalse(Prioridad.CRITICA.esMenorQue(Prioridad.ALTA));
        }

        @Test
        @DisplayName("esUrgente identifica prioridades urgentes")
        void esUrgente() {
            assertTrue(Prioridad.CRITICA.esUrgente());
            assertTrue(Prioridad.ALTA.esUrgente());
            assertFalse(Prioridad.MEDIA.esUrgente());
            assertFalse(Prioridad.BAJA.esUrgente());
        }

        @Test
        @DisplayName("obtenerPorNivel retorna prioridad correcta")
        void obtenerPorNivel() {
            assertEquals(Prioridad.CRITICA, Prioridad.obtenerPorNivel(1));
            assertEquals(Prioridad.MEDIA, Prioridad.obtenerPorNivel(3));
            assertEquals(Prioridad.MEDIA, Prioridad.obtenerPorNivel(99));
        }
    }
}
