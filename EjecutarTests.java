public class EjecutarTests {
    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("=" + " ".repeat(58) + "=");
        System.out.println("=" + " ".repeat(15) + "SUITE DE TESTS DE CALCULADORA" + " ".repeat(14) + "=");
        System.out.println("=" + " ".repeat(58) + "=");
        System.out.println("=".repeat(60) + "\n");
        
        TestRunner.ejecutarTodos(
            SumaTest.class,
            RestaTest.class,
            MultiplicacionTest.class,
            DivisionTest.class,
            CalculadoraTest.class
        );
        
        System.out.println("\n" + "=".repeat(60) + "\n");
    }
}
