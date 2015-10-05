package com.epam.training;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayBasedQueue<E> implements Queue<E> {
    private static final int DEFAULT_CAPACITY = 100;
    private static final int RESIZE_STEP = 100;
    private int capacity;
    private E[] elements;

    @SuppressWarnings("unchecked")
    public ArrayBasedQueue(Class<E> clazz) {
        elements = (E[]) Array.newInstance(clazz, DEFAULT_CAPACITY);
    }

    @Override
    public boolean add(E element) {
        resizeIfRequired();
        elements[capacity] = element;
        capacity++;
        return true;
    }

    private void resizeIfRequired() {
        if (elements.length == capacity) {
            elements = Arrays.copyOf(elements, capacity + RESIZE_STEP);
        }
    }

    @Override
    public E remove() {
        E removedElement = null;
        if (capacity > 0) {
            removedElement = elements[0];
            System.arraycopy(elements, 1, elements, 0, capacity - 1);
            capacity--;
            elements[capacity] = null;
        }
        return removedElement;
    }

    @Override
    public E element() {
        if (capacity > 0) {
            return elements[0];
        }
        return null;
    }
}
