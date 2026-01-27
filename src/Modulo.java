/**
 * Clase que realiza la operacion de modulo usando solo restas
 * @author Diego
 * @version 1.0
 */
public class Modulo {
    private Resta resta;
    
    public Modulo() {
        this.resta = new Resta();
    }
    
    /**
     * Calcula el modulo (resto de la division) usando solo restas
     * @param a dividendo
     * @param b divisor
     * @return resto de la division o 0 si el divisor es 0
     */
    public double calcular(double a, double b) {
        if (b == 0) {
            System.out.println("Error: no se puede calcular modulo con cero");
            return 0;
        }
        
        double resto = a;
        
        // Si son negativos, convertir a positivos
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        
        resto = a;
        
        // Restar 'b' de 'a' hasta que el resto sea menor que b
        while (resto >= b) {
            resto = resta.calcular(resto, b);
        }
        
        return resto;
    }
}
