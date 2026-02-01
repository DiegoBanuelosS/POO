package com.poo.interfaces;

/**
 * Interfaz que define operaciones de cálculo.
 * Demuestra el uso de interfaces para abstracción.
 * 
 * @author Diego
 * @version 1.0
 */
public interface Calculable {
    
    /**
     * Calcula el área del objeto.
     * 
     * @return El área calculada
     */
    double calcularArea();

    /**
     * Calcula el perímetro del objeto.
     * 
     * @return El perímetro calculado
     */
    double calcularPerimetro();
}
