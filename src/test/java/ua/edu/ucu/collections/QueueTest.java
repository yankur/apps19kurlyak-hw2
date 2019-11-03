package ua.edu.ucu.collections;

import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.ImmutableList;

import java.util.Arrays;

import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
    public void testEnqueue() {
        Queue queue = new Queue();
        Object[] arr = new Object[] {"test1", "test2", "test3"};
        for (Object el : arr) {
            queue.enqueue(el);
        }
        System.out.println(Arrays.toString(queue.toArray()));
        Object[] newArr = queue.toArray();
        Object[] expArr = new Object[] {"test1", "test2", "test3"};
        assertArrayEquals(newArr, expArr);
    }

    @Test
    public void testPeek() {
        Queue queue = new Queue();
        Object[] arr = new Object[] {"test1", "test2", "test3"};
        for (Object el : arr) {
            queue.enqueue(el);
        }
        Object peek = queue.peek();
        Object expPeek = "test1";
        assertEquals(expPeek, peek);
    }

    @Test
    public void testDequeue() {
        Queue queue = new Queue();
        Object[] arr = new Object[] {"test1", "test2", "test3"};
        for (Object el : arr) {
            queue.enqueue(el);
        }
        Object peek = queue.dequeue();
        Object expPeek = "test1";
        System.out.println(Arrays.toString(queue.toArray()));
        assertEquals(expPeek, peek);
    }

}
