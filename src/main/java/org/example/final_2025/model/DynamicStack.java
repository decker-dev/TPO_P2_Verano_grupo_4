package org.example.final_2025.model;

import org.example.final_2025.model.nodes.Node;

public class DynamicStack implements Stack {

    private Node top;
    private int sum; // Suma total de los elementos en la pila

    public DynamicStack() {
        this.top = null;
        this.sum = 0;
    }

    @Override
    public int getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacía");
        }
        return this.top.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public void add(int a) {
        // Verifica si al agregar 'a', la suma total sería un múltiplo de 3
        if ((this.sum + a) % 3 == 0) {
            throw new RuntimeException("No se puede agregar el elemento " + a +
                    " porque la suma resultante (" + (this.sum + a) + ") es un múltiplo de 3");
        }
        // Agrega el elemento y actualiza la suma
        this.top = new Node(a, this.top);
        this.sum += a;
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar de una pila vacía");
        }
        int valueToRemove = this.top.getValue();
        // Verifica si al eliminar el elemento, la suma de los elementos restantes sería un múltiplo de 3
        if ((this.sum - valueToRemove) % 3 == 0) {
            throw new RuntimeException("No se puede eliminar el elemento " + valueToRemove +
                    " porque la suma de los elementos restantes (" + (this.sum - valueToRemove) +
                    ") sería un múltiplo de 3");
        }
        // Remueve el elemento y actualiza la suma
        this.top = this.top.getNext();
        this.sum -= valueToRemove;
    }
}