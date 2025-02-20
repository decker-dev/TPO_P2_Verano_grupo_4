package org.example;

import org.example.model.DynamicQueue;
import org.example.model.Queue;
import org.example.model.Stack;
import org.example.model.StaticStack;
import org.example.tpo.QueueOfQueue;
import org.example.tpo.QueueOfStacks;
import org.example.tpo.StaticQueueOfStacks;

public class App {

    public static void main(String[] args) {

        //ejercicio1
        ejercicio1();

        // Creamos algunas colas internas
        Queue q1 = new DynamicQueue();
        q1.add(1);
        q1.add(2);
        q1.add(3);

        Queue q2 = new DynamicQueue();
        q2.add(4);
        q2.add(5);
        q2.add(6);

        // Creamos la primera QueueOfQueue y le agregamos q1, q2
        QueueOfQueue qoq1 = new QueueOfQueue();
        qoq1.add(q1);
        qoq1.add(q2);

        System.out.println("qoq1 (original):");
        printQueueOfQueue(qoq1);

        // Creamos otra cola y otra QueueOfQueue para concatenar
        Queue q3 = new DynamicQueue();
        q3.add(7);
        q3.add(8);
        q3.add(9);

        QueueOfQueue qoq2 = new QueueOfQueue();
        qoq2.add(q3);

        // 1) Probamos concatenate
        QueueOfQueue concatenated = qoq1.concatenate(qoq2);
        System.out.println("\nConcatenated (qoq1 + qoq2):");
        printQueueOfQueue(concatenated);

        // 2) Probamos flat
        Queue flattened = concatenated.flat();
        System.out.print("\nFlattened queue (todos los valores concatenados en una sola cola): ");
        printQueue(flattened);
        System.out.println();

        // 3) Probamos reverseWithDepth en qoq1
        qoq1.reverseWithDepth();
        System.out.println("\nqoq1 después de reverseWithDepth (se invierte el orden y cada cola interna):");
        printQueueOfQueue(qoq1);
    }

    /**
     * Imprime el contenido de una Queue sin destruirla (usa una cola temporal).
     */
    private static void printQueue(Queue q) {
        Queue temp = new DynamicQueue();
        System.out.print("[ ");
        while(!q.isEmpty()) {
            int val = q.getFirst();
            System.out.print(val + " ");
            q.remove();
            temp.add(val);
        }
        System.out.print("]");

        // Restauramos la cola original
        while(!temp.isEmpty()) {
            q.add(temp.getFirst());
            temp.remove();
        }
    }

    /**
     * Imprime el contenido de una QueueOfQueue sin destruirla (usa una QueueOfQueue temporal).
     */
    private static void printQueueOfQueue(QueueOfQueue qoq) {
        QueueOfQueue tempQoq = new QueueOfQueue();
        System.out.println("{");
        while(!qoq.isEmpty()) {
            Queue frontQueue = qoq.getFirst();
            qoq.remove();

            // Imprimimos la cola que está en el frente
            System.out.print("  ");
            printQueue(frontQueue);
            System.out.println();

            // Volvemos a guardarla en una cola auxiliar
            tempQoq.add(frontQueue);
        }
        System.out.println("}");

        // Restauramos el qoq original
        while(!tempQoq.isEmpty()) {
            qoq.add(tempQoq.getFirst());
            tempQoq.remove();
        }
    }

    private static void ejercicio1() {
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

        int traza = calcularTraza(queueOfStacks);
        System.out.println("La traza de la matriz es " + traza + ".\n");
    }

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