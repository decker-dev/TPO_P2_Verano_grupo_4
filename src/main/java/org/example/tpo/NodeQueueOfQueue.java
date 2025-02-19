package org.example.tpo;

import org.example.model.Queue;

public class NodeQueueOfQueue {
    private Queue queue;
    private NodeQueueOfQueue next;

    public NodeQueueOfQueue(Queue queue, NodeQueueOfQueue next) {
        this.queue = queue;
        this.next = next;
    }

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public NodeQueueOfQueue getNext() {
        return next;
    }

    public void setNext(NodeQueueOfQueue next) {
        this.next = next;
    }
}