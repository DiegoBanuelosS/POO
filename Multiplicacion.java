public class Multiplicacion extends OperacionBinaria {
    
    public Multiplicacion() {
        super("Multiplicación");
    }
    
    @Override
    public double ejecutar(double a, double b) {
        if (b == 0 || a == 0) return 0;
        
        boolean negativo = (a < 0) != (b < 0);
        a = Math.abs(a);
        b = Math.abs(b);
        
        double resultado = 0;
        for (int i = 0; i < (int)b; i++) {
            resultado = resultado + a;
        }
        
        return negativo ? -resultado : resultado;
    }
}
