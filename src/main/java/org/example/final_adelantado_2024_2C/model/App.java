package org.example.final_adelantado_2024_2C.model;

import org.example.final_adelantado_2024_2C.nodes.Node;

public class App {
    public static void main(String[] args) {
        DynamicQueue queue = new DynamicQueue();

        // Almacenamos los números del 1 al 100 en la cola
        for (int i = 1; i <= 100; i++) {
            queue.add(i);
        }

        // Marcamos los elementos que pertenecen a la secuencia de Fibonacci
        queue.markFibonacci();

        // Imprimimos la cola mostrando qué elementos están marcados
        Node current = queue.getFirstNode();
        while (current != null) {
            System.out.println("Valor: " + current.getValue() + (current.isMarked() ? " (Fibonacci)" : ""));
            current = current.getNext();
        }
    }
}