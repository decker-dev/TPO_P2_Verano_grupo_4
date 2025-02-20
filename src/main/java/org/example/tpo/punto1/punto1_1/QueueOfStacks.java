package org.example.tpo.punto1.punto1_1;

public interface QueueOfStacks {
    /**Elimina el siguiente {@link Stack}
     *
     */
    void remove();

    /**
     * Agrega un {@link Stack} a la cola
     * @param stack
     */
    void add(Stack stack);

    /**
     * Obtiene el siguiente elemento
     * @return siguiente elemento
     */
    Stack getFirst();

    /**
     * Evalua si la cola esta vacia
     * @return boolean - cola vacia
     */
    boolean isEmpty();
}