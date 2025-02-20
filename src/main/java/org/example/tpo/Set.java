package org.example.tpo;

public interface Set<T> {

    /**
     * Agrega un elemento al conjunto.
     * @param a elemento a agregar.
     */
    void add(T a);

    /**
     * Remueve el elemento del conjunto.
     * @param a elemento a remover.
     */
    void remove(T a);

    /**
     * Indica si el conjunto está vacío.
     * @return true si está vacío, false en caso contrario.
     */
    boolean isEmpty();

    /**
     * Selecciona y devuelve un elemento aleatorio del conjunto.
     * Precondición: el conjunto no debe estar vacío.
     * @return un elemento aleatorio.
     */
    T choose();
}