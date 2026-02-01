package com.poo;

import com.poo.modelo.Persona;
import com.poo.modelo.Estudiante;
import com.poo.modelo.Profesor;
import com.poo.geometria.Figura;
import com.poo.geometria.Circulo;
import com.poo.geometria.Rectangulo;
import com.poo.geometria.Triangulo;
import com.poo.banco.CuentaBancaria;
import com.poo.banco.CuentaAhorro;
import com.poo.excepciones.SaldoInsuficienteException;
import com.poo.colecciones.ListaGenerica;
import com.poo.patrones.Configuracion;
import com.poo.patrones.PersonaFactory;
import com.poo.enums.DiaSemana;
import com.poo.enums.Prioridad;

/**
 * Clase principal que demuestra el uso de todos los conceptos de POO.
 * 
 * @author Diego
 * @version 1.0
 */
public class Main {

    /**
     * Método principal de la aplicación.
     * 
     * @param args Argumentos de línea de comandos
     */
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("    EJERCICIOS DE PROGRAMACIÓN ORIENTADA A OBJETOS");
        System.out.println("=".repeat(60));

        // 1. Demostración de clases básicas y herencia
        demostrarHerencia();
        
        // 2. Demostración de figuras geométricas (abstracción e interfaces)
        demostrarFigurasGeometricas();
        
        // 3. Demostración de cuentas bancarias (excepciones)
        demostrarCuentasBancarias();
        
        // 4. Demostración de colecciones genéricas
        demostrarColeccionesGenericas();
        
        // 5. Demostración de patrones de diseño
        demostrarPatrones();
        
