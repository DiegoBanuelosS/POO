package com.poo.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para la clase Persona.
 */
@DisplayName("Tests de Persona")
class PersonaTest {

    private Persona persona;

    @BeforeEach
    void setUp() {
        persona = new Persona("Juan", "García", 25, "12345678A");
    }

    @Nested
    @DisplayName("Tests de Constructores")
    class ConstructorTests {

        @Test
        @DisplayName("Constructor por defecto inicializa valores vacíos")
        void constructorPorDefecto() {
            Persona p = new Persona();
            assertEquals("", p.getNombre());
            assertEquals("", p.getApellido());
            assertEquals(0, p.getEdad());
            assertEquals("", p.getIdentificacion());
        }

        @Test
        @DisplayName("Constructor con parámetros inicializa correctamente")
        void constructorConParametros() {
            assertEquals("Juan", persona.getNombre());
            assertEquals("García", persona.getApellido());
            assertEquals(25, persona.getEdad());
            assertEquals("12345678A", persona.getIdentificacion());
        }
    }

    @Nested
    @DisplayName("Tests de Setters")
    class SetterTests {

        @Test
        @DisplayName("setEdad rechaza valores negativos")
        void setEdadRechazaNegativos() {
            persona.setEdad(-5);
            assertEquals(25, persona.getEdad());
        }

        @Test
        @DisplayName("setEdad acepta valores válidos")
        void setEdadAceptaValidos() {
            persona.setEdad(30);
            assertEquals(30, persona.getEdad());
        }
    }

    @Nested
    @DisplayName("Tests de Métodos")
    class MetodoTests {

        @Test
        @DisplayName("getNombreCompleto retorna nombre y apellido")
        void getNombreCompleto() {
            assertEquals("Juan García", persona.getNombreCompleto());
        }

        @Test
        @DisplayName("esMayorDeEdad retorna true para mayores de 18")
        void esMayorDeEdadTrue() {
            assertTrue(persona.esMayorDeEdad());
        }

        @Test
        @DisplayName("esMayorDeEdad retorna false para menores de 18")
        void esMayorDeEdadFalse() {
            persona.setEdad(17);
            assertFalse(persona.esMayorDeEdad());
        }

        @Test
        @DisplayName("esMayorDeEdad retorna true para exactamente 18 años")
        void esMayorDeEdadLimite() {
            persona.setEdad(18);
            assertTrue(persona.esMayorDeEdad());
        }
    }

    @Nested
    @DisplayName("Tests de equals y hashCode")
    class EqualsHashCodeTests {

        @Test
        @DisplayName("equals retorna true para misma identificación")
        void equalsConMismaIdentificacion() {
            Persona otraPersona = new Persona("Pedro", "López", 30, "12345678A");
            assertEquals(persona, otraPersona);
        }

        @Test
        @DisplayName("equals retorna false para diferente identificación")
        void equalsConDiferenteIdentificacion() {
            Persona otraPersona = new Persona("Juan", "García", 25, "87654321B");
            assertNotEquals(persona, otraPersona);
        }

        @Test
        @DisplayName("hashCode es consistente con equals")
        void hashCodeConsistente() {
            Persona otraPersona = new Persona("Pedro", "López", 30, "12345678A");
            assertEquals(persona.hashCode(), otraPersona.hashCode());
        }
    }
}
