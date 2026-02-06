import java.util.HashMap;
import java.util.Map;

public class Calculadora {
    private Map<String, Operacion> operaciones;
    
    public Calculadora() {
        operaciones = new HashMap<>();
    }
    
    public void registrarOperacion(String clave, Operacion operacion) {
        operaciones.put(clave, operacion);
    }
    
    public double calcular(String tipoOperacion, double a, double b) {
        Operacion operacion = operaciones.get(tipoOperacion);
        if (operacion == null) {
            throw new IllegalArgumentException("Operación no soportada: " + tipoOperacion);
        }
        return operacion.ejecutar(a, b);
    }
    
    public void mostrarOperacionesDisponibles() {
        System.out.println("Operaciones disponibles:");
        for (Map.Entry<String, Operacion> entry : operaciones.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue().getNombre());
        }
    }
}
