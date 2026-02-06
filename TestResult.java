import java.util.ArrayList;
import java.util.List;

public class TestResult {
    private String nombreTest;
    private boolean exitoso;
    private String mensajeError;
    private long tiempoEjecucion;
    
    private static List<TestResult> todosLosResultados = new ArrayList<>();
    
    public TestResult(String nombreTest) {
        this.nombreTest = nombreTest;
        this.exitoso = true;
        this.mensajeError = "";
    }
    
    public void marcarFallido(String mensajeError) {
        this.exitoso = false;
        this.mensajeError = mensajeError;
    }
    
    public void setTiempoEjecucion(long tiempo) {
        this.tiempoEjecucion = tiempo;
    }
    
    public boolean isExitoso() {
        return exitoso;
    }
    
    public void registrar() {
        todosLosResultados.add(this);
    }
    
    public void imprimir() {
        String simbolo = exitoso ? "[OK]" : "[X]";
        String estado = exitoso ? "PASS" : "FAIL";
        System.out.println(simbolo + " " + nombreTest + " - " + estado + " (" + tiempoEjecucion + "ms)");
        if (!exitoso) {
            System.out.println("  Error: " + mensajeError);
        }
    }
    
    public static void imprimirResumen() {
        int total = todosLosResultados.size();
        int exitosos = 0;
        int fallidos = 0;
        
        for (TestResult resultado : todosLosResultados) {
            if (resultado.isExitoso()) {
                exitosos++;
            } else {
                fallidos++;
            }
        }
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("RESUMEN DE TESTS");
        System.out.println("=".repeat(50));
        System.out.println("Total: " + total);
        System.out.println("Exitosos: " + exitosos);
        System.out.println("Fallidos: " + fallidos);
        System.out.println("Porcentaje de éxito: " + (total > 0 ? (exitosos * 100.0 / total) : 0) + "%");
        System.out.println("=".repeat(50));
    }
    
    public static void limpiar() {
        todosLosResultados.clear();
    }
}
