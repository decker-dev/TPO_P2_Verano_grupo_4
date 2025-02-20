package org.example.tpo;

public interface PriorityQueue<T, P extends Comparable<?>> {

    /**
     * Devuelve el primer elemento (el de mayor prioridad, es decir,
     * aquel cuyo valor de prioridad es menor según compareTo).
     * @return el primer elemento de la cola de prioridad
     */
    T getFirst();

    /**
     * Devuelve la prioridad del primer elemento.
     * @return la prioridad del primer elemento
     */
    P getPriority();

    /**
     * Indica si la cola de prioridad está vacía.
     * @return true si está vacía, false en caso contrario
     */
    boolean isEmpty();

    /**
     * Agrega un elemento con su prioridad a la cola.
     * @param a elemento a agregar
     * @param priority prioridad asociada
     */
    void add(T a, P priority);

    /**
     * Remueve el primer elemento de la cola.
     */
    void remove();
}