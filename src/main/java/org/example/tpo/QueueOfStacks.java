package org.example.tpo;

import org.example.model.Stack;

public interface QueueOfStacks {
    void remove();
    void add(Stack stack);
    Stack getFirst();
    boolean isEmpty();
}