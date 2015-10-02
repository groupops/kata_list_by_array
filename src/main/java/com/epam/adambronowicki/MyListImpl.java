package com.epam.adambronowicki;

/**
 * The class implementing MyList interface
 *
 * @param <T> the element of the list
 */
public class MyListImpl<T> implements MyList<T> {

  private T[] list = (T[]) new Object[10];
  private int numberOfItems = 0;

  /**
   * Adds specified item to the list
   *
   * @param item the item to be added to the list
   */
  public void add(T item) {
    if (numberOfItems == list.length) {
      System.arraycopy(list, 0, new Object[list.length * 2], 0,
          list.length);
    } else {
      list[numberOfItems] = item;
    }
    numberOfItems++;
  }

  /**
   * Gets item from specified index
   *
   * @param index the index of the item
   */
  public T get(int index) {

    return list[index];
  }

  /**
   * Removes item at specified index
   *
   * @param index the index of the item
   * @return the removed item
   */
  public T remove(int index) throws ArrayIndexOutOfBoundsException {
    T item = list[index];
    for (int i = index; i < list.length; i++) {
      if (i == list.length - 1) {
        list[i] = null;
      } else {
        list[i] = list[i + 1];
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
    for (int i = 0; i < list.length; i++) {
      if (list[i] == item) {
        containsItem = true;
        return containsItem;
      }
    }
    return containsItem;
  }

}
