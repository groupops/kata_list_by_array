package com.epam.adambronowicki;

import java.lang.reflect.Array;

public class ArrayBasedQueue<E> implements Queue<E> {

  private E[] internalQueue;
  private Class<E> genericClassOfE;
  private int indexOfLastElement = -1;

  public ArrayBasedQueue(Class<E> genericClassOfE, int capacity) {
    this.genericClassOfE = genericClassOfE;
    internalQueue = (E[]) Array.newInstance(genericClassOfE, capacity);
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
    for (int i = 0; i < indexOfLastElement; i++) {
      internalQueue[i] = internalQueue[i + 1];
    }
    if (indexOfLastElement / 2 <= internalQueue.length) {
      resizeInternalQueue(indexOfLastElement / 2);
    }
    return item;
  }

  @Override
  public E element() {
    return internalQueue[0];
  }

  private void resizeInternalQueue(int newCapacity) {
    E[] tempInternalStack =
        (E[]) Array.newInstance(genericClassOfE, newCapacity);
    System.arraycopy(internalQueue, 0, tempInternalStack, 0,
        internalQueue.length);
    this.internalQueue = tempInternalStack;
  }

}
