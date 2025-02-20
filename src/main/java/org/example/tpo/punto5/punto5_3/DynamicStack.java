package org.example.tpo.punto5.punto5_3;

public class DynamicStack implements Stack {

    private Node top;

    @Override
    public int getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacia");
        }
        return this.top.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public void add(int a) {
        this.top = new Node(a, this.top);
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar de una pila vacia");
        }
        this.top = this.top.getNext();
    }
}
