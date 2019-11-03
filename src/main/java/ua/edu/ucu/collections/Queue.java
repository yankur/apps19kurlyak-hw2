package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList queue;

    public Queue() {
        queue = new ImmutableLinkedList();
    }

    Object peek() {
        if (queue.isEmpty()) {
            return new IndexOutOfBoundsException();
        }
        return queue.getFirst();
    }

    Object dequeue() {
        if (queue.isEmpty()) {
            return new IndexOutOfBoundsException();
        }
        Object res = queue.getFirst();
        queue = queue.removeFirst();
        return res;
    }

    void enqueue(Object e) {
        queue = queue.addFirst(e);
    }

    Object[] toArray() {
        return queue.toArray();
    }
}
