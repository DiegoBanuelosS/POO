package com.poo.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para la clase Estudiante.
 */
@DisplayName("Tests de Estudiante")
class EstudianteTest {

    private Estudiante estudiante;

    @BeforeEach
    void setUp() {
        estudiante = new Estudiante("María", "López", 20, "87654321B",
                                    "EST001", "Ingeniería", 3);
    }

    @Nested
    @DisplayName("Tests de Constructores")
    class ConstructorTests {

        @Test
        @DisplayName("Constructor por defecto inicializa valores correctamente")
        void constructorPorDefecto() {
            Estudiante e = new Estudiante();
            assertEquals("", e.getMatricula());
            assertEquals("", e.getCarrera());
            assertEquals(1, e.getSemestre());
            assertTrue(e.getCalificaciones().isEmpty());
        }

        @Test
        @DisplayName("Constructor con parámetros inicializa correctamente")
        void constructorConParametros() {
            assertEquals("EST001", estudiante.getMatricula());
            assertEquals("Ingeniería", estudiante.getCarrera());
            assertEquals(3, estudiante.getSemestre());
        }
    }

    @Nested
    @DisplayName("Tests de Calificaciones")
    class CalificacionesTests {

        @Test
        @DisplayName("agregarCalificacion agrega calificación válida")
        void agregarCalificacionValida() {
            assertTrue(estudiante.agregarCalificacion(8.5));
            assertEquals(1, estudiante.getCalificaciones().size());
        }

        @Test
        @DisplayName("agregarCalificacion rechaza calificación mayor a 10")
        void agregarCalificacionMayorA10() {
            assertFalse(estudiante.agregarCalificacion(11.0));
            assertTrue(estudiante.getCalificaciones().isEmpty());
        }

        @Test
        @DisplayName("agregarCalificacion rechaza calificación negativa")
        void agregarCalificacionNegativa() {
            assertFalse(estudiante.agregarCalificacion(-1.0));
        }

        @Test
        @DisplayName("calcularPromedio con calificaciones")
        void calcularPromedio() {
            estudiante.agregarCalificacion(8.0);
            estudiante.agregarCalificacion(9.0);
            estudiante.agregarCalificacion(7.0);
            assertEquals(8.0, estudiante.calcularPromedio(), 0.01);
        }

        @Test
        @DisplayName("calcularPromedio sin calificaciones retorna 0")
        void calcularPromedioSinCalificaciones() {
            assertEquals(0.0, estudiante.calcularPromedio());
        }

        @Test
        @DisplayName("estaAprobado con promedio mayor o igual a 6")
        void estaAprobadoConPromedioSuficiente() {
            estudiante.agregarCalificacion(7.0);
            estudiante.agregarCalificacion(8.0);
            assertTrue(estudiante.estaAprobado());
        }

        @Test
        @DisplayName("estaAprobado con promedio menor a 6")
        void estaAprobadoConPromedioInsuficiente() {
            estudiante.agregarCalificacion(4.0);
            estudiante.agregarCalificacion(5.0);
            assertFalse(estudiante.estaAprobado());
        }

        @Test
        @DisplayName("obtenerCalificacionMaxima retorna la máxima")
        void obtenerCalificacionMaxima() {
            estudiante.agregarCalificacion(7.0);
            estudiante.agregarCalificacion(9.5);
            estudiante.agregarCalificacion(8.0);
            assertEquals(9.5, estudiante.obtenerCalificacionMaxima());
        }

        @Test
        @DisplayName("obtenerCalificacionMinima retorna la mínima")
        void obtenerCalificacionMinima() {
            estudiante.agregarCalificacion(7.0);
            estudiante.agregarCalificacion(9.5);
            estudiante.agregarCalificacion(6.5);
            assertEquals(6.5, estudiante.obtenerCalificacionMinima());
        }
    }

    @Nested
    @DisplayName("Tests de Semestre")
    class SemestreTests {

        @Test
        @DisplayName("setSemestre acepta valores válidos")
        void setSemestreValido() {
            estudiante.setSemestre(5);
            assertEquals(5, estudiante.getSemestre());
        }

        @Test
        @DisplayName("setSemestre rechaza valores menores a 1")
        void setSemestreMenorA1() {
            estudiante.setSemestre(0);
            assertEquals(3, estudiante.getSemestre());
        }

        @Test
        @DisplayName("setSemestre rechaza valores mayores a 12")
        void setSemestreMayorA12() {
            estudiante.setSemestre(15);
            assertEquals(3, estudiante.getSemestre());
        }
    }
}
