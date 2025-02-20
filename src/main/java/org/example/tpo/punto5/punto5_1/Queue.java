package org.example.tpo.punto5.punto5_1;

public interface Queue<T> {

    /**
     * Devuelve el primer elemento de la cola.
     * @return el primer elemento.
     */
    T getFirst();

    /**
     * Indica si la cola está vacía.
     * @return true si está vacía, false en caso contrario.
     */
    boolean isEmpty();

    /**
     * Agrega un elemento al final de la cola.
     * @param a elemento a agregar.
     */
    void add(T a);

    /**
     * Remueve el primer elemento de la cola.
     */
    void remove();
}