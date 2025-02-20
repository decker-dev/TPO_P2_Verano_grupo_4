package org.example.tpo.punto2;

public class DynamicPriorityQueue<T, P extends Comparable<P>> implements PriorityQueue<T, P> {

    private PriorityNode<T, P> first;

    @Override
    public T getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el valor de una cola vacía");
        }
        return first.getValue();
    }

    @Override
    public P getPriority() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener la prioridad de una cola vacía");
        }
        return first.getPriority();
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void add(T a, P priority) {
        // Caso base: si la cola está vacía, el nuevo nodo se convierte en el primero.
        if (isEmpty()) {
            first = new PriorityNode<>(a, priority, null);
            return;
        }
        // Si el nuevo elemento tiene mayor prioridad (menor valor en compareTo) que el primero, lo insertamos al inicio.
        if (priority.compareTo(first.getPriority()) < 0) {
            first = new PriorityNode<>(a, priority, first);
            return;
        }
        // Recorremos la lista para encontrar el lugar de inserción
        PriorityNode<T, P> current = first;
        while (current.getNext() != null &&
                priority.compareTo(current.getNext().getPriority()) >= 0) {
            current = current.getNext();
        }
        current.setNext(new PriorityNode<>(a, priority, current.getNext()));
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacía");
        }
        first = first.getNext();
    }
}