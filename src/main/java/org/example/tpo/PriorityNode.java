package org.example.tpo;

public class PriorityNode<T, P extends Comparable<P>> {

    private T value;
    private P priority;
    private PriorityNode<T, P> next;

    public PriorityNode(T value, P priority, PriorityNode<T, P> next) {
        this.value = value;
        this.priority = priority;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public P getPriority() {
        return priority;
    }

    public void setPriority(P priority) {
        this.priority = priority;
    }

    public PriorityNode<T, P> getNext() {
        return next;
    }

    public void setNext(PriorityNode<T, P> next) {
        this.next = next;
    }
}