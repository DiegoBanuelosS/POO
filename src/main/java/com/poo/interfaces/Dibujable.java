package com.poo.interfaces;

/**
 * Interfaz que define operaciones de dibujo.
 * Demuestra el uso de interfaces múltiples.
 * 
 * @author Diego
 * @version 1.0
 */
public interface Dibujable {
    
    /**
     * Dibuja el objeto en consola.
     */
    void dibujar();

    /**
     * Obtiene una representación ASCII del objeto.
     * 
     * @return Representación en texto del objeto
     */
    String obtenerRepresentacionASCII();
}
