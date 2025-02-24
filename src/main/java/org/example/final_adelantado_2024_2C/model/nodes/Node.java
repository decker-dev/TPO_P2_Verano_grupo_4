package org.example.final_adelantado_2024_2C.model.nodes;

public class Node {

    private int value;
    private Node next;
    private boolean marked; // atributo para marcar el nodo

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
        this.marked = false; // por defecto, no marcado
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}