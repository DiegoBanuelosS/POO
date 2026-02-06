public class MultiplicacionTest {
    
    public void testMultiplicacionPositivos() {
        Multiplicacion mult = new Multiplicacion();
        Assert.assertEquals(15.0, mult.ejecutar(5, 3), "5 * 3 debe ser 15");
    }
    
    public void testMultiplicacionPorCero() {
        Multiplicacion mult = new Multiplicacion();
        Assert.assertEquals(0.0, mult.ejecutar(5, 0), "5 * 0 debe ser 0");
        Assert.assertEquals(0.0, mult.ejecutar(0, 5), "0 * 5 debe ser 0");
    }
    
    public void testMultiplicacionPorUno() {
        Multiplicacion mult = new Multiplicacion();
        Assert.assertEquals(5.0, mult.ejecutar(5, 1), "5 * 1 debe ser 5");
        Assert.assertEquals(5.0, mult.ejecutar(1, 5), "1 * 5 debe ser 5");
    }
    
    public void testMultiplicacionNegativos() {
        Multiplicacion mult = new Multiplicacion();
        Assert.assertEquals(15.0, mult.ejecutar(-5, -3), "-5 * -3 debe ser 15");
    }
    
    public void testMultiplicacionMixta() {
        Multiplicacion mult = new Multiplicacion();
        Assert.assertEquals(-15.0, mult.ejecutar(5, -3), "5 * -3 debe ser -15");
        Assert.assertEquals(-15.0, mult.ejecutar(-5, 3), "-5 * 3 debe ser -15");
    }
    
    public void testMultiplicacionNumerosGrandes() {
        Multiplicacion mult = new Multiplicacion();
        Assert.assertEquals(100.0, mult.ejecutar(10, 10), "10 * 10 debe ser 100");
    }
    
    public void testNombreOperacion() {
        Multiplicacion mult = new Multiplicacion();
        Assert.assertEquals("Multiplicación", mult.getNombre(), "El nombre debe ser 'Multiplicación'");
    }
}
