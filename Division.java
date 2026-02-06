public class Division extends OperacionBinaria {
    
    public Division() {
        super("División");
    }
    
    @Override
    public double ejecutar(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        
        boolean negativo = (a < 0) != (b < 0);
        a = Math.abs(a);
        b = Math.abs(b);
        
        int contador = 0;
        while (a >= b) {
            a = a - b;
            contador = contador + 1;
        }
        
        return negativo ? -contador : contador;
    }
}
