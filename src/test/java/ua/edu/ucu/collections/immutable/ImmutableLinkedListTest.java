package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    
    @Test
    public void testAdd() {
        int e = 7;
        Object[] arr = new Object[] {"test1", "test2", "test3"};
        ImmutableList baseList = new ImmutableLinkedList();
        ImmutableList newList = baseList.add(e);
        for (Object el : arr) {
            newList = newList.add(el);
        }
        System.out.println(Arrays.toString(newList.toArray()));
        Object[] newArr = newList.toArray();
        Object[] expArr = new Object[] { 7,"test1", "test2", "test3"};
        assertArrayEquals(newArr, expArr);
    }

    @Test
    public void testAddIndex() {
        int e = 7;
        Object[] arr = new Object[] {"test1", "test2", "test3"};
        ImmutableList baseList = new ImmutableLinkedList();
        ImmutableList newList = baseList.add(e);
        for (Object el : arr) {
            newList = newList.add(el);
        }
        newList = newList.add(2, "TEST");
        System.out.println(Arrays.toString(newList.toArray()));
        Object[] newArr = newList.toArray();
        Object[] expArr = new Object[] { 7,"test1", "TEST", "test2", "test3"};
        assertArrayEquals(newArr, expArr);
    }

    @Test
    public void testAddAll() {
        int e = 7;
        Object[] arr = new Object[] {"test1", "test2", "test3"};
        Object[] addArr = new Object[] {"TEST1", "TEST2"};
        ImmutableList baseList = new ImmutableLinkedList();
        ImmutableList newList = baseList.add(e);
        for (Object el : arr) {
            newList = newList.add(el);
        }
        newList = newList.addAll(addArr);
        System.out.println(Arrays.toString(newList.toArray()));
        Object[] newArr = newList.toArray();
        Object[] expArr = new Object[] { 7,"test1", "test2", "test3", "TEST1", "TEST2"};
        assertArrayEquals(newArr, expArr);
    }

    @Test
    public void testAddAllIndex() {
        int e = 7;
        Object[] arr = new Object[] {"test1", "test2", "test3"};
        Object[] addArr = new Object[] {"TEST1", "TEST2"};
        ImmutableList baseList = new ImmutableLinkedList();
        ImmutableList newList = baseList.add(e);
        for (Object el : arr) {
            newList = newList.add(el);
        }
        newList = newList.addAll(2, addArr);
        System.out.println(Arrays.toString(newList.toArray()));
        Object[] newArr = newList.toArray();
        Object[] expArr = new Object[] { 7,"test1", "TEST1", "TEST2", "test2", "test3"};
        assertArrayEquals(newArr, expArr);
    }

    @Test
    public void testGet() {
        int e = 7;
        Object[] arr = new Object[] {"test1", "test2", "test3"};
        Object[] addArr = new Object[] {"TEST1", "TEST2"};
        ImmutableList baseList = new ImmutableLinkedList();
        ImmutableList newList = baseList.add(e);
        for (Object el : arr) {
            newList = newList.add(el);
        }
        Object o = newList.get(1);
        System.out.println(o);
        assertEquals("test1", o);
    }

    @Test
    public void testRemove() {
        int e = 7;
        Object[] arr = new Object[] {"test1", "test2", "test3"};
        ImmutableList baseList = new ImmutableLinkedList();
        ImmutableList newList = baseList.add(e);
        for (Object el : arr) {
            newList = newList.add(el);
        }
        newList = newList.remove(2);
        System.out.println(Arrays.toString(newList.toArray()));
        Object[] newArr = newList.toArray();
        Object[] expArr = new Object[] { 7,"test1", "test3"};
        assertArrayEquals(newArr, expArr);
    }

    @Test
    public void testSet() {
        int e = 7;
        Object[] arr = new Object[] {"test1", "test2", "test3"};
        Object setVal = "TEST";
        ImmutableList baseList = new ImmutableLinkedList();
        ImmutableList newList = baseList.add(e);
        for (Object el : arr) {
            newList = newList.add(el);
        }
        newList = newList.set(2, setVal);
        System.out.println(Arrays.toString(newList.toArray()));
        Object[] newArr = newList.toArray();
        Object[] expArr = new Object[] { 7, "test1", "TEST", "test3"};
        assertArrayEquals(newArr, expArr);
    }

    @Test
    public void testIndexOf() {
        int e = 7;
        Object[] arr = new Object[] {"test1", "test2", "test3"};
        Object findVal = "test2";
        ImmutableList baseList = new ImmutableLinkedList();
        ImmutableList newList = baseList.add(e);
        for (Object el : arr) {
            newList = newList.add(el);
        }
        int index = newList.indexOf(findVal);
        System.out.println(index);
        assertEquals(2, index);
    }



    
}
