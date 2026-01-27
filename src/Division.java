/**
 * Clase que realiza la operacion de division usando solo restas
 * @author Diego
 * @version 1.0
 */
public class Division {
    private Resta resta;
    private Suma suma;
    
    public Division() {
        this.resta = new Resta();
        this.suma = new Suma();
    }
    
    /**
     * Divide dos numeros usando solo restas
     * @param a dividendo
     * @param b divisor
     * @return resultado de la division o 0 si el divisor es 0
     */
    public double calcular(double a, double b) {
        if (b == 0) {
            System.out.println("Error: no se puede dividir entre cero");
            return 0;
        }
        
        double resultado = 0;
        double resto = a;
        boolean negativo = false;
        
        // Manejar negativos
        if (a < 0 && b > 0 || a > 0 && b < 0) {
            negativo = true;
        }
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        
        // Restar 'b' de 'a' hasta que no se pueda mas
        while (resto >= b) {
            resto = resta.calcular(resto, b);
            resultado = suma.calcular(resultado, 1);
        }
        
        if (negativo) {
            resultado = -resultado;
        }
        
        return resultado;
    }
}
