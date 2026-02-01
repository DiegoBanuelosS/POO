package com.poo.excepciones;

/**
 * Excepción personalizada para saldo insuficiente en cuenta bancaria.
 * Demuestra creación de excepciones personalizadas.
 * 
 * @author Diego
 * @version 1.0
 */
public class SaldoInsuficienteException extends Exception {
    
    private final double saldoActual;
    private final double montoSolicitado;

    /**
     * Constructor con mensaje.
     * 
     * @param mensaje Mensaje de error
     */
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
        this.saldoActual = 0;
        this.montoSolicitado = 0;
    }

    /**
     * Constructor con detalles de la transacción.
     * 
     * @param saldoActual Saldo actual de la cuenta
     * @param montoSolicitado Monto que se intentó retirar
     */
    public SaldoInsuficienteException(double saldoActual, double montoSolicitado) {
        super(String.format("Saldo insuficiente. Saldo actual: $%.2f, Monto solicitado: $%.2f", 
                            saldoActual, montoSolicitado));
        this.saldoActual = saldoActual;
        this.montoSolicitado = montoSolicitado;
    }

    /**
     * Obtiene el saldo actual al momento de la excepción.
     * 
     * @return El saldo actual
     */
    public double getSaldoActual() {
        return saldoActual;
    }

    /**
     * Obtiene el monto que se intentó retirar.
     * 
     * @return El monto solicitado
     */
    public double getMontoSolicitado() {
        return montoSolicitado;
    }

    /**
     * Calcula el déficit (monto faltante).
     * 
     * @return La diferencia entre lo solicitado y lo disponible
     */
    public double calcularDeficit() {
        return montoSolicitado - saldoActual;
    }
}
