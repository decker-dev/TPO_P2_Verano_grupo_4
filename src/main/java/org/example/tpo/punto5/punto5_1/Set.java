package org.example.tpo.punto5.punto5_1;

public interface Set<T> {

    void add(T a);
    void remove(T a);
    boolean isEmpty();

    /**
     * Precondición: No se puede elegir un elemento de un conjunto vacío
     * @return un elemento de forma aleatoria
     */
    T choose();
}