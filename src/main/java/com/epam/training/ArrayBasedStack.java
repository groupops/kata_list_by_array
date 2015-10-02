package com.epam.training;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

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
        checkIfNotEmpty();
        E removedElement = elements[capacity - 1];
        capacity--;
        elements[capacity] = null;
        return removedElement;
    }

    private void checkIfNotEmpty() {
        if (capacity == 0) {
            throw new NoSuchElementException("Stack is empty!");
        }
    }

    @Override
    public E peak() {
        checkIfNotEmpty();
        return elements[capacity - 1];
    }
}
