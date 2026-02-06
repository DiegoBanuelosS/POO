public class Assert {
    
    public static void assertEquals(double esperado, double actual, String mensaje) {
        if (Math.abs(esperado - actual) > 0.0001) {
            throw new AssertionError(mensaje + " - Esperado: " + esperado + ", Actual: " + actual);
        }
    }
    
    public static void assertEquals(String esperado, String actual, String mensaje) {
        if (!esperado.equals(actual)) {
            throw new AssertionError(mensaje + " - Esperado: " + esperado + ", Actual: " + actual);
        }
    }
    
    public static void assertTrue(boolean condicion, String mensaje) {
        if (!condicion) {
            throw new AssertionError(mensaje + " - Se esperaba true pero fue false");
        }
    }
    
    public static void assertFalse(boolean condicion, String mensaje) {
        if (condicion) {
            throw new AssertionError(mensaje + " - Se esperaba false pero fue true");
        }
    }
    
    public static void assertThrows(Class<? extends Exception> excepcionEsperada, Ejecutable codigo, String mensaje) {
        try {
            codigo.ejecutar();
            throw new AssertionError(mensaje + " - Se esperaba " + excepcionEsperada.getName() + " pero no se lanzó");
        } catch (Exception e) {
            if (!excepcionEsperada.isInstance(e)) {
                throw new AssertionError(mensaje + " - Se esperaba " + excepcionEsperada.getName() + 
                                       " pero se lanzó " + e.getClass().getName());
            }
        }
    }
}