        // 6. Demostración de enumeraciones
        demostrarEnums();
    }

    /**
     * Demuestra herencia y polimorfismo con Persona, Estudiante y Profesor.
     */
    private static void demostrarHerencia() {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("1. HERENCIA Y POLIMORFISMO");
        System.out.println("-".repeat(50));

        // Crear personas
        Persona persona = new Persona("Juan", "García", 25, "12345678A");
        Estudiante estudiante = new Estudiante("María", "López", 20, "87654321B", 
                                               "EST001", "Ingeniería", 3);
        Profesor profesor = new Profesor("Carlos", "Martínez", 45, "11111111C",
                                         "PROF001", "Computación", 35000);

        // Agregar calificaciones al estudiante
        estudiante.agregarCalificacion(8.5);
        estudiante.agregarCalificacion(9.0);
        estudiante.agregarCalificacion(7.5);

        // Agregar materias al profesor
        profesor.agregarMateria("POO");
        profesor.agregarMateria("Estructuras de Datos");
        profesor.agregarMateria("Algoritmos");

        // Mostrar información
        System.out.println("\nPersona: " + persona);
        System.out.println("Es mayor de edad: " + persona.esMayorDeEdad());
        
        System.out.println("\nEstudiante: " + estudiante);
        System.out.println("Promedio: " + String.format("%.2f", estudiante.calcularPromedio()));
        System.out.println("¿Aprobado?: " + (estudiante.estaAprobado() ? "Sí" : "No"));
        
        System.out.println("\nProfesor: " + profesor);
        System.out.println("Salario total: $" + String.format("%.2f", profesor.calcularSalarioTotal()));

        // Polimorfismo
        System.out.println("\n--- Polimorfismo ---");
        Persona[] personas = {persona, estudiante, profesor};
        for (Persona p : personas) {
            System.out.println(p.getNombreCompleto() + " - " + p.getClass().getSimpleName());
        }
    }

    /**
     * Demuestra abstracción e interfaces con figuras geométricas.
     */
    private static void demostrarFigurasGeometricas() {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("2. ABSTRACCIÓN E INTERFACES (FIGURAS)");
        System.out.println("-".repeat(50));

        // Crear figuras
        Circulo circulo = new Circulo(5, "Rojo");
        Rectangulo rectangulo = new Rectangulo(8, 4, "Azul");
        Triangulo triangulo = new Triangulo(3, 4, 5, "Verde");

        // Polimorfismo con figuras
        Figura[] figuras = {circulo, rectangulo, triangulo};
        
        for (Figura figura : figuras) {
            System.out.println("\n" + figura);
            System.out.println("Área: " + String.format("%.2f", figura.calcularArea()));
            System.out.println("Perímetro: " + String.format("%.2f", figura.calcularPerimetro()));
        }

        // Mostrar representación ASCII
        System.out.println("\n--- Representación ASCII del Rectángulo ---");
        rectangulo.dibujar();

        // Información específica del triángulo
        System.out.println("Tipo de triángulo: " + triangulo.obtenerTipo());
        System.out.println("¿Es rectángulo?: " + (triangulo.esRectangulo() ? "Sí" : "No"));
    }

    /**
     * Demuestra manejo de excepciones con cuentas bancarias.
     */
    private static void demostrarCuentasBancarias() {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("3. EXCEPCIONES (CUENTAS BANCARIAS)");
        System.out.println("-".repeat(50));

        // Crear cuentas
        CuentaBancaria cuenta1 = new CuentaBancaria("Juan Pérez", 1000);
        CuentaAhorro cuentaAhorro = new CuentaAhorro("María García", 5000, 0.08);

        System.out.println("\nCuentas creadas:");
        System.out.println(cuenta1);
        System.out.println(cuentaAhorro);

        // Operaciones
        System.out.println("\n--- Operaciones ---");
        cuenta1.depositar(500);
        System.out.println("Después de depositar $500: Saldo = $" + String.format("%.2f", cuenta1.getSaldo()));

        try {
            cuenta1.retirar(200);
            System.out.println("Después de retirar $200: Saldo = $" + String.format("%.2f", cuenta1.getSaldo()));
            
            // Intentar retirar más de lo disponible
            cuenta1.retirar(5000);
        } catch (SaldoInsuficienteException e) {
            System.out.println("\n⚠️ Error: " + e.getMessage());
            System.out.println("Déficit: $" + String.format("%.2f", e.calcularDeficit()));
        }

        // Transferencia
        try {
            System.out.println("\n--- Transferencia ---");
            cuenta1.transferir(cuentaAhorro, 300);
            System.out.println("Transferencia exitosa de $300");
            System.out.println("Cuenta origen: $" + String.format("%.2f", cuenta1.getSaldo()));
            System.out.println("Cuenta destino: $" + String.format("%.2f", cuentaAhorro.getSaldo()));
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error en transferencia: " + e.getMessage());
        }

        // Intereses de la cuenta de ahorro
        System.out.println("\n--- Cuenta de Ahorro ---");
        System.out.println("Intereses anuales: $" + String.format("%.2f", cuentaAhorro.calcularIntereses()));
        System.out.println("Proyección a 5 años: $" + String.format("%.2f", cuentaAhorro.proyectarSaldo(5)));
    }

    /**
     * Demuestra el uso de colecciones genéricas.
     */
    private static void demostrarColeccionesGenericas() {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("4. GENÉRICOS Y COLECCIONES");
        System.out.println("-".repeat(50));

        // Lista de números
        ListaGenerica<Integer> numeros = new ListaGenerica<>();
        numeros.agregarVarios(5, 2, 8, 1, 9, 3, 7);
        
        System.out.println("\nLista original: " + numeros.obtenerTodos());
        
        // Filtrar pares
        var pares = numeros.filtrar(n -> n % 2 == 0);
        System.out.println("Números pares: " + pares);
        
        // Transformar a cuadrados
        var cuadrados = numeros.transformar(n -> n * n);
        System.out.println("Cuadrados: " + cuadrados);
        
        // Lista de strings
        ListaGenerica<String> nombres = new ListaGenerica<>();
        nombres.agregarVarios("Ana", "Carlos", "Beatriz", "David");
        
        System.out.println("\nNombres: " + nombres.obtenerTodos());
        
        // Buscar nombres que empiecen con A
        var conA = nombres.filtrar(n -> n.startsWith("A"));
        System.out.println("Nombres con A: " + conA);
        
        // Verificar si alguno cumple condición
        System.out.println("¿Alguno tiene más de 5 letras?: " + 
                           nombres.algunoCumple(n -> n.length() > 5));
    }

    /**
     * Demuestra patrones de diseño (Singleton y Factory).
     */
    private static void demostrarPatrones() {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("5. PATRONES DE DISEÑO");
        System.out.println("-".repeat(50));

        // Singleton
        System.out.println("\n--- Patrón Singleton ---");
        Configuracion config1 = Configuracion.getInstancia();
        Configuracion config2 = Configuracion.getInstancia();
        
        System.out.println("¿Son la misma instancia?: " + (config1 == config2));
        config1.setModoDebug(true);
        config1.imprimirConfiguracion();

        // Factory
        System.out.println("\n--- Patrón Factory ---");
        PersonaFactory factory = new PersonaFactory();
        
        Persona p1 = factory.crearPersona(PersonaFactory.TipoPersona.PERSONA);
        Persona p2 = factory.crearEstudiante("Luis", "Sánchez", 19, "99999999X", 
                                              "EST999", "Medicina", 1);
        Persona p3 = factory.crearProfesor("Ana", "Ruiz", 38, "88888888Y",
                                           "PROF999", "Matemáticas", 40000);
        
        System.out.println("Creados con Factory:");
        System.out.println("- " + p1.getClass().getSimpleName());
        System.out.println("- " + p2.getClass().getSimpleName() + ": " + p2.getNombreCompleto());
        System.out.println("- " + p3.getClass().getSimpleName() + ": " + p3.getNombreCompleto());
    }

    /**
     * Demuestra el uso de enumeraciones.
     */
    private static void demostrarEnums() {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("6. ENUMERACIONES");
        System.out.println("-".repeat(50));

        // Días de la semana
        System.out.println("\n--- Días de la Semana ---");
        DiaSemana hoy = DiaSemana.MIERCOLES;
        System.out.println("Hoy es: " + hoy);
        System.out.println("En inglés: " + hoy.getNombreIngles());
        System.out.println("¿Es laboral?: " + (hoy.isEsLaboral() ? "Sí" : "No"));
        System.out.println("Mañana será: " + hoy.getSiguiente());
        System.out.println("Días hasta el viernes: " + hoy.diasHasta(DiaSemana.VIERNES));

        // Prioridades
        System.out.println("\n--- Prioridades ---");
        Prioridad tarea1 = Prioridad.ALTA;
        Prioridad tarea2 = Prioridad.BAJA;
        
        System.out.println("Tarea 1: " + tarea1);
        System.out.println("Tarea 2: " + tarea2);
        System.out.println("¿Tarea 1 es más prioritaria?: " + tarea1.esMayorQue(tarea2));
        System.out.println("¿Tarea 1 es urgente?: " + tarea1.esUrgente());

        System.out.println("\n" + "=".repeat(60));
        System.out.println("    FIN DE LA DEMOSTRACIÓN");
        System.out.println("=".repeat(60));
    }
}
