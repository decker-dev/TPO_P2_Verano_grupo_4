package org.example.tpo.punto2;

import java.util.Random;

public class DynamicSet<T> implements Set<T> {

    private Node<T> node;
    private Random random;
    private int count;

    public DynamicSet() {
        this.random = new Random();
        this.count = 0;
    }

    @Override
    public void add(T a) {
        if (this.isEmpty()) {
            this.node = new Node<>(a, null);
            this.count++;
            return;
        }

        Node<T> aux = this.node;
        while (aux != null) {
            if (aux.getValue().equals(a)) {
                return;
            }
            aux = aux.getNext();
        }

        this.node = new Node<>(a, this.node);
        this.count++;
    }

    @Override
    public void remove(T a) {
        if (this.isEmpty()) {
            return;
        }

        if (this.node.getNext() == null) {
            if (this.node.getValue().equals(a)) {
                this.node = null;
                this.count--;
            }
            return;
        }

        if (this.node.getValue().equals(a)) {
            this.node = this.node.getNext();
            this.count--;
            return;
        }

        Node<T> backup = this.node;
        Node<T> aux = this.node.getNext();
        while (aux != null) {
            if (aux.getValue().equals(a)) {
                backup.setNext(aux.getNext());
                this.count--;
                return;
            }
            backup = aux;
            aux = aux.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.node == null;
    }

    @Override
    public T choose() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }
        if (this.node.getNext() == null) {
            return this.node.getValue();
        }
        int randomIndex = random.nextInt(count);
        int i = 0;
        Node<T> aux = this.node;
        while (i < count) {
            if (i == randomIndex) {
                return aux.getValue();
            }
            i++;
            aux = aux.getNext();
        }
        throw new RuntimeException("Error inesperado en choose");
    }
}