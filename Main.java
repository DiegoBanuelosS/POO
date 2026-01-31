import java.util.List;

public class Main {
    
    /**
     * Cuenta la cantidad de números pares en una lista.
     * 
     * @param numbers lista de números enteros
     * @return cantidad de números pares
     */
    public static long countEvens(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).count();
    }
    
    public static void main(String[] args) {
        List<Integer> numeros = List.of(3, 4, 5, 7, 6);
        long pares = countEvens(numeros);
        System.out.println("Cantidad de numeros pares: " + pares);
    }
}
