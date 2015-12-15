package com.epam.adambronowicki;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayBasedStack<E> implements Stack<E> {

    private E[] internalStack;
    private int indexOfLastElement = -1;

    @SuppressWarnings("unchecked")
    public ArrayBasedStack() {
        int capacity = 10;
        internalStack = (E[]) Array.newInstance(Object.class, capacity);
    }

    @Override
    public void push(E item) {
        indexOfLastElement++;
        if (indexOfLastElement >= internalStack.length) {
            resizeInternalArray(indexOfLastElement * 2);
        }
        internalStack[indexOfLastElement] = item;
    }

    @SuppressWarnings("unchecked")
    private void resizeInternalArray(int newCapacity) {
        E[] tempInternalStack =
                (E[]) Array.newInstance(Object.class, newCapacity);
        System.arraycopy(internalStack, 0, tempInternalStack, 0,
                indexOfLastElement);
        this.internalStack = tempInternalStack;
    }

    @Override
    public E pop() {
        E poppedItem = null;
        if (indexOfLastElement > -1) {
            poppedItem = internalStack[indexOfLastElement];
            internalStack[indexOfLastElement] = null;
            if (indexOfLastElement * 2 < internalStack.length) {
                resizeInternalArray(internalStack.length / 2);
            }
            indexOfLastElement--;
        }
        return poppedItem;
    }


    @Override
    public E peek() {
        E peekedItem = null;
        if (indexOfLastElement > -1) {
            peekedItem = internalStack[indexOfLastElement];
        }
        return peekedItem;
    }

    @Override
    public int size() {
        return indexOfLastElement + 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(internalStack);
    }
}
