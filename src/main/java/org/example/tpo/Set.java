package org.example.tpo;

/**
 * Interfaz genérica para un conjunto de elementos comparables.
 * @param <T> tipo de dato que implementa Comparable
 */
public interface Set<T extends Comparable<T>> {

    /**
     * Agrega el elemento 'a' al conjunto.
     * Si 'a' ya existe en el conjunto, no hace nada.
     */
    void add(T a);

    /**
     * Elimina el elemento 'a' del conjunto, si existe.
     */
    void remove(T a);

    /**
     * @return true si el conjunto está vacío, false en caso contrario.
     */
    boolean isEmpty();

    /**
     * Elige un elemento del conjunto de forma aleatoria.
     * Precondición: El conjunto no está vacío.
     */
    T choose();

    /**
     * Método opcional (no estaba en el original),
     * pero muy útil para verificar la existencia de un elemento.
     */
    boolean contains(T a);
}