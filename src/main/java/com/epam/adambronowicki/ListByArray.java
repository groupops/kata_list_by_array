package com.epam.adambronowicki;

import java.lang.reflect.Array;

public class ListByArray<T> implements List<T> {

  private T[] array;
  private int numberOfItems = 0;

  public ListByArray(Class<T> choosenClass, int initialCapacity) {
    if (initialCapacity >= 0) {
      array = (T[]) Array.newInstance(choosenClass, initialCapacity);
    } else {
      throw new IllegalArgumentException("Initial size cannot be less than 0");
    }
  }

  @Override
  public void add(T item) {
    if (numberOfItems == array.length) {
      T[] newArray =
          (T[]) Array.newInstance(array.getClass(), array.length * 2);
      System.arraycopy(array, 0, newArray, 0, array.length);
    } else {
      array[numberOfItems] = item;
    }
    numberOfItems++;
  }

  @Override
  public T get(int index) {
    checkCapacity(index);
    return array[index];
  }

  @Override
  public T remove(int index) throws IndexOutOfBoundsException {
    checkCapacity(index);
    T item = array[index];
    for (int i = index; i < numberOfItems; i++) {
      if (i == array.length - 1) {
        array[i] = null;
      } else {
        array[i] = array[i + 1];
      }
    }
    return item;
  }

  @Override
  public boolean contains(T item) {
    for (int i = 0; i < numberOfItems; i++) {
      if (array[i].equals(item)) {
        return true;
      }
    }
    return false;
  }

  private void checkCapacity(int index) {
    if (index > numberOfItems - 1 || index < 0) {
      throw new IndexOutOfBoundsException("Given index exceeds current array.");
    }
  }

}
