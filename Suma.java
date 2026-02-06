public class Suma extends OperacionBinaria {
    
    public Suma() {
        super("Suma");
    }
    
    @Override
    public double ejecutar(double a, double b) {
        return a + b;
    }
}
