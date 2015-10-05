package com.epam.training;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayBasedStack<E> implements Stack<E> {
    private static final int DEFAULT_CAPACITY = 100;
    private static final int RESIZE_STEP = 100;
    private E[] elements;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayBasedStack(Class<E> clazz) {
        elements = (E[]) Array.newInstance(clazz, DEFAULT_CAPACITY);
    }

    @Override
    public E push(E element) {
        resizeIfRequired();
        elements[capacity] = element;
        capacity++;
        return element;
    }

    private void resizeIfRequired() {
        if (capacity == elements.length) {
            elements = Arrays.copyOf(elements, capacity + RESIZE_STEP);
        }
    }

    @Override
    public E pop() {
        E elementToReturn = null;
        if (capacity > 0) {
            elementToReturn = elements[capacity - 1];
            capacity--;
            elements[capacity] = null;
        }
        return elementToReturn;
    }

    @Override
    public E peak() {
        if (capacity > 0) {
            return elements[capacity - 1];
        }
        return null;
    }
}
