package my_solution;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {

    private Object[] arr;
    private int length = 0;
    private int capacity = 3;

    public MyArrayList() {
        arr = new Object[capacity];
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(T item) {
        if (length == capacity)
            increaseCapacity();

        arr[length++] = item;
    }

    @Override
    public void add(T item, int index) {
        if (index == length) {
            add(item);
            return;
        }
        if (length == capacity)
            increaseCapacity();

        for (int i = length - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = item;
        length++;
    }

    @Override
    public boolean remove(T item) {
        int index = indexOf(item);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        Object o = arr[index];
        for (int i = index; i < length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        length--;
        return (T) o;
    }

    @Override
    public void clear() {
        length = 0;
    }

    @Override
    public T get(int index) {
        return (T) arr[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < length; i++) {
            if (o.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = length - 1; i >= 0; i--) {
            if (o.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort() {
        Object temp;
        if (!(arr[0] instanceof Comparable)) {
            return;
        }
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (((Comparable) arr[i]).compareTo(arr[j]) > 0) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "arr=" + Arrays.toString(arr) +
                ", length=" + length +
                ", capacity=" + capacity +
                '}';
    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] old = arr;
        arr = new Object[capacity];

        for (int i = 0; i < old.length; i++)
            arr[i] = old[i];
    }

}
