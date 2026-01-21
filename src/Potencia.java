/**
 * Clase que realiza la operacion de potencia usando solo sumas
 * @author Diego
 * @version 1.0
 */
public class Potencia {
    private Suma suma;
    
    public Potencia() {
        this.suma = new Suma();
    }
    
    /**
     * Calcula la potencia usando multiplicacion (que usa sumas)
     * @param base numero base
     * @param exponente numero exponente
     * @return resultado de base elevado a exponente
     */
    public double calcular(double base, double exponente) {
        if (exponente == 0) {
            return 1;
        }
        
        double resultado = 1;
        boolean negativo = false;
        
        if (exponente < 0) {
            negativo = true;
            exponente = -exponente;
        }
        
        // Multiplicar 'base' tantas veces como indique 'exponente'
        // La multiplicacion se hace con sumas
        for (int i = 0; i < (int)exponente; i++) {
            double temp = 0;
            // Multiplicar resultado * base usando sumas
            for (int j = 0; j < (int)base; j++) {
                temp = suma.calcular(temp, resultado);
            }
            resultado = temp;
        }
        
        if (negativo) {
            // Para exponente negativo: 1/resultado
            resultado = 1.0 / resultado;
        }
        
        return resultado;
    }
}
