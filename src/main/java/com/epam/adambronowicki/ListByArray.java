package com.epam.adambronowicki;

import java.lang.reflect.Array;

public final class ListByArray<TItem> implements List<TItem> {

  private TItem[] array;
  private final int initialCapacity = 10;
  private int size = 0;

  public ListByArray(Class<TItem> choosenClass) {
    array = (TItem[]) Array.newInstance(choosenClass, initialCapacity);
  }

  @Override
  public void add(TItem item) {
    checkForNull(item);
    if (size == array.length) {
      enlargeList();
    } else {
      array[size] = item;
    }
    size++;
  }

  @Override
  public TItem get(int index) {
    checkCapacity(index);
    return array[index];
  }

  @Override
  public void remove(int index) throws IndexOutOfBoundsException {
    checkCapacity(index);
    TItem item = array[index];
    for (int i = index; i < size; i++) {
      if (i == array.length - 1) {
        array[i] = null;
      } else {
        array[i] = array[i + 1];
      }
    }
    size--;
  }

  @Override
  public boolean contains(TItem item) {
    checkForNull(item);
    for (int i = 0; i < size; i++) {
      if (array[i].equals(item)) {
        return true;
      }
    }
    return false;
  }

  private void checkForNull(TItem item) {
    if (item == null) {
      throw new IllegalArgumentException(
          "The item passed to method cannot be empty");
    }
  }

  private void checkCapacity(int index) {
    if (index > size - 1 || index < 0) {
      throw new IndexOutOfBoundsException(
          "Given index exceeds current list size");
    }
  }

  private void enlargeList() {
    TItem[] newArray =
        (TItem[]) Array.newInstance(array.getClass(), array.length * 2);
    System.arraycopy(array, 0, newArray, 0, array.length);
  }

}
