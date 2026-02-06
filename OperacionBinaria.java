public abstract class OperacionBinaria implements Operacion {
    protected String nombre;
    
    public OperacionBinaria(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public abstract double ejecutar(double a, double b);
}
