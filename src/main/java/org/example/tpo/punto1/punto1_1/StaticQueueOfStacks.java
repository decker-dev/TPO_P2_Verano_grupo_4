package org.example.tpo.punto1.punto1_1;

public class StaticQueueOfStacks implements QueueOfStacks {
    private final Stack[] array;
    private int count;

    public StaticQueueOfStacks() {
        this.array = new Stack[10000];
        this.count = 0;
    }

    @Override
    public void remove() {
        if(this.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        for(int i = 0; i < this.count-1 ; i++){
            this.array[i] = this.array[i+1];
        }
        this.count--;
    }

    @Override
    public void add(Stack stack) {
        this.array[this.count] = stack;
        this.count++;
    }

    @Override
    public Stack getFirst() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return this.array[0];
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}
