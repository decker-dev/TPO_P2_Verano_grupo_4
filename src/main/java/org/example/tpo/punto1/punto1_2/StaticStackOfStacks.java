package org.example.tpo.punto1.punto1_2;

public class StaticStackOfStacks implements StackOfStacks{

    private static final int MAX = 10000;

    private final Stack[] array;
    private int count;

    public StaticStackOfStacks() {
        this.array = new Stack[MAX];
        this.count = 0;
    }


    @Override
    public void add(Stack stack) {
        this.array[count] = stack;
        this.count++;
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar de una pila vacia");
        }
        this.count--;
    }

    @Override
    public Stack getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacia");
        }
        return this.array[count - 1];
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}
