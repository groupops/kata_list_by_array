package com.epam.adambronowicki;

import java.lang.reflect.Array;

public class ArrayBasedQueue<E> implements Queue<E> {

    private E[] internalQueue;
    private int indexOfLastElement = -1;

    @SuppressWarnings("unchecked")
    public ArrayBasedQueue(int capacity) {
        internalQueue = (E[]) Array.newInstance(Object.class, capacity);
    }


    @Override
    public void add(E item) {
        indexOfLastElement++;
        if (indexOfLastElement >= internalQueue.length) {
            resizeInternalQueue(indexOfLastElement * 2);
        }
        internalQueue[indexOfLastElement] = item;
    }

    @Override
    public E remove() {
        E item = internalQueue[0];
        System.arraycopy(internalQueue, 1, internalQueue, 0, indexOfLastElement);
        indexOfLastElement--;
        if (indexOfLastElement * 2 < internalQueue.length) {
            resizeInternalQueue(internalQueue.length / 2);
        }
        return item;
    }

    @Override
    public E element() {
        return internalQueue[0];
    }

    @SuppressWarnings("unchecked")
    private void resizeInternalQueue(int newCapacity) {
        E[] tempInternalStack =
                (E[]) Array.newInstance(Object.class, newCapacity);
        System.arraycopy(internalQueue, 0, tempInternalStack, 0,
                indexOfLastElement);
        this.internalQueue = tempInternalStack;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");

        for (int i = 0; i < indexOfLastElement + 1; i++) {
            stringBuilder.append(internalQueue[i].toString());
            if (i < indexOfLastElement)
                stringBuilder.append(", ");
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    public int size() {
        return indexOfLastElement + 1;
    }

}
