public class Resta extends OperacionBinaria {
    
    public Resta() {
        super("Resta");
    }
    
    @Override
    public double ejecutar(double a, double b) {
        return a - b;
    }
}
