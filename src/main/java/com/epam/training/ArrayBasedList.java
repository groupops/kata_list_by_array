package com.epam.training;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * List which is based on Array
 */
public class ArrayBasedList<T> implements List<T> {
    private static final int DEFAULT_LIST_SIZE = 100;
    private static final int RESIZING_STEP = 100;
    private T[] array;
    private int capacity;


    @SuppressWarnings("unchecked")
    public ArrayBasedList(Class<T> instanceClass) {
        array = (T[]) Array.newInstance(instanceClass, DEFAULT_LIST_SIZE);
    }

    @SuppressWarnings("unchecked")
    public ArrayBasedList(Class<T> instanceClass, int initialCapacity) {
        if (initialCapacity >= 0) {
            array = (T[]) Array.newInstance(instanceClass, initialCapacity);
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

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newArray = (T[]) Array.newInstance(array.getClass(), capacity + RESIZING_STEP);
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public T get(int index) {
        checkCapacity(index);
        return array[index];
    }

    @Override
    public T remove(int index) {
        checkCapacity(index);
        T elementToBeRemoved =  array[index];
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
    public boolean contains(T item) {
        return item != null && Arrays.stream(array).anyMatch(item::equals);
    }
}
