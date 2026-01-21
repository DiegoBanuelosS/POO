/**
 * Clase de prueba para verificar que todas las operaciones funcionan
 * @author Diego
 * @version 1.0
 */
public class PruebaCalculadora {
    
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        
        System.out.println("=== PRUEBAS DE LA CALCULADORA ===\n");
        
        // Prueba Suma
        System.out.println("SUMA:");
        double suma = calc.sumar(5, 3);
        System.out.println("5 + 3 = " + suma);
        
        // Prueba Resta
        System.out.println("\nRESTA:");
        double resta = calc.restar(10, 4);
        System.out.println("10 - 4 = " + resta);
        
        // Prueba Multiplicacion (usando sumas)
        System.out.println("\nMULTIPLICACION (con sumas):");
        double mult = calc.multiplicar(4, 3);
        System.out.println("4 * 3 = " + mult);
        
        // Prueba Division (usando restas)
        System.out.println("\nDIVISION (con restas):");
        double div = calc.dividir(15, 3);
        System.out.println("15 / 3 = " + div);
        
        // Prueba Modulo (usando restas)
        System.out.println("\nMODULO (con restas):");
        double mod = calc.modulo(10, 3);
        System.out.println("10 % 3 = " + mod);
        
        // Prueba Potencia (usando sumas)
        System.out.println("\nPOTENCIA (con sumas):");
        double pot = calc.potencia(2, 3);
        System.out.println("2 ^ 3 = " + pot);
        
        // Prueba Raiz Cuadrada (con aproximacion)
        System.out.println("\nRAIZ CUADRADA (aproximacion):");
        double raiz = calc.raizCuadrada(16);
        System.out.println("sqrt(16) = " + raiz);
        
        // Prueba Logaritmo (aproximacion)
        System.out.println("\nLOGARITMO (aproximacion):");
        double log = calc.logaritmo(10);
        System.out.println("ln(10) = " + log + " (aproximado)");
        
        // Mostrar historial
        calc.mostrarHistorial();
        
        // Mostrar estadisticas
        calc.mostrarEstadisticas();
    }
}
