/**
 * Clase que realiza la operacion de multiplicacion usando solo sumas
 * @author Diego
 * @version 1.0
 */
public class Multiplicacion {
    
    /**
     * Multiplica dos numeros usando solo sumas
     * @param a primer numero
     * @param b segundo numero
     * @return resultado de la multiplicacion
     */
    public double calcular(double a, double b) {
        double resultado = 0;
        boolean negativo = false;
        
        // Manejar negativos
        if (b < 0) {
            negativo = true;
            b = -b;
        }
        
        // Sumar 'a' tantas veces como indique 'b'
        for (int i = 0; i < (int)b; i++) {
            resultado = resultado + a;
        }
        
        // Si era negativo, cambiar el signo
        if (negativo) {
            resultado = -resultado;
        }
        
        return resultado;
    }
}
