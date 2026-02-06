public class CalculadoraTest {
    
    public void testRegistrarYCalcularSuma() {
        Calculadora calc = new Calculadora();
        calc.registrarOperacion("+", new Suma());
        Assert.assertEquals(8.0, calc.calcular("+", 5, 3), "5 + 3 debe ser 8");
    }
    
    public void testRegistrarYCalcularResta() {
        Calculadora calc = new Calculadora();
        calc.registrarOperacion("-", new Resta());
        Assert.assertEquals(2.0, calc.calcular("-", 5, 3), "5 - 3 debe ser 2");
    }
    
    public void testRegistrarMultiplesOperaciones() {
        Calculadora calc = new Calculadora();
        calc.registrarOperacion("+", new Suma());
        calc.registrarOperacion("-", new Resta());
        calc.registrarOperacion("*", new Multiplicacion());
        calc.registrarOperacion("/", new Division());
        
        Assert.assertEquals(8.0, calc.calcular("+", 5, 3), "5 + 3 debe ser 8");
        Assert.assertEquals(2.0, calc.calcular("-", 5, 3), "5 - 3 debe ser 2");
        Assert.assertEquals(15.0, calc.calcular("*", 5, 3), "5 * 3 debe ser 15");
        Assert.assertEquals(2.0, calc.calcular("/", 6, 3), "6 / 3 debe ser 2");
    }
    
    public void testOperacionNoRegistrada() {
        Calculadora calc = new Calculadora();
        calc.registrarOperacion("+", new Suma());
        
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            calc.calcular("-", 5, 3);
        }, "Operación no registrada debe lanzar IllegalArgumentException");
    }
    
    public void testOperacionNula() {
        Calculadora calc = new Calculadora();
        
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            calc.calcular("+", 5, 3);
        }, "Operación inexistente debe lanzar IllegalArgumentException");
    }
    
    public void testSobreescribirOperacion() {
        Calculadora calc = new Calculadora();
        calc.registrarOperacion("+", new Suma());
        calc.registrarOperacion("+", new Resta());
        
        Assert.assertEquals(2.0, calc.calcular("+", 5, 3), "La operación sobrescrita debe ser Resta");
    }
    
    public void testCalculosConNegativos() {
        Calculadora calc = new Calculadora();
        calc.registrarOperacion("+", new Suma());
        calc.registrarOperacion("-", new Resta());
        
        Assert.assertEquals(-8.0, calc.calcular("+", -5, -3), "-5 + -3 debe ser -8");
        Assert.assertEquals(-2.0, calc.calcular("-", -5, -3), "-5 - -3 debe ser -2");
    }
    
    public void testCalculosConDecimales() {
        Calculadora calc = new Calculadora();
        calc.registrarOperacion("+", new Suma());
        calc.registrarOperacion("*", new Multiplicacion());
        
        Assert.assertEquals(7.5, calc.calcular("+", 3.2, 4.3), "3.2 + 4.3 debe ser 7.5");
    }
}
