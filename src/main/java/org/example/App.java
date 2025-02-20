package org.example;

import org.example.model.DynamicQueue;
import org.example.model.Queue;
import org.example.tpo.*;

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

        // Probamos concatenate
        QueueOfQueue concatenated = qoq1.concatenate(qoq2);
        System.out.println("\nConcatenated (qoq1 + qoq2):");
        printQueueOfQueue(concatenated);

        // Probamos flat
        Queue flattened = concatenated.flat();
        System.out.print("\nFlattened queue (todos los valores concatenados en una sola cola): ");
        printQueue(flattened);
        System.out.println();

        // Probamos reverseWithDepth en qoq1 y luego aplicamos flat
        qoq1.reverseWithDepth();
        System.out.println("\nqoq1 después de reverseWithDepth:");
        printQueueOfQueue(qoq1);

        Queue flatAfterReverse = qoq1.flat();
        System.out.print("\nqoq1 después de reverseWithDepth y flat: ");
        printQueue(flatAfterReverse);
        System.out.println();
    }

    private static void printQueue(Queue q) {
        Queue temp = new DynamicQueue();
        System.out.print("[ ");
        while (!q.isEmpty()) {
            int val = q.getFirst();
            System.out.print(val + " ");
            q.remove();
            temp.add(val);
        }
        System.out.print("]");

        while (!temp.isEmpty()) {
            q.add(temp.getFirst());
            temp.remove();
        }
    }

    private static void printQueueOfQueue(QueueOfQueue qoq) {
        QueueOfQueue tempQoq = new QueueOfQueue();
        System.out.println("{");
        while (!qoq.isEmpty()) {
            Queue frontQueue = qoq.getFirst();
            qoq.remove();

            System.out.print("  ");
            printQueue(frontQueue);
            System.out.println();

            tempQoq.add(frontQueue);
        }
        System.out.println("}");

        while (!tempQoq.isEmpty()) {
            qoq.add(tempQoq.getFirst());
            tempQoq.remove();
        }
    }
}