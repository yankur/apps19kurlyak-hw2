package ua.edu.ucu.collections.immutable;
import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {

    private Object[] arr;
    private int size;

    public ImmutableArrayList() {
        arr = new Object[]{};
    }

    public ImmutableArrayList(Object[] newArr) {
        if (newArr.length == 0) {
            throw new IllegalArgumentException();
        }
        arr = Arrays.copyOf(newArr, newArr.length);
        size = arr.length;
    }

    @Override
    public ImmutableList add(Object e) {
        size += 1;
        Object[] newArr = Arrays.copyOf(arr, size);
        newArr[size-1] = e;
        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        if (size == 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newArr = new Object[size+1];

        System.arraycopy(arr, 0, newArr, 0, index);
        newArr[index] = e;
        System.arraycopy(arr, index, newArr, index+1, size-index);

        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        int sizeC = c.length;
        Object[] newArr = new Object[size+sizeC];

        if (size > 0 && sizeC > 0) {
            System.arraycopy(arr, 0, newArr, 0, size);
            System.arraycopy(c, 0, newArr, size, sizeC);
        }
        else if (size > 0 && sizeC == 0) {
            newArr = Arrays.copyOf(arr, size);
        }
        else if (size == 0 && sizeC > 0){
            newArr = Arrays.copyOf(c, sizeC);
        }
        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (size == 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int sizeC = c.length;
        Object[] newArr = new Object[size+sizeC];

        System.arraycopy(arr, 0, newArr, 0, index);
        System.arraycopy(c, 0, newArr, index, sizeC);
        System.arraycopy(arr, index, newArr, sizeC+index, size-index);

        return new ImmutableArrayList(newArr);
    }

    @Override
    public Object get(int index) {
        if (size == 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (size == 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newArr = new Object[size-1];

        System.arraycopy(arr, 0, newArr, 0, index);
        System.arraycopy(arr, index+1, newArr, index, size-index-1);

        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (size == 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newArr = new Object[size];

        System.arraycopy(arr, 0, newArr, 0, index);
        newArr[index] = e;
        System.arraycopy(arr, index+1, newArr, index+1, size-index-1);

        return new ImmutableArrayList(newArr);
    }

    @Override
    public int indexOf(Object e) {
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (e.equals(arr[i])) {
                    return i;
                }
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        if (size != 0){
            return Arrays.copyOf(arr, size);
        }
        return new Object[]{};
    }

    @Override
    public String toString() {
        String output = "{";
        output += arr[0].toString();
        for (int i = 1; i < size; i++) {
            output += ", " + arr[i].toString();
        }
        output += "}";
        return output;
    }
}
