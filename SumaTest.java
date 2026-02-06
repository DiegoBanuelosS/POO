public class SumaTest {
    
    public void testSumaPositivos() {
        Suma suma = new Suma();
        Assert.assertEquals(5.0, suma.ejecutar(2, 3), "2 + 3 debe ser 5");
    }
    
    public void testSumaCero() {
        Suma suma = new Suma();
        Assert.assertEquals(5.0, suma.ejecutar(5, 0), "5 + 0 debe ser 5");
        Assert.assertEquals(5.0, suma.ejecutar(0, 5), "0 + 5 debe ser 5");
    }
    
    public void testSumaNegativos() {
        Suma suma = new Suma();
        Assert.assertEquals(-5.0, suma.ejecutar(-2, -3), "-2 + -3 debe ser -5");
    }
    
    public void testSumaMixta() {
        Suma suma = new Suma();
        Assert.assertEquals(2.0, suma.ejecutar(5, -3), "5 + -3 debe ser 2");
        Assert.assertEquals(-2.0, suma.ejecutar(-5, 3), "-5 + 3 debe ser -2");
    }
    
    public void testSumaDecimales() {
        Suma suma = new Suma();
        Assert.assertEquals(7.5, suma.ejecutar(3.2, 4.3), "3.2 + 4.3 debe ser 7.5");
    }
    
    public void testNombreOperacion() {
        Suma suma = new Suma();
        Assert.assertEquals("Suma", suma.getNombre(), "El nombre debe ser 'Suma'");
    }
}
