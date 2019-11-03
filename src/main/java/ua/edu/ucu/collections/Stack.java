package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stack;

    public Stack() {
        stack = new ImmutableLinkedList();
    }

    Object peek() {
        if (stack.isEmpty()) {
            return new IndexOutOfBoundsException();
        }
        return stack.getFirst();
    }

    Object pop() {
        if (stack.isEmpty()) {
            return new IndexOutOfBoundsException();
        }
        Object res = stack.getFirst();
        stack = stack.removeFirst();
        return res;
    }

    void push(Object e) {
        stack = stack.addFirst(e);
    }

    Object[] toArray() {
        return stack.toArray();
    }
}
