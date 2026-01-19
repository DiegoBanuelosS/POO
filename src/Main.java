import java.util.Scanner;

/**
 * Clase principal de la calculadora
 * @author Diego
 * @version 1.0
 */
public class Main {
    
    /**
     * Metodo principal que inicia el programa
     * @param args argumentos de linea de comandos
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calc = new Calculadora();
    
        int opcion = 0;
        
        do {
            System.out.println("\nElige una opcion:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Modulo");
            System.out.println("6. Potencia");
            System.out.println("7. Logaritmo");
            System.out.println("8. Raiz cuadrada");
            System.out.println("9. Ver historial");
            System.out.println("10. Ver estadisticas");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            
            opcion = scanner.nextInt();
            
            int op1 = 0;
            int op2 = 0;
            double resultado = 0;
            
            switch (opcion) {
                case 1:
                    System.out.print("Introduce el operando 1: ");
                    op1 = scanner.nextInt();
                    System.out.print("Introduce el operando 2: ");
                    op2 = scanner.nextInt();
                    resultado = calc.sumar(op1, op2);
                    System.out.println("El resultado de la operacion es: " + resultado);
                    break;
                    
                case 2:
                    System.out.print("Introduce el operando 1: ");
                    op1 = scanner.nextInt();
                    System.out.print("Introduce el operando 2: ");
                    op2 = scanner.nextInt();
                    resultado = calc.restar(op1, op2);
                    System.out.println("El resultado de la operacion es: " + resultado);
                    break;
                    
                case 3:
                    System.out.print("Introduce el operando 1: ");
                    op1 = scanner.nextInt();
                    System.out.print("Introduce el operando 2: ");
                    op2 = scanner.nextInt();
                    resultado = calc.multiplicar(op1, op2);
                    System.out.println("El resultado de la operacion es: " + resultado);
                    break;
                    
                case 4:
                    System.out.print("Introduce el operando 1: ");
                    op1 = scanner.nextInt();
                    System.out.print("Introduce el operando 2: ");
                    op2 = scanner.nextInt();
                    resultado = calc.dividir(op1, op2);
                    System.out.println("El resultado de la operacion es: " + resultado);
                    break;
                    
                case 5:
                    System.out.print("Introduce el operando 1: ");
                    op1 = scanner.nextInt();
                    System.out.print("Introduce el operando 2: ");
                    op2 = scanner.nextInt();
                    resultado = calc.modulo(op1, op2);
                    System.out.println("El resultado de la operacion es: " + resultado);
                    break;
                    
                case 6:
                    System.out.print("Introduce la base: ");
                    op1 = scanner.nextInt();
                    System.out.print("Introduce el exponente: ");
                    op2 = scanner.nextInt();
                    resultado = calc.potencia(op1, op2);
                    System.out.println("El resultado de la operacion es: " + resultado);
                    break;
                    
                case 7:
                    System.out.print("Introduce el numero: ");
                    op1 = scanner.nextInt();
                    resultado = calc.logaritmo(op1);
                    System.out.println("El resultado de la operacion es: " + resultado);
                    break;
                    
                case 8:
                    System.out.print("Introduce el numero: ");
                    op1 = scanner.nextInt();
                    resultado = calc.raizCuadrada(op1);
                    System.out.println("El resultado de la operacion es: " + resultado);
                    break;
                    
                case 9:
                    calc.mostrarHistorial();
                    break;
                    
                case 10:
                    calc.mostrarEstadisticas();
                    break;
                    
                case 0:
                    System.out.println("Adios");
                    break;
                    
                default:
                    System.out.println("Esa opcion no existe, elige una opcion valida");
            }
            
        } while (opcion != 0);
        
        scanner.close();
    }
}
