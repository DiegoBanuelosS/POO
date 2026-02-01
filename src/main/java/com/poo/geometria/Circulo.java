package com.poo.geometria;

/**
 * Clase que representa un círculo.
 * Demuestra herencia de clase abstracta e implementación de métodos abstractos.
 * 
 * @author Diego
 * @version 1.0
 */
public class Circulo extends Figura {
    
    private double radio;

    /**
     * Constructor por defecto.
     */
    public Circulo() {
        super("Círculo", "Rojo");
        this.radio = 1.0;
    }

    /**
     * Constructor con radio.
     * 
     * @param radio Radio del círculo
     */
    public Circulo(double radio) {
        super("Círculo", "Rojo");
        setRadio(radio);
    }

    /**
     * Constructor con radio y color.
     * 
     * @param radio Radio del círculo
     * @param color Color del círculo
     */
    public Circulo(double radio, String color) {
        super("Círculo", color);
        setRadio(radio);
    }

    /**
     * Obtiene el radio del círculo.
     * 
     * @return El radio
     */
    public double getRadio() {
        return radio;
    }

    /**
     * Establece el radio del círculo con validación.
     * 
     * @param radio El nuevo radio (debe ser positivo)
     */
    public void setRadio(double radio) {
        if (radio > 0) {
            this.radio = radio;
        }
    }

    /**
     * Obtiene el diámetro del círculo.
     * 
     * @return El diámetro
     */
    public double getDiametro() {
        return radio * 2;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public String obtenerRepresentacionASCII() {
        StringBuilder sb = new StringBuilder();
        int size = (int) Math.min(radio * 2, 10);
        
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                double distancia = Math.sqrt(Math.pow(i - size / 2.0, 2) + 
                                            Math.pow(j - size / 2.0, 2));
                if (Math.abs(distancia - size / 2.0) < 0.5) {
                    sb.append("* ");
                } else {
                    sb.append("  ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Circulo{radio=" + radio + ", color='" + getColor() + 
               "', área=" + String.format("%.2f", calcularArea()) + "}";
    }
}
