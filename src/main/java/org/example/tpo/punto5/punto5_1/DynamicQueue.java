package org.example.tpo.punto5.punto5_1;

public class DynamicQueue<T> implements Queue<T> {

    private Node<T> first;

    @Override
    public T getFirst() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
        }
        return this.first.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public void add(T a) {
        if(this.first == null) {
            this.first = new Node<>(a, null);
            return;
        }

        Node<T> candidate = this.first;
        while(candidate.getNext() != null) {
            candidate = candidate.getNext();
        }
        candidate.setNext(new Node<>(a, null));
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar de una cola vacía");
        }
        this.first = this.first.getNext();
    }
}