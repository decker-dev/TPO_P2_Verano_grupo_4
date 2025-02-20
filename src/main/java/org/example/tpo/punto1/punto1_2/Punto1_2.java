package org.example.tpo.punto1.punto1_2;

public class Punto1_2 {
    public static void main(String[] args) {
        transponerDatos(initQoS());
    }

    private static QueueOfStacks initQoS(){
        QueueOfStacks queueOfStacks = new StaticQueueOfStacks();
        Stack stack1 = new StaticStack();
        stack1.add(3);
        stack1.add(2);
        stack1.add(1);
        queueOfStacks.add(stack1);
        Stack stack2 = new StaticStack();
        stack2.add(6);
        stack2.add(5);
        stack2.add(4);
        queueOfStacks.add(stack2);
        Stack stack3 = new StaticStack();
        stack3.add(9);
        stack3.add(8);
        stack3.add(7);
        queueOfStacks.add(stack3);

        return queueOfStacks;
    }


    /**
     * Complejidad: O(n + m), donde n es la cantidad de pilas en la cola y m es
     *  el número total de elementos
     *
     * Invierte los valores de cada {@link Stack} dentro de un {@link QueueOfStacks},
     * e invierte la posicion de los {@link Stack} dentro de la cola del {@link QueueOfStacks}
     * @param original
     * @return QueueOfStacks invertido
     */
    private static QueueOfStacks transponerDatos(QueueOfStacks original){
        QueueOfStacks result = new StaticQueueOfStacks();
        StackOfStacks aux = new StaticStackOfStacks();

        if (original.isEmpty()) {
            throw new RuntimeException("No se puede transponer una cola vacia");
        }

        //invertimos la cola usando una pila de pilas
        while(!original.isEmpty()) {
            aux.add(original.getFirst());
            original.remove();
        }

        //invertimos las pilas previo a agregarlas al resultado
        while(!aux.isEmpty()) {
            Stack stack = aux.getTop();
            Stack auxStack = new StaticStack();
            while(!stack.isEmpty()){
                auxStack.add(stack.getTop());
                stack.remove();
            }
            result.add(auxStack);
            aux.remove();
        }

        return result;
    }
}
