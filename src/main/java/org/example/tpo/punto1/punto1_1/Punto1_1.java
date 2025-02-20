package org.example.tpo.punto1.punto1_1;

public class Punto1_1 {

    public static void main(String[] args) {
        calcularTraza(initQoS());
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
     * Calcula la traza de un {@link QueueOfStacks} asumiendo que el objeto esta estructurado
     * como una matriz nxn.
     *
     * Complejidad: O(n), donde n es la cantidad de pilas en la cola, ya que cada
     * elemento es procesado una vez.
     *
     * @see <a href='https://es.wikipedia.org/wiki/Traza_(%C3%A1lgebra_lineal)'>Traza de matriz</a>
     *
     * @param queueOfStacks
     * @return int - valor de la traza
     */
    private static int calcularTraza(QueueOfStacks queueOfStacks){
        int traza = 0;
        boolean firstStack = true;
        int size = 0;
        while (!queueOfStacks.isEmpty()) {
            Stack stack = queueOfStacks.getFirst();
            int valor = 0;
            for (int i = 0; !stack.isEmpty() && (firstStack || i < size); i++) {
                valor = stack.getTop();
                stack.remove();
                if(firstStack) {
                    size++;
                }
            }
            traza += valor;
            queueOfStacks.remove();
            firstStack = false;
            size--;

        }

        return traza;
    }
}
