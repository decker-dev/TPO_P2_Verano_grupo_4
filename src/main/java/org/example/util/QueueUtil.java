package org.example.util;

import org.example.model.PriorityQueue;
import org.example.model.Queue;
import org.example.model.StaticPriorityQueue;
import org.example.model.StaticQueue;

public class QueueUtil {

    private QueueUtil() {

    }

    public static PriorityQueue phi() {
        PriorityQueue priorityQueue = new StaticPriorityQueue();

        int[] fibArray = new int[100];

        fibArray[0] = 1;
        fibArray[1] = 2;

        for(int i = 2; i < 100; i++) {
            priorityQueue.add(fibArray[i-2], fibArray[i-1]);
            fibArray[i] = fibArray[i-1] + fibArray[i-2];
        }

        System.out.println(fibArray[99] / (double) fibArray[98]);

        return priorityQueue;

    }

    public static Queue copy(Queue queue) {
        Queue aux = new StaticQueue();
        Queue aux2 = new StaticQueue();

        while (!queue.isEmpty()) {
            aux.add(queue.getFirst());
            aux2.add(queue.getFirst());
            queue.remove();
        }

        while (!aux2.isEmpty()) {
            queue.add(aux2.getFirst());
            aux2.remove();
        }

        return aux;
    }

}
