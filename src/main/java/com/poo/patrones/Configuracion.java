package com.poo.patrones;

/**
 * Clase Singleton que gestiona la configuración de la aplicación.
 * Demuestra el patrón de diseño Singleton.
 * 
 * @author Diego
 * @version 1.0
 */
public final class Configuracion {
    
    private static volatile Configuracion instancia;
    
    private String nombreAplicacion;
    private String version;
    private String idioma;
    private boolean modoDebug;
    private int maxConexiones;

    /**
     * Constructor privado para evitar instanciación externa.
     */
    private Configuracion() {
        // Valores por defecto
        this.nombreAplicacion = "Ejercicios POO";
        this.version = "1.0.0";
        this.idioma = "es";
        this.modoDebug = false;
        this.maxConexiones = 10;
    }

    /**
     * Obtiene la instancia única de Configuración (Thread-safe).
     * 
     * @return La instancia de Configuración
     */
    public static Configuracion getInstancia() {
        if (instancia == null) {
            synchronized (Configuracion.class) {
                if (instancia == null) {
                    instancia = new Configuracion();
                }
            }
        }
        return instancia;
    }

    // Getters y Setters

    /**
     * Obtiene el nombre de la aplicación.
     * 
     * @return El nombre de la aplicación
     */
    public String getNombreAplicacion() {
        return nombreAplicacion;
    }

    /**
     * Establece el nombre de la aplicación.
     * 
     * @param nombreAplicacion El nuevo nombre
     */
    public void setNombreAplicacion(String nombreAplicacion) {
        this.nombreAplicacion = nombreAplicacion;
    }

    /**
     * Obtiene la versión de la aplicación.
     * 
     * @return La versión
     */
    public String getVersion() {
        return version;
    }

    /**
     * Establece la versión de la aplicación.
     * 
     * @param version La nueva versión
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Obtiene el idioma configurado.
     * 
     * @return El idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * Establece el idioma de la aplicación.
     * 
     * @param idioma El nuevo idioma
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     * Verifica si está en modo debug.
     * 
     * @return true si está en modo debug
     */
    public boolean isModoDebug() {
        return modoDebug;
    }

    /**
     * Activa o desactiva el modo debug.
     * 
     * @param modoDebug Estado del modo debug
     */
    public void setModoDebug(boolean modoDebug) {
        this.modoDebug = modoDebug;
    }

    /**
     * Obtiene el máximo de conexiones permitidas.
     * 
     * @return Número máximo de conexiones
     */
    public int getMaxConexiones() {
        return maxConexiones;
    }

    /**
     * Establece el máximo de conexiones.
     * 
     * @param maxConexiones Número máximo de conexiones
     */
    public void setMaxConexiones(int maxConexiones) {
        if (maxConexiones > 0) {
            this.maxConexiones = maxConexiones;
        }
    }

    /**
     * Imprime la configuración actual.
     */
    public void imprimirConfiguracion() {
        System.out.println("=== Configuración de la Aplicación ===");
        System.out.println("Nombre: " + nombreAplicacion);
        System.out.println("Versión: " + version);
        System.out.println("Idioma: " + idioma);
        System.out.println("Modo Debug: " + (modoDebug ? "Activado" : "Desactivado"));
        System.out.println("Max. Conexiones: " + maxConexiones);
    }

    @Override
    public String toString() {
        return "Configuracion{" +
                "nombreAplicacion='" + nombreAplicacion + '\'' +
                ", version='" + version + '\'' +
                ", idioma='" + idioma + '\'' +
                ", modoDebug=" + modoDebug +
                ", maxConexiones=" + maxConexiones +
                '}';
    }
}
