package com.poo.banco;

import com.poo.excepciones.SaldoInsuficienteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase que representa una cuenta bancaria.
 * Demuestra encapsulamiento, excepciones y manejo de historial.
 * 
 * @author Diego
 * @version 1.0
 */
public class CuentaBancaria {
    
    private static int contadorCuentas = 1000;
    
    private final String numeroCuenta;
    private String titular;
    private double saldo;
    private final List<String> historialTransacciones;
    private boolean activa;

    /**
     * Constructor con titular.
     * 
     * @param titular Nombre del titular de la cuenta
     */
    public CuentaBancaria(String titular) {
        this.numeroCuenta = generarNumeroCuenta();
        this.titular = titular;
        this.saldo = 0.0;
        this.historialTransacciones = new ArrayList<>();
        this.activa = true;
        registrarTransaccion("Cuenta creada");
    }

    /**
     * Constructor con titular y saldo inicial.
     * 
     * @param titular Nombre del titular de la cuenta
     * @param saldoInicial Saldo inicial de la cuenta
     */
    public CuentaBancaria(String titular, double saldoInicial) {
        this.numeroCuenta = generarNumeroCuenta();
        this.titular = titular;
        this.saldo = saldoInicial > 0 ? saldoInicial : 0.0;
        this.historialTransacciones = new ArrayList<>();
        this.activa = true;
        registrarTransaccion("Cuenta creada con saldo inicial: $" + String.format("%.2f", this.saldo));
    }

    /**
     * Genera un número de cuenta único.
     * 
     * @return El número de cuenta generado
     */
    private static synchronized String generarNumeroCuenta() {
        contadorCuentas++;
        return "CTA-" + contadorCuentas;
    }

    /**
     * Registra una transacción en el historial.
     * 
     * @param descripcion Descripción de la transacción
     */
    private void registrarTransaccion(String descripcion) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora = LocalDateTime.now().format(formatter);
        historialTransacciones.add("[" + fechaHora + "] " + descripcion + " | Saldo: $" + String.format("%.2f", saldo));
    }

    /**
     * Deposita dinero en la cuenta.
     * 
     * @param monto Monto a depositar
     * @return true si el depósito fue exitoso
     */
    public boolean depositar(double monto) {
        if (!activa) {
            System.out.println("Error: La cuenta no está activa.");
            return false;
        }
        if (monto <= 0) {
            System.out.println("Error: El monto debe ser positivo.");
            return false;
        }
        saldo += monto;
        registrarTransaccion("Depósito: $" + String.format("%.2f", monto));
        return true;
    }

    /**
     * Retira dinero de la cuenta.
     * 
     * @param monto Monto a retirar
     * @throws SaldoInsuficienteException si el saldo es insuficiente
     */
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (!activa) {
            throw new IllegalStateException("La cuenta no está activa.");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo.");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException(saldo, monto);
        }
        saldo -= monto;
        registrarTransaccion("Retiro: $" + String.format("%.2f", monto));
    }

    /**
     * Transfiere dinero a otra cuenta.
     * 
     * @param destino Cuenta de destino
     * @param monto Monto a transferir
     * @throws SaldoInsuficienteException si el saldo es insuficiente
     */
    public void transferir(CuentaBancaria destino, double monto) throws SaldoInsuficienteException {
        if (destino == null) {
            throw new IllegalArgumentException("La cuenta destino no puede ser nula.");
        }
        if (!destino.isActiva()) {
            throw new IllegalStateException("La cuenta destino no está activa.");
        }
        
        this.retirar(monto);
        destino.depositar(monto);
        registrarTransaccion("Transferencia enviada a " + destino.getNumeroCuenta() + ": $" + String.format("%.2f", monto));
    }

    // Getters

    /**
     * Obtiene el número de cuenta.
     * 
     * @return El número de cuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Obtiene el nombre del titular.
     * 
     * @return El titular de la cuenta
     */
    public String getTitular() {
        return titular;
    }

    /**
     * Establece el nombre del titular.
     * 
     * @param titular El nuevo titular
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     * Obtiene el saldo actual.
     * 
     * @return El saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Verifica si la cuenta está activa.
     * 
     * @return true si la cuenta está activa
     */
    public boolean isActiva() {
        return activa;
    }

    /**
     * Desactiva la cuenta.
     */
    public void desactivar() {
        this.activa = false;
        registrarTransaccion("Cuenta desactivada");
    }

    /**
     * Activa la cuenta.
     */
    public void activar() {
        this.activa = true;
        registrarTransaccion("Cuenta activada");
    }

    /**
     * Obtiene el historial de transacciones.
     * 
     * @return Lista inmutable del historial
     */
    public List<String> getHistorialTransacciones() {
        return Collections.unmodifiableList(historialTransacciones);
    }

    /**
     * Imprime el historial de transacciones.
     */
    public void imprimirHistorial() {
        System.out.println("\n=== Historial de Transacciones ===");
        System.out.println("Cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.println("-".repeat(50));
        for (String transaccion : historialTransacciones) {
            System.out.println(transaccion);
        }
        System.out.println("-".repeat(50));
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", titular='" + titular + '\'' +
                ", saldo=$" + String.format("%.2f", saldo) +
                ", activa=" + activa +
                '}';
    }
}
