public class DivisionTest {
    
    public void testDivisionPositivos() {
        Division div = new Division();
        Assert.assertEquals(2.0, div.ejecutar(6, 3), "6 / 3 debe ser 2");
    }
    
    public void testDivisionEntera() {
        Division div = new Division();
        Assert.assertEquals(3.0, div.ejecutar(10, 3), "10 / 3 debe ser 3 (división entera)");
    }
    
    public void testDivisionPorUno() {
        Division div = new Division();
        Assert.assertEquals(5.0, div.ejecutar(5, 1), "5 / 1 debe ser 5");
    }
    
    public void testDivisionNegativos() {
        Division div = new Division();
        Assert.assertEquals(2.0, div.ejecutar(-6, -3), "-6 / -3 debe ser 2");
    }
    
    public void testDivisionMixta() {
        Division div = new Division();
        Assert.assertEquals(-2.0, div.ejecutar(6, -3), "6 / -3 debe ser -2");
        Assert.assertEquals(-2.0, div.ejecutar(-6, 3), "-6 / 3 debe ser -2");
    }
    
    public void testDivisionPorCero() {
        Division div = new Division();
        Assert.assertThrows(ArithmeticException.class, () -> {
            div.ejecutar(5, 0);
        }, "División por cero debe lanzar ArithmeticException");
    }
    
    public void testDivisionCeroPorNumero() {
        Division div = new Division();
        Assert.assertEquals(0.0, div.ejecutar(0, 5), "0 / 5 debe ser 0");
    }
    
    public void testNombreOperacion() {
        Division div = new Division();
        Assert.assertEquals("División", div.getNombre(), "El nombre debe ser 'División'");
    }
}
