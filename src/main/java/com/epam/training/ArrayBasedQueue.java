package com.epam.training;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

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
        checkIfNotEmpty();
        E removedElement = elements[0];
        System.arraycopy(elements, 1, elements, 0, capacity - 1);
        capacity--;
        elements[capacity] = null;
        return removedElement;
    }

    private void checkIfNotEmpty() {
        if (capacity == 0) {
            throw new NoSuchElementException("Queue is empty!");
        }
    }

    @Override
    public E element() {
        checkIfNotEmpty();
        return elements[0];
    }
}
