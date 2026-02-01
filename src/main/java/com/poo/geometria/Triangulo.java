package com.poo.geometria;

/**
 * Clase que representa un triángulo.
 * Demuestra validación de datos y cálculos geométricos.
 * 
 * @author Diego
 * @version 1.0
 */
public class Triangulo extends Figura {
    
    private double ladoA;
    private double ladoB;
    private double ladoC;

    /**
     * Constructor por defecto (triángulo equilátero).
     */
    public Triangulo() {
        super("Triángulo", "Verde");
        this.ladoA = 1.0;
        this.ladoB = 1.0;
        this.ladoC = 1.0;
    }

    /**
     * Constructor con los tres lados.
     * 
     * @param ladoA Primer lado
     * @param ladoB Segundo lado
     * @param ladoC Tercer lado
     * @throws IllegalArgumentException si los lados no forman un triángulo válido
     */
    public Triangulo(double ladoA, double ladoB, double ladoC) {
        super("Triángulo", "Verde");
        if (!esTrianguloValido(ladoA, ladoB, ladoC)) {
            throw new IllegalArgumentException("Los lados proporcionados no forman un triángulo válido");
        }
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    /**
     * Constructor completo.
     * 
     * @param ladoA Primer lado
     * @param ladoB Segundo lado
     * @param ladoC Tercer lado
     * @param color Color del triángulo
     * @throws IllegalArgumentException si los lados no forman un triángulo válido
     */
    public Triangulo(double ladoA, double ladoB, double ladoC, String color) {
        super("Triángulo", color);
        if (!esTrianguloValido(ladoA, ladoB, ladoC)) {
            throw new IllegalArgumentException("Los lados proporcionados no forman un triángulo válido");
        }
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    /**
     * Verifica si los lados forman un triángulo válido.
     * 
     * @param a Primer lado
     * @param b Segundo lado
     * @param c Tercer lado
     * @return true si es un triángulo válido
     */
    public static boolean esTrianguloValido(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }
        return (a + b > c) && (b + c > a) && (a + c > b);
    }

    // Getters

    /**
     * Obtiene el lado A.
     * 
     * @return El lado A
     */
    public double getLadoA() {
        return ladoA;
    }

    /**
     * Obtiene el lado B.
     * 
     * @return El lado B
     */
    public double getLadoB() {
        return ladoB;
    }

    /**
     * Obtiene el lado C.
     * 
     * @return El lado C
     */
    public double getLadoC() {
        return ladoC;
    }

    /**
     * Determina el tipo de triángulo según sus lados.
     * 
     * @return El tipo de triángulo (Equilátero, Isósceles o Escaleno)
     */
    public String obtenerTipo() {
        if (Double.compare(ladoA, ladoB) == 0 && Double.compare(ladoB, ladoC) == 0) {
            return "Equilátero";
        } else if (Double.compare(ladoA, ladoB) == 0 || 
                   Double.compare(ladoB, ladoC) == 0 || 
                   Double.compare(ladoA, ladoC) == 0) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }

    /**
     * Determina si el triángulo es rectángulo.
     * 
     * @return true si es un triángulo rectángulo
     */
    public boolean esRectangulo() {
        double[] lados = {ladoA, ladoB, ladoC};
        java.util.Arrays.sort(lados);
        double hipotenusaCuadrada = lados[2] * lados[2];
        double sumaCatetoscuadrada = lados[0] * lados[0] + lados[1] * lados[1];
        return Math.abs(hipotenusaCuadrada - sumaCatetoscuadrada) < 0.0001;
    }

    @Override
    public double calcularArea() {
        // Fórmula de Herón
        double semiperimetro = calcularPerimetro() / 2;
        return Math.sqrt(semiperimetro * 
                        (semiperimetro - ladoA) * 
                        (semiperimetro - ladoB) * 
                        (semiperimetro - ladoC));
    }

    @Override
    public double calcularPerimetro() {
        return ladoA + ladoB + ladoC;
    }

    @Override
    public String obtenerRepresentacionASCII() {
        StringBuilder sb = new StringBuilder();
        int altura = 5;
        
        for (int i = 0; i < altura; i++) {
            // Espacios iniciales
            for (int j = 0; j < altura - i - 1; j++) {
                sb.append(" ");
            }
            // Contenido de la fila
            if (i == 0) {
                sb.append("*");
            } else if (i == altura - 1) {
                for (int j = 0; j < 2 * altura - 1; j++) {
                    sb.append("*");
                }
            } else {
                sb.append("*");
                for (int j = 0; j < 2 * i - 1; j++) {
                    sb.append(" ");
                }
                sb.append("*");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Triangulo{tipo=" + obtenerTipo() + ", ladoA=" + ladoA + 
               ", ladoB=" + ladoB + ", ladoC=" + ladoC + 
               ", color='" + getColor() + "', área=" + String.format("%.2f", calcularArea()) + "}";
    }
}
