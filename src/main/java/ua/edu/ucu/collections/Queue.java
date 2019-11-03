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
        return stack.getLast();
    }

    Object pop() {
        if (stack.isEmpty()) {
            return new IndexOutOfBoundsException();
        }
        Object res = stack.getLast();
        stack = stack.removeLast();
        return res;
    }

    void push(Object e) {
        stack = stack.addLast(e);
    }

    Object[] toArray() {
        return stack.toArray();
    }
}
