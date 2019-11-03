package ua.edu.ucu.collections.immutable;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    @Test
    public void testAddNoArguments() {
        ImmutableList immArr = new ImmutableArrayList();
        ImmutableList FinalArr = immArr.add(5);
        Object[] expArr = new Object[] {5};
        assertArrayEquals(FinalArr.toArray(), expArr);
    }

    @Test
    public void testAddWithArguments() {
        Object[] arr = new Object[] {1, 2, 3, 4, 5};
        ImmutableList immArr = new ImmutableArrayList(arr);
        ImmutableList FinalArr = immArr.add(6);
        Object[] expArr = new Object[] {1, 2, 3, 4, 5, 6};
        assertArrayEquals(FinalArr.toArray(), expArr);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexNoArguments(){
        ImmutableList immArr = new ImmutableArrayList();
        immArr.add(6, 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexWithArgumentsOutOfRange(){
        Object[] arr = new Object[] {1, 2, 3, 4, 5};
        ImmutableList immArr = new ImmutableArrayList(arr);
        immArr.add(10, 6);
    }

    @Test
    public void testAddIndexWithArguments() {
        Object[] arr = new Object[] {1, 2, 3, 4, 5};
        ImmutableList immArr = new ImmutableArrayList(arr);
        ImmutableList FinalArr = immArr.add(3, "test");
        Object[] expArr = new Object[] {1, 2, 3, "test", 4, 5};
        assertArrayEquals(FinalArr.toArray(), expArr);
    }

    @Test
    public void testAddAllNoArguments() {
        Object[] addArr = new Object[] {"test1", "test2", "test3"};
        ImmutableList immArr = new ImmutableArrayList();
        ImmutableList FinalArr = immArr.addAll(addArr);
        Object[] expArr = new Object[] {"test1", "test2", "test3"};
        assertArrayEquals(FinalArr.toArray(), expArr);
    }

    @Test
    public void testAddAllWithArgumentsEmptyList() {
        Object[] arr = new Object[] {1, 2, 3, 4, 5};
        Object[] addArr = new Object[0];
        ImmutableList immArr = new ImmutableArrayList(arr);
        ImmutableList FinalArr = immArr.addAll(addArr);
        Object[] expArr = new Object[] {1, 2, 3, 4, 5};
        assertArrayEquals(FinalArr.toArray(), expArr);
    }

    @Test
    public void testAddAllWithArguments() {
        Object[] arr = new Object[] {1, 2, 3, 4, 5};
        Object[] addArr = new Object[] {"test1", "test2", "test3"};
        ImmutableList immArr = new ImmutableArrayList(arr);
        ImmutableList FinalArr = immArr.addAll(addArr);
        Object[] expArr = new Object[] {1, 2, 3, 4, 5, "test1", "test2", "test3"};
        assertArrayEquals(FinalArr.toArray(), expArr);
    }

    @Test
    public void testAddAllIndexWithArguments() {
        Object[] arr = new Object[] {1, 2, 3, 4, 5};
        Object[] addArr = new Object[] {"test1", "test2", "test3"};
        ImmutableList immArr = new ImmutableArrayList(arr);
        ImmutableList FinalArr = immArr.addAll(2, addArr);
        System.out.println(Arrays.toString(FinalArr.toArray()));
        Object[] expArr = new Object[] {1, 2, "test1", "test2", "test3", 3, 4, 5};
        assertArrayEquals(FinalArr.toArray(), expArr);
    }

    @Test
    public void testGetWithArguments() {
        Object[] arr = new Object[] {1, 2, "TEST", 4, 5};
        ImmutableList immArr = new ImmutableArrayList(arr);
        Object findVal = immArr.get(2);
        System.out.println(findVal);
        Object expVal = "TEST";
        assertEquals(expVal, findVal);
    }

    @Test
    public void testRemoveWithArguments() {
        Object[] arr = new Object[] {1, 2, 3, 4, 5};
        ImmutableList immArr = new ImmutableArrayList(arr);
        ImmutableList FinalArr = immArr.remove(2);
        System.out.println(Arrays.toString(FinalArr.toArray()));
        Object[] expArr = new Object[] {1, 2, 4, 5};
        assertArrayEquals(FinalArr.toArray(), expArr);
    }

    @Test
    public void testSetWithArguments() {
        Object[] arr = new Object[] {1, 2, 3, 4, 5};
        Object setVal;
        ImmutableList immArr = new ImmutableArrayList(arr);
        ImmutableList FinalArr = immArr.set(2, "TEST");
        System.out.println(Arrays.toString(FinalArr.toArray()));
        Object[] expArr = new Object[] {1, 2, "TEST", 4, 5};
        assertArrayEquals(FinalArr.toArray(), expArr);
    }

    @Test
    public void testIndexOfWithArguments() {
        Object[] arr = new Object[] {1, 2, "TEST", 4, 5};
        ImmutableList immArr = new ImmutableArrayList(arr);
        int index = immArr.indexOf("TEST");
        System.out.println(index);
        int expInd = 2;
        assertEquals(expInd, index);
    }

}

