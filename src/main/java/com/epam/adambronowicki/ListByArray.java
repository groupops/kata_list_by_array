package com.epam.adambronowicki;

public final class ListByArray<TItem> implements List<TItem> {

  private TItem[] array;
  private final int initialCapacity = 10;
  private int size = 0;

  public ListByArray() {
    array = (TItem[]) new Object[initialCapacity];
  }

  @Override
  public void add(TItem item) {
    checkForNull(item);
    if (size == array.length) {
      enlargeList();
      array[size] = item;
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
    if (size == array.length / 2) {
      reduceList();
    }
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
    TItem[] newArray = (TItem[]) new Object[array.length * 2];
    System.arraycopy(array, 0, newArray, 0, size);
    array = newArray;
  }

  private void reduceList() {
    TItem[] newArray = (TItem[]) new Object[array.length / 2];
    System.arraycopy(array, 0, newArray, 0, size);
    array = newArray;
  }

}
