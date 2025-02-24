package org.example.final_adelantado_2024_2C.model;

import org.example.final_adelantado_2024_2C.nodes.Node;

public class DynamicQueue implements Queue {

    private Node first;

    @Override
    public int getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
        }
        return this.first.getValue();
    }

    // Método para obtener el primer nodo (útil para recorrer la cola)
    public Node getFirstNode() {
        return this.first;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public void add(int a) {
        if (this.first == null) {
            this.first = new Node(a, null);
            return;
        }
        Node candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
        }
        candidate.setNext(new Node(a, null));
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar de una cola vacía");
        }
        this.first = this.first.getNext();
    }

    // Método para marcar los elementos que pertenecen a la secuencia de Fibonacci
    public void markFibonacci() {
        DynamicSet fibSet = new DynamicSet();
        // Generamos los números Fibonacci hasta 100
        int a = 1, b = 1;
        fibSet.add(a);
        fibSet.add(b);
        while (b <= 100) {
            int c = a + b;
            if (c > 100) break;
            fibSet.add(c);
            a = b;
            b = c;
        }

        // Recorremos la cola y marcamos los nodos cuyo valor se encuentre en fibSet
        Node current = this.first;
        while (current != null) {
            if (fibSet.contains(current.getValue())) {
                current.setMarked(true);
            }
            current = current.getNext();
        }
    }
}