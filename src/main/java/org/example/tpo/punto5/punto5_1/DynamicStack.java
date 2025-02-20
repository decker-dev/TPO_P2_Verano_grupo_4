package org.example.tpo.punto5.punto5_1;

public class DynamicStack<T> implements Stack<T> {

    private Node<T> top;

    @Override
    public T getTop() {
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
    public void add(T a) {
        // Se agrega un nuevo nodo al inicio, el cual apunta al tope actual.
        this.top = new Node<>(a, this.top);
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar de una pila vacía");
        }
        this.top = this.top.getNext();
    }
}