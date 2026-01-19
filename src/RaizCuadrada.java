/**
 * Clase que realiza la operacion de raiz cuadrada usando aproximaciones con sumas y restas
 * @author Diego
 * @version 1.0
 */
public class RaizCuadrada {
    
    /**
     * Calcula la raiz cuadrada usando el metodo de aproximacion con sumas/restas
     * @param numero numero para calcular la raiz
     * @return raiz cuadrada del numero o 0 si el numero es negativo
     */
    public double calcular(double numero) {
        if (numero < 0) {
            System.out.println("Error: no se puede calcular raiz de numeros negativos");
            return 0;
        }
        
        if (numero == 0) {
            return 0;
        }
        
        // Metodo de aproximacion simple
        double aproximacion = numero;
        double precision = 0.0001;
        
        // Ir ajustando la aproximacion con sumas y restas
        while (true) {
            // Calcular aproximacion * aproximacion usando solo sumas
            double cuadrado = 0;
            for (int i = 0; i < (int)aproximacion; i++) {
                cuadrado = cuadrado + aproximacion;
            }
            
            // Ver si estamos cerca del resultado
            double diferencia = cuadrado - numero;
            if (diferencia < 0) diferencia = -diferencia;
            
            if (diferencia < precision) {
                break;
            }
            
            // Ajustar la aproximacion
            if (cuadrado > numero) {
                aproximacion = aproximacion - 0.01;
            } else {
                aproximacion = aproximacion + 0.01;
            }
        }
        
        return aproximacion;
    }
}
