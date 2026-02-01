package com.poo.colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Clase genérica que gestiona una lista de elementos.
 * Demuestra uso de genéricos, colecciones y programación funcional.
 * 
 * @param <T> Tipo de elementos que almacena la lista
 * @author Diego
 * @version 1.0
 */
public class ListaGenerica<T> {
    
    private final List<T> elementos;

    /**
     * Constructor por defecto.
     */
    public ListaGenerica() {
        this.elementos = new ArrayList<>();
    }

    /**
     * Constructor con capacidad inicial.
     * 
     * @param capacidadInicial Capacidad inicial de la lista
     */
    public ListaGenerica(int capacidadInicial) {
        this.elementos = new ArrayList<>(capacidadInicial);
    }

    /**
     * Agrega un elemento a la lista.
     * 
     * @param elemento Elemento a agregar
     * @return true si se agregó correctamente
     */
    public boolean agregar(T elemento) {
        if (elemento == null) {
            return false;
        }
        return elementos.add(elemento);
    }

    /**
     * Agrega múltiples elementos a la lista.
     * 
     * @param nuevosElementos Elementos a agregar
     * @return Cantidad de elementos agregados
     */
    @SafeVarargs
    public final int agregarVarios(T... nuevosElementos) {
        int contador = 0;
        for (T elemento : nuevosElementos) {
            if (agregar(elemento)) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Elimina un elemento de la lista.
     * 
     * @param elemento Elemento a eliminar
     * @return true si se eliminó correctamente
     */
    public boolean eliminar(T elemento) {
        return elementos.remove(elemento);
    }

    /**
     * Elimina el elemento en la posición especificada.
     * 
     * @param indice Índice del elemento a eliminar
     * @return El elemento eliminado o null si el índice es inválido
     */
    public T eliminarEn(int indice) {
        if (indice < 0 || indice >= elementos.size()) {
            return null;
        }
        return elementos.remove(indice);
    }

    /**
     * Obtiene el elemento en la posición especificada.
     * 
     * @param indice Índice del elemento
     * @return Optional con el elemento o vacío si no existe
     */
    public Optional<T> obtener(int indice) {
        if (indice < 0 || indice >= elementos.size()) {
            return Optional.empty();
        }
        return Optional.ofNullable(elementos.get(indice));
    }

    /**
     * Busca un elemento en la lista.
     * 
     * @param elemento Elemento a buscar
     * @return Índice del elemento o -1 si no se encuentra
     */
    public int buscar(T elemento) {
        return elementos.indexOf(elemento);
    }

    /**
     * Verifica si la lista contiene el elemento.
     * 
     * @param elemento Elemento a verificar
     * @return true si la lista contiene el elemento
     */
    public boolean contiene(T elemento) {
        return elementos.contains(elemento);
    }

    /**
     * Obtiene el tamaño de la lista.
     * 
     * @return Número de elementos en la lista
     */
    public int tamanio() {
        return elementos.size();
    }

    /**
     * Verifica si la lista está vacía.
     * 
     * @return true si la lista no tiene elementos
     */
    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    /**
     * Limpia todos los elementos de la lista.
     */
    public void limpiar() {
        elementos.clear();
    }

    /**
     * Obtiene una copia inmutable de la lista.
     * 
     * @return Lista inmutable con los elementos
     */
    public List<T> obtenerTodos() {
        return Collections.unmodifiableList(elementos);
    }

    /**
     * Ordena la lista usando el comparador proporcionado.
     * 
     * @param comparador Comparador para ordenar
     */
    public void ordenar(Comparator<T> comparador) {
        elementos.sort(comparador);
    }

    /**
     * Invierte el orden de los elementos.
     */
    public void invertir() {
        Collections.reverse(elementos);
    }

    /**
     * Mezcla aleatoriamente los elementos.
     */
    public void mezclar() {
        Collections.shuffle(elementos);
    }

    /**
     * Filtra elementos según un criterio usando Streams.
     * 
     * @param filtro Función de filtrado
     * @return Nueva lista con elementos filtrados
     */
    public List<T> filtrar(java.util.function.Predicate<T> filtro) {
        return elementos.stream()
                .filter(filtro)
                .collect(Collectors.toList());
    }

    /**
     * Aplica una transformación a cada elemento.
     * 
     * @param <R> Tipo del resultado
     * @param transformacion Función de transformación
     * @return Lista con elementos transformados
     */
    public <R> List<R> transformar(java.util.function.Function<T, R> transformacion) {
        return elementos.stream()
                .map(transformacion)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene el primer elemento que cumple el criterio.
     * 
     * @param filtro Criterio de búsqueda
     * @return Optional con el elemento encontrado
     */
    public Optional<T> buscarPrimero(java.util.function.Predicate<T> filtro) {
        return elementos.stream()
                .filter(filtro)
                .findFirst();
    }

    /**
     * Verifica si todos los elementos cumplen el criterio.
     * 
     * @param criterio Criterio a verificar
     * @return true si todos cumplen
     */
    public boolean todosCumplen(java.util.function.Predicate<T> criterio) {
        return elementos.stream().allMatch(criterio);
    }

    /**
     * Verifica si algún elemento cumple el criterio.
     * 
     * @param criterio Criterio a verificar
     * @return true si al menos uno cumple
     */
    public boolean algunoCumple(java.util.function.Predicate<T> criterio) {
        return elementos.stream().anyMatch(criterio);
    }

    /**
     * Ejecuta una acción para cada elemento.
     * 
     * @param accion Acción a ejecutar
     */
    public void paraCadaUno(java.util.function.Consumer<T> accion) {
        elementos.forEach(accion);
    }

    @Override
    public String toString() {
        return "ListaGenerica{" +
                "elementos=" + elementos +
                ", tamaño=" + elementos.size() +
                '}';
    }
}
