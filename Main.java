import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear calculadora
        Calculadora calculadora = new Calculadora();
        calculadora.registrarOperacion("+", new Suma());
        calculadora.registrarOperacion("-", new Resta());
        
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        
        
        while (continuar) {
            try {
                calculadora.mostrarOperacionesDisponibles();
                
                System.out.print("\nIngrese el primer número: ");
                double num1 = scanner.nextDouble();
                
                System.out.print("Ingrese la operación (+, -): ");
                String operacion = scanner.next();
                
                System.out.print("Ingrese el segundo número: ");
                double num2 = scanner.nextDouble();
                
                double resultado = calculadora.calcular(operacion, num1, num2);
                System.out.println("\nResultado: " + num1 + " " + operacion + " " + num2 + " = " + resultado);
                
                System.out.print("\n¿Desea realizar otra operación? (s/n): ");
                String respuesta = scanner.next();
                continuar = respuesta.equalsIgnoreCase("s");
                System.out.println();
                
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: Entrada inválida");
                scanner.nextLine(); // Limpiar buffer
            }
        }
        
        scanner.close();
        System.out.println("¡Hasta luego!");
    }
}
