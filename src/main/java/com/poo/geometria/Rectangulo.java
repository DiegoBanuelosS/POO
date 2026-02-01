package com.poo.geometria;

/**
 * Clase que representa un rectángulo.
 * Demuestra herencia y sobrescritura de métodos.
 * 
 * @author Diego
 * @version 1.0
 */
public class Rectangulo extends Figura {
    
    private double base;
    private double altura;

    /**
     * Constructor por defecto.
     */
    public Rectangulo() {
        super("Rectángulo", "Azul");
        this.base = 1.0;
        this.altura = 1.0;
    }

    /**
     * Constructor con base y altura.
     * 
     * @param base Base del rectángulo
     * @param altura Altura del rectángulo
     */
    public Rectangulo(double base, double altura) {
        super("Rectángulo", "Azul");
        setBase(base);
        setAltura(altura);
    }

    /**
     * Constructor completo.
     * 
     * @param base Base del rectángulo
     * @param altura Altura del rectángulo
     * @param color Color del rectángulo
     */
    public Rectangulo(double base, double altura, String color) {
        super("Rectángulo", color);
        setBase(base);
        setAltura(altura);
    }

    /**
     * Obtiene la base del rectángulo.
     * 
     * @return La base
     */
    public double getBase() {
        return base;
    }

    /**
     * Establece la base del rectángulo con validación.
     * 
     * @param base La nueva base (debe ser positiva)
     */
    public void setBase(double base) {
        if (base > 0) {
            this.base = base;
        }
    }

    /**
     * Obtiene la altura del rectángulo.
     * 
     * @return La altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Establece la altura del rectángulo con validación.
     * 
     * @param altura La nueva altura (debe ser positiva)
     */
    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        }
    }

    /**
     * Verifica si el rectángulo es un cuadrado.
     * 
     * @return true si base y altura son iguales
     */
    public boolean esCuadrado() {
        return Double.compare(base, altura) == 0;
    }

    /**
     * Calcula la diagonal del rectángulo.
     * 
     * @return La longitud de la diagonal
     */
    public double calcularDiagonal() {
        return Math.sqrt(base * base + altura * altura);
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    @Override
    public String obtenerRepresentacionASCII() {
        StringBuilder sb = new StringBuilder();
        int anchoASCII = (int) Math.min(base * 2, 20);
        int altoASCII = (int) Math.min(altura, 10);

        // Línea superior
        sb.append("+");
        for (int i = 0; i < anchoASCII; i++) {
            sb.append("-");
        }
        sb.append("+\n");

        // Líneas intermedias
        for (int i = 0; i < altoASCII; i++) {
            sb.append("|");
            for (int j = 0; j < anchoASCII; j++) {
                sb.append(" ");
            }
            sb.append("|\n");
        }

        // Línea inferior
        sb.append("+");
        for (int i = 0; i < anchoASCII; i++) {
            sb.append("-");
        }
        sb.append("+\n");

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Rectangulo{base=" + base + ", altura=" + altura + 
               ", color='" + getColor() + "', área=" + String.format("%.2f", calcularArea()) + "}";
    }
}
