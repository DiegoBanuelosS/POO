package com.poo.banco;

import com.poo.excepciones.SaldoInsuficienteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para las clases de cuentas bancarias.
 */
@DisplayName("Tests de Cuentas Bancarias")
class CuentaBancariaTest {

    @Nested
    @DisplayName("Tests de CuentaBancaria")
    class CuentaBancariaTests {

        private CuentaBancaria cuenta;

        @BeforeEach
        void setUp() {
            cuenta = new CuentaBancaria("Juan Pérez", 1000);
        }

        @Test
        @DisplayName("Constructor inicializa cuenta correctamente")
        void constructorInicializaCuenta() {
            assertEquals("Juan Pérez", cuenta.getTitular());
            assertEquals(1000, cuenta.getSaldo());
            assertTrue(cuenta.isActiva());
            assertNotNull(cuenta.getNumeroCuenta());
        }

        @Test
        @DisplayName("depositar aumenta el saldo")
        void depositarAumentaSaldo() {
            assertTrue(cuenta.depositar(500));
            assertEquals(1500, cuenta.getSaldo());
        }

        @Test
        @DisplayName("depositar rechaza montos negativos")
        void depositarRechazaNegativos() {
            assertFalse(cuenta.depositar(-100));
            assertEquals(1000, cuenta.getSaldo());
        }

        @Test
        @DisplayName("depositar rechaza monto cero")
        void depositarRechazaCero() {
            assertFalse(cuenta.depositar(0));
            assertEquals(1000, cuenta.getSaldo());
        }

        @Test
        @DisplayName("retirar disminuye el saldo")
        void retirarDisminuyeSaldo() throws SaldoInsuficienteException {
            cuenta.retirar(300);
            assertEquals(700, cuenta.getSaldo());
        }

        @Test
        @DisplayName("retirar lanza excepción por saldo insuficiente")
        void retirarSaldoInsuficiente() {
            SaldoInsuficienteException exception = assertThrows(
                SaldoInsuficienteException.class,
                () -> cuenta.retirar(2000)
            );
            assertEquals(1000, exception.getSaldoActual());
            assertEquals(2000, exception.getMontoSolicitado());
        }

        @Test
        @DisplayName("retirar lanza excepción por monto negativo")
        void retirarMontoNegativo() {
            assertThrows(IllegalArgumentException.class,
                () -> cuenta.retirar(-100));
        }

        @Test
        @DisplayName("transferir mueve dinero entre cuentas")
        void transferirMoveDinero() throws SaldoInsuficienteException {
            CuentaBancaria destino = new CuentaBancaria("María García", 500);
            cuenta.transferir(destino, 300);
            
            assertEquals(700, cuenta.getSaldo());
            assertEquals(800, destino.getSaldo());
        }

        @Test
        @DisplayName("transferir falla con saldo insuficiente")
        void transferirSaldoInsuficiente() {
            CuentaBancaria destino = new CuentaBancaria("María García", 500);
            assertThrows(SaldoInsuficienteException.class,
                () -> cuenta.transferir(destino, 2000));
        }

        @Test
        @DisplayName("cuenta desactivada no permite depósitos")
        void cuentaDesactivadaNoDeposita() {
            cuenta.desactivar();
            assertFalse(cuenta.depositar(100));
        }

        @Test
        @DisplayName("cuenta desactivada no permite retiros")
        void cuentaDesactivadaNoRetira() {
            cuenta.desactivar();
            assertThrows(IllegalStateException.class,
                () -> cuenta.retirar(100));
        }

        @Test
        @DisplayName("historial registra transacciones")
        void historialRegistraTransacciones() throws SaldoInsuficienteException {
            cuenta.depositar(500);
            cuenta.retirar(200);
            
            assertTrue(cuenta.getHistorialTransacciones().size() >= 3);
        }
    }

    @Nested
    @DisplayName("Tests de CuentaAhorro")
    class CuentaAhorroTests {

        private CuentaAhorro cuentaAhorro;

        @BeforeEach
        void setUp() {
            cuentaAhorro = new CuentaAhorro("Ana Martínez", 10000, 0.10);
        }

        @Test
        @DisplayName("Constructor inicializa tasa de interés")
        void constructorInicializaTasa() {
            assertEquals(0.10, cuentaAhorro.getTasaInteres());
        }

        @Test
        @DisplayName("calcularIntereses calcula correctamente")
        void calcularIntereses() {
            assertEquals(1000, cuentaAhorro.calcularIntereses(), 0.01);
        }

        @Test
        @DisplayName("aplicarIntereses aumenta el saldo")
        void aplicarIntereses() {
            double intereses = cuentaAhorro.aplicarIntereses();
            assertEquals(1000, intereses, 0.01);
            assertEquals(11000, cuentaAhorro.getSaldo(), 0.01);
        }

        @Test
        @DisplayName("proyectarSaldo calcula interés compuesto")
        void proyectarSaldo() {
            double proyeccion = cuentaAhorro.proyectarSaldo(2);
            double esperado = 10000 * Math.pow(1.10, 2);
            assertEquals(esperado, proyeccion, 0.01);
        }

        @Test
        @DisplayName("setTasaInteres rechaza valores fuera de rango")
        void setTasaInteresRechazaInvalidos() {
            cuentaAhorro.setTasaInteres(-0.1);
            assertEquals(0.10, cuentaAhorro.getTasaInteres());
            
            cuentaAhorro.setTasaInteres(1.5);
            assertEquals(0.10, cuentaAhorro.getTasaInteres());
        }
    }
}
