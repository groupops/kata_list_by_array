package com.epam.training;

import java.util.Arrays;

/**
 * List which is based on Array
 */
public class ArrayBasedList<T> implements List<T> {
    private static final Object[] DEFAULT_LIST = new Object[10];
    private Object[] array;
    private int capacity;


    public ArrayBasedList() {
        array = DEFAULT_LIST;
    }

    public ArrayBasedList(int initialCapacity) {
        if (initialCapacity > 0) {
            array = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            array = DEFAULT_LIST;
        } else {
            throw new IllegalArgumentException("Initial size can't be less then 0");
        }
    }

    @Override
    public void add(T item) {
        int currentArrayLength = array.length;
        if (currentArrayLength == capacity) {
            resize();
        }
        array[capacity] = item;
        capacity++;
    }

    private void resize() {
        Object[] newArray = new Object[capacity + 10];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkCapacity(index);
        return (T) array[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        checkCapacity(index);
        T elementToBeRemoved = (T) array[index];
        if (index != capacity) {
            System.arraycopy(array, index + 1, array, index, capacity - index - 1);
        }
        array[capacity - 1] = null;
        capacity--;
        return elementToBeRemoved;
    }

    private void checkCapacity(int index) {
        if (index > capacity - 1) {
            throw new IndexOutOfBoundsException("Actual size of list is " + capacity);
        }
    }

    @Override
    public Boolean contains(T item) {
        return Arrays.binarySearch(array, item) > -1;
    }
}
