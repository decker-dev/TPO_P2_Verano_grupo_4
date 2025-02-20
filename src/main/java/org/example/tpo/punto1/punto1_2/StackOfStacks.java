package org.example.tpo.punto1.punto1_2;

public interface StackOfStacks {
    /**Agrega un elemento {@link Stack}
     *
     * @param stack
     */
    void add(Stack stack);

    /**
     * Elimina el siguiente elemento del {@link Stack}
     */
    void remove();

    /**
     * Obtiene el siguiente elemento del {@link Stack}
     * @return el siguiente {@link Stack}
     */
    Stack getTop();

    /**
     * Evalua si el Stack esta vacio
     * @return boolean - stack vacio
     */
    boolean isEmpty();
}
