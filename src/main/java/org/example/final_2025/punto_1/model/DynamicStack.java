package org.example.final_2025.punto_1.model;

import org.example.final_2025.punto_1.model.nodes.Node;

public class DynamicStack implements Stack {

    private Node top;
    private int sum;

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

    @Override
    public int topCandidate() {
        if (this.isEmpty()) {
            throw new RuntimeException("La pila está vacía, no hay candidatos.");
        }
        // Recorre la pila desde el tope hacia abajo
        Node current = this.top;
        while (current != null) {
            int candidateValue = current.getValue();
            // Se verifica que al quitar este elemento, la suma de los restantes no sea múltiplo de 3
            if ((this.sum - candidateValue) % 3 != 0) {
                return candidateValue;
            }
            current = current.getNext();
        }
        // Si no se encontró candidato, se lanza una excepción
        throw new RuntimeException("No existe un candidato para remover sin que la suma de los elementos restantes sea múltiplo de 3");
    }
}