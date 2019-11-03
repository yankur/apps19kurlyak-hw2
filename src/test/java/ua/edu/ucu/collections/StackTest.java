package ua.edu.ucu.collections;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testPush() {
        Stack stack = new Stack();
        Object[] arr = new Object[] {"test1", "test2", "test3"};
        for (Object el : arr) {
            stack.push(el);
        }
        System.out.println(Arrays.toString(stack.toArray()));
        Object[] newArr = stack.toArray();
        Object[] expArr = new Object[] {"test1", "test2", "test3"};
        assertArrayEquals(newArr, expArr);
    }

    @Test
    public void testPeek() {
        Stack stack = new Stack();
        Object[] arr = new Object[] {"test1", "test2", "test3"};
        for (Object el : arr) {
            stack.push(el);
        }
        Object peek = stack.peek();
        Object expPeek = "test3";
        assertEquals(expPeek, peek);
    }

    @Test
    public void testPop() {
        Stack stack = new Stack();
        Object[] arr = new Object[] {"test1", "test2", "test3"};
        for (Object el : arr) {
            stack.push(el);
        }
        Object peek = stack.pop();
        Object expPeek = "test3";
        System.out.println(Arrays.toString(stack.toArray()));
        assertEquals(expPeek, peek);
    }
    
}
