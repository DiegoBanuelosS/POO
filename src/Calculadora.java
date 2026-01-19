import java.util.*;

/**
 * Calculadora basica con operaciones matematicas.
 * Usa Listas, Sets y Mapas para guardar el historial.
 * @author Diego
 * @version 1.0
 */
public class Calculadora {
    
    // Lista: guarda todas las operaciones en orden
    private List<String> historial;
    
    // Set: guarda los tipos de operaciones sin repetir
    private Set<String> operacionesUnicas;
    
    // Map: cuenta cuantas veces se uso cada operacion
    private Map<String, Integer> contadorOperaciones;
    
    // Clases de operaciones
    private Suma suma;
    private Resta resta;
    private Multiplicacion multiplicacion;
    private Division division;
    private Modulo modulo;
    private Potencia potencia;
    private Logaritmo logaritmo;
    private RaizCuadrada raizCuadrada;
    
    /**
     * Constructor: inicializa las colecciones y las operaciones
     */
    public Calculadora() {
        this.historial = new ArrayList<>();
        this.operacionesUnicas = new HashSet<>();
        this.contadorOperaciones = new HashMap<>();
        
        // Inicializar las operaciones
        this.suma = new Suma();
        this.resta = new Resta();
        this.multiplicacion = new Multiplicacion();
        this.division = new Division();
        this.modulo = new Modulo();
        this.potencia = new Potencia();
        this.logaritmo = new Logaritmo();
        this.raizCuadrada = new RaizCuadrada();
    }
    
    /**
     * Suma dos numeros
     * @param a primer numero
     * @param b segundo numero
     * @return resultado de la suma
     */
    public double sumar(double a, double b) {
        double resultado = suma.calcular(a, b);
        registrarOperacion("Suma", a + " + " + b + " = " + resultado);
        return resultado;
    }
    
    /**
     * Resta dos numeros
     * @param a primer numero
     * @param b segundo numero
     * @return resultado de la resta
     */
    public double restar(double a, double b) {
        double resultado = resta.calcular(a, b);
        registrarOperacion("Resta", a + " - " + b + " = " + resultado);
        return resultado;
    }
    
    /**
     * Multiplica dos numeros
     * @param a primer numero
     * @param b segundo numero
     * @return resultado de la multiplicacion
     */
    public double multiplicar(double a, double b) {
        double resultado = multiplicacion.calcular(a, b);
        registrarOperacion("Multiplicacion", a + " * " + b + " = " + resultado);
        return resultado;
    }
    
    /**
     * Divide dos numeros
     * @param a dividendo
     * @param b divisor
     * @return resultado de la division
     */
    public double dividir(double a, double b) {
        double resultado = division.calcular(a, b);
        registrarOperacion("Division", a + " / " + b + " = " + resultado);
        return resultado;
    }
    
    /**
     * Calcula el modulo (resto de la division)
     * @param a dividendo
     * @param b divisor
     * @return resto de la division
     */
    public double modulo(double a, double b) {
        double resultado = modulo.calcular(a, b);
        registrarOperacion("Modulo", a + " % " + b + " = " + resultado);
        return resultado;
    }
    
    /**
     * Calcula la potencia
     * @param base numero base
     * @param exponente numero exponente
     * @return resultado de base elevado a exponente
     */
    public double potencia(double base, double exponente) {
        double resultado = potencia.calcular(base, exponente);
        registrarOperacion("Potencia", base + " ^ " + exponente + " = " + resultado);
        return resultado;
    }
    
    /**
     * Calcula el logaritmo natural
     * @param numero numero para calcular el logaritmo
     * @return logaritmo natural del numero
     */
    public double logaritmo(double numero) {
        double resultado = logaritmo.calcular(numero);
        registrarOperacion("Logaritmo", "ln(" + numero + ") = " + resultado);
        return resultado;
    }
    
    /**
     * Calcula la raiz cuadrada
     * @param numero numero para calcular la raiz
     * @return raiz cuadrada del numero
     */
    public double raizCuadrada(double numero) {
        double resultado = raizCuadrada.calcular(numero);
        registrarOperacion("Raiz", "sqrt(" + numero + ") = " + resultado);
        return resultado;
    }
    
    /**
     * Guarda la operacion en las colecciones (Lista, Set y Map)
     * @param tipo nombre del tipo de operacion
     * @param descripcion descripcion de la operacion realizada
     */
    private void registrarOperacion(String tipo, String descripcion) {
        // Agregar a la lista
        historial.add(descripcion);
        
        // Agregar al set (no permite duplicados)
        operacionesUnicas.add(tipo);
        
        // Actualizar contador en el map
        if (contadorOperaciones.containsKey(tipo)) {
            int contador = contadorOperaciones.get(tipo);
            contadorOperaciones.put(tipo, contador + 1);
        } else {
            contadorOperaciones.put(tipo, 1);
        }
    }
    
    /**
     * Muestra todas las operaciones guardadas (uso de Lista)
     */
    public void mostrarHistorial() {
        System.out.println("\n HISTORIAL ");
        if (historial.isEmpty()) {
            System.out.println("No hay operaciones");
        } else {
            for (int i = 0; i < historial.size(); i++) {
                System.out.println((i + 1) + ". " + historial.get(i));
            }
        }
    }
    
    /**
     * Muestra estadisticas (uso de Set y Map)
     */
    public void mostrarEstadisticas() {
        System.out.println("\n--- ESTADISTICAS ---");
        System.out.println("Total de operaciones: " + historial.size());
        System.out.println("Tipos diferentes: " + operacionesUnicas.size());
        
        System.out.println("\nConteo por tipo:");
        for (String tipo : contadorOperaciones.keySet()) {
            int cantidad = contadorOperaciones.get(tipo);
            System.out.println("  " + tipo + ": " + cantidad);
        }
    }
}
