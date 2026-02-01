package com.poo.enums;

/**
 * Enumeración que representa niveles de prioridad.
 * Demuestra enum con métodos de comparación.
 * 
 * @author Diego
 * @version 1.0
 */
public enum Prioridad {
    CRITICA(1, "Crítica", "🔴"),
    ALTA(2, "Alta", "🟠"),
    MEDIA(3, "Media", "🟡"),
    BAJA(4, "Baja", "🟢"),
    MINIMA(5, "Mínima", "⚪");

    private final int nivel;
    private final String descripcion;
    private final String emoji;

    /**
     * Constructor del enum.
     * 
     * @param nivel Nivel numérico (menor = más prioritario)
     * @param descripcion Descripción de la prioridad
     * @param emoji Emoji representativo
     */
    Prioridad(int nivel, String descripcion, String emoji) {
        this.nivel = nivel;
        this.descripcion = descripcion;
        this.emoji = emoji;
    }

    /**
     * Obtiene el nivel numérico.
     * 
     * @return El nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Obtiene la descripción.
     * 
     * @return La descripción
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene el emoji representativo.
     * 
     * @return El emoji
     */
    public String getEmoji() {
        return emoji;
    }

    /**
     * Verifica si esta prioridad es mayor que otra.
     * 
     * @param otra Otra prioridad a comparar
     * @return true si esta prioridad es mayor
     */
    public boolean esMayorQue(Prioridad otra) {
        return this.nivel < otra.nivel;
    }

    /**
     * Verifica si esta prioridad es menor que otra.
     * 
     * @param otra Otra prioridad a comparar
     * @return true si esta prioridad es menor
     */
    public boolean esMenorQue(Prioridad otra) {
        return this.nivel > otra.nivel;
    }

    /**
     * Verifica si es prioridad urgente (Crítica o Alta).
     * 
     * @return true si es urgente
     */
    public boolean esUrgente() {
        return this == CRITICA || this == ALTA;
    }

    /**
     * Obtiene una prioridad por su nivel numérico.
     * 
     * @param nivel Nivel numérico
     * @return La prioridad correspondiente o MEDIA si no existe
     */
    public static Prioridad obtenerPorNivel(int nivel) {
        for (Prioridad p : values()) {
            if (p.nivel == nivel) {
                return p;
            }
        }
        return MEDIA;
    }

    @Override
    public String toString() {
        return emoji + " " + descripcion;
    }
}
