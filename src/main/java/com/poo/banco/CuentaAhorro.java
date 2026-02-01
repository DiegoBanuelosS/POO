package com.poo.banco;

/**
 * Clase que representa una cuenta de ahorro con intereses.
 * Demuestra herencia y extensión de funcionalidad.
 * 
 * @author Diego
 * @version 1.0
 */
public class CuentaAhorro extends CuentaBancaria {
    
    private double tasaInteres;
    private static final double TASA_INTERES_DEFAULT = 0.05;

    /**
     * Constructor con titular.
     * 
     * @param titular Nombre del titular
     */
    public CuentaAhorro(String titular) {
        super(titular);
        this.tasaInteres = TASA_INTERES_DEFAULT;
    }

    /**
     * Constructor con titular y saldo inicial.
     * 
     * @param titular Nombre del titular
     * @param saldoInicial Saldo inicial
     */
    public CuentaAhorro(String titular, double saldoInicial) {
        super(titular, saldoInicial);
        this.tasaInteres = TASA_INTERES_DEFAULT;
    }

    /**
     * Constructor completo.
     * 
     * @param titular Nombre del titular
     * @param saldoInicial Saldo inicial
     * @param tasaInteres Tasa de interés anual
     */
    public CuentaAhorro(String titular, double saldoInicial, double tasaInteres) {
        super(titular, saldoInicial);
        setTasaInteres(tasaInteres);
    }

    /**
     * Obtiene la tasa de interés.
     * 
     * @return La tasa de interés
     */
    public double getTasaInteres() {
        return tasaInteres;
    }

    /**
     * Establece la tasa de interés con validación.
     * 
     * @param tasaInteres Nueva tasa de interés (entre 0 y 1)
     */
    public void setTasaInteres(double tasaInteres) {
        if (tasaInteres >= 0 && tasaInteres <= 1) {
            this.tasaInteres = tasaInteres;
        }
    }

    /**
     * Calcula los intereses generados.
     * 
     * @return El monto de intereses
     */
    public double calcularIntereses() {
        return getSaldo() * tasaInteres;
    }

    /**
     * Aplica los intereses al saldo de la cuenta.
     * 
     * @return El monto de intereses aplicados
     */
    public double aplicarIntereses() {
        double intereses = calcularIntereses();
        if (intereses > 0) {
            depositar(intereses);
        }
        return intereses;
    }

    /**
     * Proyecta el saldo futuro con interés compuesto.
     * 
     * @param anos Número de años a proyectar
     * @return El saldo proyectado
     */
    public double proyectarSaldo(int anos) {
        if (anos < 0) {
            return getSaldo();
        }
        return getSaldo() * Math.pow(1 + tasaInteres, anos);
    }

    @Override
    public String toString() {
        return "CuentaAhorro{" +
                "numeroCuenta='" + getNumeroCuenta() + '\'' +
                ", titular='" + getTitular() + '\'' +
                ", saldo=$" + String.format("%.2f", getSaldo()) +
                ", tasaInteres=" + String.format("%.2f%%", tasaInteres * 100) +
                ", activa=" + isActiva() +
                '}';
    }
}
