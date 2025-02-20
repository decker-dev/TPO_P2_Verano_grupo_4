package org.example.tpo;

public interface Stack<T> {

    /**
     * Devuelve el elemento en el tope de la pila.
     * @return el elemento del tope.
     */
    T getTop();

    /**
     * Indica si la pila está vacía.
     * @return true si la pila está vacía, false en caso contrario.
     */
    boolean isEmpty();

    /**
     * Agrega un elemento a la pila.
     * @param a elemento a agregar.
     */
    void add(T a);

    /**
     * Remueve el elemento del tope de la pila.
     */
    void remove();
}