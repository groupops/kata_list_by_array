package com.epam.adambronowicki;

import java.lang.reflect.Array;

public class ArrayBasedStack<E> implements Stack<E> {

  private E[] internalStack;
  private Class<E> genericClassOfE;
  private int indexOfLastElement = -1;

  public ArrayBasedStack(Class<E> genericClassOfE, int capacity) {
    this.genericClassOfE = genericClassOfE;
    internalStack = (E[]) Array.newInstance(genericClassOfE, capacity);
  }

  @Override
  public void push(E item) {
    indexOfLastElement++;
    if (indexOfLastElement >= internalStack.length) {
      resizeInternalArray(indexOfLastElement + 1);
    }
    internalStack[indexOfLastElement] = item;
  }

  private void resizeInternalArray(int newCapacity) {
    E[] tempInternalStack = (E[]) Array.newInstance(genericClassOfE, newCapacity);
    System.arraycopy(internalStack, 0, tempInternalStack, 0,
        internalStack.length);
    this.internalStack = tempInternalStack;
  }

  @Override
  public E pop() {
    E poppedItem = null;
    // if the stack is not empty
    if (indexOfLastElement > -1) {
      // get the last added element
      poppedItem = internalStack[indexOfLastElement];
      // then remove the element
      internalStack[indexOfLastElement] = null;
      indexOfLastElement--;
    }
    return poppedItem;
  }


  @Override
  public E peek() {
    E peekedItem = null;
    // if stack is not empty then return the top most element
    if (indexOfLastElement > -1) {
      peekedItem = internalStack[indexOfLastElement];
    }
    // otherwise return null
    return peekedItem;
  }

}
