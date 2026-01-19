/**
 * Clase que realiza la operacion de logaritmo natural usando aproximaciones
 * @author Diego
 * @version 1.0
 */
public class Logaritmo {
    
    /**
     * Calcula el logaritmo natural usando aproximacion simple
     * Nota: Esta es una aproximacion basica, no es precisa
     * @param numero numero para calcular el logaritmo
     * @return logaritmo natural aproximado del numero o 0 si el numero es menor o igual a 0
     */
    public double calcular(double numero) {
        if (numero <= 0) {
            System.out.println("Error: el logaritmo solo acepta numeros positivos");
            return 0;
        }
        
        // Aproximacion simple: contar cuantas veces hay que dividir entre e (2.718...)
        // Para simplicidad, usamos un metodo basico
        double e = 2.718;
        double resultado = 0;
        double valor = numero;
        
        // Si el numero es mayor que e, dividir (restar) repetidamente
        while (valor > e) {
            // Division con restas
            double temp = valor;
            while (temp >= e) {
                temp = temp - e;
            }
            valor = valor - e;
            resultado = resultado + 1;
        }
        
        return resultado;
    }
}
