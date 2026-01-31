import java.util.List;

public class MainTest {
    
    public static void main(String[] args) {
        testBasic();
        testEmpty();
        testAllOdd();
        testAllEven();
        testNegatives();
        testNull();
        testLargeList();
        
        System.out.println("Todos los tests pasaron");
    }
    
    /**
     * Test básico del ejemplo proporcionado.
     */
    private static void testBasic() {
        List<Integer> input = List.of(3, 4, 5, 7, 6);
        long result = Main.countEvens(input);
        assert result == 2 : "Test básico fallo: esperado 2, obtenido " + result;
    }
    
    /**
     * Test con lista vacía.
     */
    private static void testEmpty() {
        List<Integer> input = List.of();
        long result = Main.countEvens(input);
        assert result == 0 : "Test lista vacía falló: esperado 0, obtenido " + result;
    }
    
    /**
     * Test con solo números impares.
     */
    private static void testAllOdd() {
        List<Integer> input = List.of(1, 3, 5, 7, 9);
        long result = Main.countEvens(input);
        assert result == 0 : "Test todos impares falló: esperado 0, obtenido " + result;
    }
    
    /**
     * Test con solo números pares.
     */
    private static void testAllEven() {
        List<Integer> input = List.of(2, 4, 6, 8, 10);
        long result = Main.countEvens(input);
        assert result == 5 : "Test todos pares falló: esperado 5, obtenido " + result;
    }
    
    /**
     * Test con números negativos.
     */
    private static void testNegatives() {
        List<Integer> input = List.of(-4, -3, -2, -1, 0, 1, 2);
        long result = Main.countEvens(input);
        assert result == 4 : "Test negativos falló: esperado 4, obtenido " + result;
    }
    
    /**
     * Test con valor cero.
     */
    private static void testNull() {
        List<Integer> input = List.of(0, 0, 0);
        long result = Main.countEvens(input);
        assert result == 3 : "Test ceros falló: esperado 3, obtenido " + result;
    }
    
    /**
     * Test con lista grande.
     */
    private static void testLargeList() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        long result = Main.countEvens(input);
        assert result == 7 : "Test lista grande falló: esperado 7, obtenido " + result;
    }
}
