package com.poo.enums;

/**
 * Enumeración que representa los días de la semana.
 * Demuestra el uso de enums con métodos y atributos.
 * 
 * @author Diego
 * @version 1.0
 */
public enum DiaSemana {
    LUNES("Monday", true, 1),
    MARTES("Tuesday", true, 2),
    MIERCOLES("Wednesday", true, 3),
    JUEVES("Thursday", true, 4),
    VIERNES("Friday", true, 5),
    SABADO("Saturday", false, 6),
    DOMINGO("Sunday", false, 7);

    private final String nombreIngles;
    private final boolean esLaboral;
    private final int numeroOrden;

    /**
     * Constructor del enum.
     * 
     * @param nombreIngles Nombre en inglés
     * @param esLaboral Si es día laboral
     * @param numeroOrden Número de orden en la semana
     */
    DiaSemana(String nombreIngles, boolean esLaboral, int numeroOrden) {
        this.nombreIngles = nombreIngles;
        this.esLaboral = esLaboral;
        this.numeroOrden = numeroOrden;
    }

    /**
     * Obtiene el nombre en inglés.
     * 
     * @return Nombre en inglés
     */
    public String getNombreIngles() {
        return nombreIngles;
    }

    /**
     * Verifica si es día laboral.
     * 
     * @return true si es día laboral
     */
    public boolean isEsLaboral() {
        return esLaboral;
    }

    /**
     * Obtiene el número de orden del día.
     * 
     * @return Número de orden (1-7)
     */
    public int getNumeroOrden() {
        return numeroOrden;
    }

    /**
     * Obtiene el siguiente día de la semana.
     * 
     * @return El día siguiente
     */
    public DiaSemana getSiguiente() {
        DiaSemana[] dias = values();
        return dias[(this.ordinal() + 1) % dias.length];
    }

    /**
     * Obtiene el día anterior de la semana.
     * 
     * @return El día anterior
     */
    public DiaSemana getAnterior() {
        DiaSemana[] dias = values();
        return dias[(this.ordinal() - 1 + dias.length) % dias.length];
    }

    /**
     * Calcula los días hasta otro día.
     * 
     * @param otroDia Día destino
     * @return Número de días hasta el día destino
     */
    public int diasHasta(DiaSemana otroDia) {
        int diferencia = otroDia.numeroOrden - this.numeroOrden;
        return diferencia >= 0 ? diferencia : diferencia + 7;
    }

    /**
     * Verifica si es fin de semana.
     * 
     * @return true si es sábado o domingo
     */
    public boolean esFinDeSemana() {
        return this == SABADO || this == DOMINGO;
    }

    /**
     * Obtiene un día por su número de orden.
     * 
     * @param numero Número de orden (1-7)
     * @return El día correspondiente o null si no existe
     */
    public static DiaSemana obtenerPorNumero(int numero) {
        for (DiaSemana dia : values()) {
            if (dia.numeroOrden == numero) {
                return dia;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
