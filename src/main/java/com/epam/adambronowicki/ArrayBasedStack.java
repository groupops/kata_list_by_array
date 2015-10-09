package com.epam.adambronowicki;

import java.lang.reflect.Array;
import java.util.Arrays;

public final class ArrayBasedStack<Item> implements Stack<Item> {

    private Item[] internalStack;
    private int indexOfLastElement = -1;

    @SuppressWarnings("unchecked")
    public ArrayBasedStack(final Class<Item> genericClassOfItem) {
        checkClassForNull(genericClassOfItem);
        int capacity = 10;
        internalStack = (Item[]) Array.newInstance(genericClassOfItem, capacity);
    }

    private void checkClassForNull(final Class<Item> genericClassOfItem) {
        if (genericClassOfItem == null) {
            throw new IllegalArgumentException(
                    "The type of item stored in stack cannot be empty");
        }
    }

    @Override
    public Item push(final Item item) {
        checkForNull(item);
        increaseIfRequired();
        indexOfLastElement++;
        internalStack[indexOfLastElement] = item;
        return item;
    }

    private void checkForNull(final Item item) throws IllegalArgumentException {
        if (item == null) {
            throw new IllegalArgumentException(
                    "The item passed to method cannot be empty");
        }
    }

    private void increaseIfRequired() {
        if (size() == internalStack.length) {
            resizeInternalArray(indexOfLastElement * 2);
        }
    }

    @SuppressWarnings("unchecked")
    private void resizeInternalArray(final int newCapacity) {
        internalStack = Arrays.copyOf(internalStack, newCapacity);
    }

    @Override
    public Item pop() {
        Item poppedItem = null;
        if (indexOfLastElement >= 0) {
            decreaseIfRequired();
            poppedItem = internalStack[indexOfLastElement];
            internalStack[indexOfLastElement] = null;
            indexOfLastElement--;
        }
        return poppedItem;
    }

    private void decreaseIfRequired() {
        if (size() * 2 < internalStack.length) {
            resizeInternalArray(size());
        }
    }

    @Override
    public Item peek() {
        Item peekedItem = null;
        if (indexOfLastElement >= 0) {
            peekedItem = internalStack[indexOfLastElement];
        }
        return peekedItem;
    }

    @Override
    public int size() {
        return indexOfLastElement + 1;
    }

}
