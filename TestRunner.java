import java.lang.reflect.Method;

public class TestRunner {
    
    public static void ejecutar(Class<?> claseTest) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Ejecutando tests de: " + claseTest.getSimpleName());
        System.out.println("=".repeat(50) + "\n");
        
        try {
            Object instancia = claseTest.getDeclaredConstructor().newInstance();
            Method[] metodos = claseTest.getDeclaredMethods();
            
            for (Method metodo : metodos) {
                if (metodo.getName().startsWith("test")) {
                    ejecutarTest(instancia, metodo);
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error al ejecutar clase de test: " + e.getMessage());
        }
    }
    
    private static void ejecutarTest(Object instancia, Method metodo) {
        TestResult resultado = new TestResult(metodo.getName());
        long inicio = System.currentTimeMillis();
        
        try {
            metodo.invoke(instancia);
        } catch (Exception e) {
            Throwable causa = e.getCause() != null ? e.getCause() : e;
            resultado.marcarFallido(causa.getMessage());
        }
        
        long fin = System.currentTimeMillis();
        resultado.setTiempoEjecucion(fin - inicio);
        resultado.registrar();
        resultado.imprimir();
    }
    
    public static void ejecutarTodos(Class<?>... clasesTest) {
        TestResult.limpiar();
        
        for (Class<?> claseTest : clasesTest) {
            ejecutar(claseTest);
        }
        
        TestResult.imprimirResumen();
    }
}
