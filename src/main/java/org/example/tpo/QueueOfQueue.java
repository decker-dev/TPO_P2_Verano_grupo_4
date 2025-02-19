package org.example.tpo;

import org.example.model.DynamicQueue;
import org.example.model.Queue;

public class QueueOfQueue {

    private NodeQueueOfQueue first;

    public QueueOfQueue() {
        this.first = null;
    }

    /**
     * Agrega un nuevo Queue al final de la QueueOfQueue.
     */
    public void add(Queue q) {
        if (this.first == null) {
            this.first = new NodeQueueOfQueue(q, null);
            return;
        }
        NodeQueueOfQueue candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
        }
        candidate.setNext(new NodeQueueOfQueue(q, null));
    }

    /**
     * Elimina el primer Queue (el del frente) de la QueueOfQueue.
     */
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar de una QueueOfQueue vacía");
        }
        this.first = this.first.getNext();
    }

    /**
     * Devuelve true si no hay ningún Queue almacenado.
     */
    public boolean isEmpty() {
        return this.first == null;
    }

    /**
     * Devuelve el primer Queue (el del frente) sin removerlo.
     */
    public Queue getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una QueueOfQueue vacía");
        }
        return this.first.getQueue();
    }

    // ------------------------------------------------------------------------
    // 1) concatenate
    // ------------------------------------------------------------------------
    /**
     * Recibe n instancias de QueueOfQueue y retorna una nueva instancia
     * que contenga TODOS los Queue internos de la actual + los de cada
     * QueueOfQueue pasada como parámetro, en orden.
     */
    public QueueOfQueue concatenate(QueueOfQueue... others) {
        QueueOfQueue result = new QueueOfQueue();

        // 1) Copiamos los Queue de "this"
        NodeQueueOfQueue candidate = this.first;
        while (candidate != null) {
            result.add(candidate.getQueue());
            candidate = candidate.getNext();
        }

        // 2) Copiamos los Queue de cada una de las "others"
        for (QueueOfQueue other : others) {
            NodeQueueOfQueue otherCandidate = other.first;
            while (otherCandidate != null) {
                result.add(otherCandidate.getQueue());
                otherCandidate = otherCandidate.getNext();
            }
        }

        return result;
    }

    // ------------------------------------------------------------------------
    // 2) flat
    // ------------------------------------------------------------------------
    /**
     * Crea y retorna una sola Queue (de int) con todos los elementos
     * de todos los Queue internos, en el mismo orden que estaban.
     */
    public Queue flat() {
        // Puedes elegir si devolver una StaticQueue o una DynamicQueue,
        // según prefieras.
        Queue result = new DynamicQueue();

        NodeQueueOfQueue candidate = this.first;
        while (candidate != null) {
            Queue internalQueue = candidate.getQueue();

            // Para leer los elementos sin destruir la cola original,
            // usaremos una cola temporal que nos permita restaurar
            // después. De lo contrario, si removemos todo de internalQueue,
            // la dejamos vacía.
            Queue temp = new DynamicQueue();

            // Extraemos todos los elementos de internalQueue
            while (!internalQueue.isEmpty()) {
                int value = internalQueue.getFirst();
                internalQueue.remove();

                // Agrego a la result
                result.add(value);
                // Guardo también en temp para poder restaurar
                temp.add(value);
            }

            // Restauramos el internalQueue
            while (!temp.isEmpty()) {
                int value = temp.getFirst();
                temp.remove();
                internalQueue.add(value);
            }

            candidate = candidate.getNext();
        }

        return result;
    }

    // ------------------------------------------------------------------------
    // 3) reverseWithDepth
    // ------------------------------------------------------------------------
    /**
     * Invierte la QueueOfQueue (el orden de sus Queue internos)
     * y también invierte cada Queue interno.
     */
    public void reverseWithDepth() {
        // Primero invertimos la lista enlazada de NodeQueueOfQueue
        NodeQueueOfQueue prev = null;
        NodeQueueOfQueue current = this.first;
        while (current != null) {
            NodeQueueOfQueue next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        this.first = prev;

        // Luego invertimos cada cola interna
        NodeQueueOfQueue candidate = this.first;
        while (candidate != null) {
            reverseSingleQueue(candidate.getQueue());
            candidate = candidate.getNext();
        }
    }

    /**
     * Función auxiliar recursiva para invertir una Queue "in-place"
     * usando sólo los métodos getFirst(), remove() y add().
     */
    private void reverseSingleQueue(Queue q) {
        if (q.isEmpty()) {
            return;
        }
        int first = q.getFirst();
        q.remove();
        // Llamado recursivo que va sacando todos los elementos
        // hasta vaciar la cola, y al volver de la recursión
        // los va reinsertando al final, quedando en orden inverso.
        reverseSingleQueue(q);
        q.add(first);
    }
}