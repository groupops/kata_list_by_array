package com.epam.adambronowicki;

public class MyListImpl<T> implements MyList<T> {

  private T[] container = (T[]) new Object[10];
  private int numberOfElements = 0;

  /**
   * Adds specified item to the list
   *
   * @param item the item to be added to the list
   */
  public void add(T item) {
    if (numberOfElements == container.length) {
      System.arraycopy(container, 0, new Object[container.length * 2], 0,
          container.length);
    } else {
      container[numberOfElements] = item;
    }
    numberOfElements++;
  }

  /**
   * Gets item from specified index
   *
   * @param index the index of the item
   */
  public T get(int index) {

    return container[index];
  }

  /**
   * Removes item at specified index
   *
   * @param index the index of the item
   * @return the removed item
   */
  public T remove(int index) throws ArrayIndexOutOfBoundsException {
    T item;
    if (index > container.length || index < 0) {
      throw new ArrayIndexOutOfBoundsException();
    } else {
      item = container[index];
      for (int i = index; i < container.length; i++) {
        if (i == container.length - 1) {
          container[i] = null;
        } else {
          container[i] = container[i + 1];
        }
      }
    }

    return item;
  }

  /**
   * Checks if the list contains specified item
   *
   * @param item the specified item
   * @return true if the list contains specified item
   */
  public Boolean contains(T item) {
    Boolean containsItem = false;
    for (int i = 0; i < container.length; i++) {
      if (container[i] == item) {
        containsItem = true;
        return containsItem;
      }
    }
    return containsItem;
  }

}
