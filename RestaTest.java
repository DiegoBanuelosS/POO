public class RestaTest {
    
    public void testRestaPositivos() {
        Resta resta = new Resta();
        Assert.assertEquals(2.0, resta.ejecutar(5, 3), "5 - 3 debe ser 2");
    }
    
    public void testRestaCero() {
        Resta resta = new Resta();
        Assert.assertEquals(5.0, resta.ejecutar(5, 0), "5 - 0 debe ser 5");
        Assert.assertEquals(-5.0, resta.ejecutar(0, 5), "0 - 5 debe ser -5");
    }
    
    public void testRestaNegativos() {
        Resta resta = new Resta();
        Assert.assertEquals(-2.0, resta.ejecutar(-5, -3), "-5 - -3 debe ser -2");
        Assert.assertEquals(2.0, resta.ejecutar(-3, -5), "-3 - -5 debe ser 2");
    }
    
    public void testRestaMixta() {
        Resta resta = new Resta();
        Assert.assertEquals(8.0, resta.ejecutar(5, -3), "5 - -3 debe ser 8");
        Assert.assertEquals(-8.0, resta.ejecutar(-5, 3), "-5 - 3 debe ser -8");
    }
    
    public void testRestaDecimales() {
        Resta resta = new Resta();
        Assert.assertEquals(1.5, resta.ejecutar(5.5, 4.0), "5.5 - 4.0 debe ser 1.5");
    }
    
    public void testRestaResultadoNegativo() {
        Resta resta = new Resta();
        Assert.assertEquals(-2.0, resta.ejecutar(3, 5), "3 - 5 debe ser -2");
    }
    
    public void testNombreOperacion() {
        Resta resta = new Resta();
        Assert.assertEquals("Resta", resta.getNombre(), "El nombre debe ser 'Resta'");
    }
}
