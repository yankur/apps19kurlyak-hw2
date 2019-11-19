package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {
    private Node head;

        static class Node {
            Object data;
            Node next;
            Node(Object d) { data = d;}

            Node copy() {
                return new Node(data);
            }
        }

    public ImmutableLinkedList() {
           head = new Node(null);
    }

    public ImmutableLinkedList(Node h) {
            head = h;
    }

    private ImmutableLinkedList(Object[] arr) {
            ImmutableLinkedList immLinked = new ImmutableLinkedList();
            for (Object el : arr) {
                immLinked.add(el);
            }
    }

    private ImmutableLinkedList copyList() {
            Node newHead = head.copy();
            Node baseCurrent = head;
            Node newCurrent = newHead;
            while (baseCurrent.next != null) {
                newCurrent.next = baseCurrent.next.copy();
                baseCurrent = baseCurrent.next;
                newCurrent = newCurrent.next;
            }
            return new ImmutableLinkedList(newHead);
    }

    public ImmutableLinkedList addFirst(Object e) {
        Node newHead;
        if (head.data == null) {
            return new ImmutableLinkedList(new Node(e));
        } 
        else {
            newHead = new Node(e);
            ;
            newHead.next = head;
        }
        return new ImmutableLinkedList(newHead);
    }

    public ImmutableLinkedList addLast(Object e) {
        ImmutableLinkedList newImmL = copyList();
        Node newHead = newImmL.head;
        Node current = newHead;
        if (head.data == null) {
            return new ImmutableLinkedList(new Node(e));
        }
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(e);
        }
        return new ImmutableLinkedList(newHead);
    }

    @Override
    public ImmutableList add(Object e) {
            ImmutableLinkedList imml = new ImmutableLinkedList(head);
            return imml.addFirst(e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        if (head == null || index >= size()){
            throw new IllegalArgumentException();
        }
        ImmutableLinkedList immL = copyList();
        Node newHead = immL.head;
        Node current = immL.head;
        int count = 0;
        while (count != immL.size()-index-1) {
            current = current.next;
            count += 1;
        }
        Node temp = current.next;
        current.next = new Node(e);
        current = current.next;
        current.next = temp;

        return new ImmutableLinkedList(newHead);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        if (head.data == null) {
            return new ImmutableLinkedList(c);
        }
        ImmutableList newList = copyList();
        for (Object o : c) {
            newList = newList.add(o);
        }
        return newList;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (head == null || index >= size()){
            throw new IllegalArgumentException();
        }
        ImmutableLinkedList immL = copyList();
        Node newHead = immL.head;
        Node current = immL.head;
        int count = 0;
        while (count != immL.size()-index-1) {
            current = current.next;
            count += 1;
        }
        for (int i = c.length-1; i >= 0; i--) {
            Node temp = current.next;
            current.next = new Node(c[i]);
            current = current.next;
            current.next = temp;
        }
        return new ImmutableLinkedList(newHead);
    }

    @Override
    public Object get(int index) {
        if (head == null || index >= size()){
            throw new IllegalArgumentException();
        }
        Node current = head;
        int count = 0;
        while (count != size()-index-1) {
            current = current.next;
            count += 1;
        }
        return current.data;
    }

    public Object getFirst() {
        Node current = head;
        if (head.data == null) {
            throw new IllegalArgumentException();
        }
        else {
            while (current.next != null) {
                current = current.next;
            }
        }
        return current.data;
    }

    public Object getLast() {
        return head.data;
    }

    @Override
    public ImmutableList remove(int index) {
        if (head == null || index >= size()){
            throw new IllegalArgumentException();
        }
        ImmutableLinkedList immL = copyList();
        Node newHead = immL.head;
        Node current = immL.head;
        int count = 1;
        while (count != immL.size()-index-1) {
            current = current.next;
            count += 1;
        }
        current.next = current.next.next;

        return new ImmutableLinkedList(newHead);
    }

    public ImmutableLinkedList removeLast() {
        if (head == null){
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList immL = copyList();
        immL.head = immL.head.next;
        return immL;
    }

    public ImmutableLinkedList removeFirst() {
        if (head == null){
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList immL = copyList();
        Node current = immL.head;
        if (current.next == null) {return new ImmutableLinkedList();}
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        return immL;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (head == null || index >= size()){
            throw new IllegalArgumentException();
        }
        ImmutableLinkedList immL = copyList();
        Node newHead = immL.head;
        Node current = immL.head;
        int count = 0;
        while (count != immL.size()-index-1) {
            current = current.next;
            count += 1;
        }
        current.data = e;

        return new ImmutableLinkedList(newHead);
    }

    @Override
    public int indexOf(Object e) {
        Node current = head;
        int count = 0;
        while (count <= size()-1) {
            if (current.data.equals(e)) {
                return size() - count - 1;
            }
            current = current.next;
            count += 1;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int size() {
        if (head.data == null) {return 0;}
        Node current  = head;
        int count = 1;
        while (current.next != null) {
                count += 1;
                current = current.next;
            }
        return count;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return  head.data == null;
    }

    @Override
    public Object[] toArray() {
        Object[] newArr;
        if (head.data == null){
            return new Object[]{};
        }
        else {
            Node current = head;
            Object[] arr = new Object[size()];
            arr[0] = current.data;
            while (current.next != null) {
                current = current.next;
                newArr = new Object[size()];
                newArr[0] = current.data;
                System.arraycopy(arr, 0, newArr, 1, arr.length-1);
                arr = newArr;
            }
            return arr;
        }
    }

    @Override
    public String toString() {
        StringBuffer temp = new StringBuffer();
        Node current = head;

        if (current.data == null) { return "{}"; } 
        else {
            temp.append("}");
            temp.append(current.data.toString());
            temp.append(" ,");
        }

        current = current.next;
        while (current.next != null) {
            temp.append(current.data.toString());
            temp.append(" ,");
            current = current.next;
        }
        temp.append(current.data.toString());
        temp.append("{");

        temp.reverse();
        return temp.toString();
    }
}
