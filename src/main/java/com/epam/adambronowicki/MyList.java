package com.epam.adambronowicki;

/**
 * My own list implementation
 * @param <T> element of the list
 */
public interface MyList<T> {

  /**
   * Adds specified item to the list
   *
   * @param item the item to be added to the list
   */
  void add(T item);

  /**
   * Gets item from specified index
   *
   * @param index the index of the item
   */
  T get(int index);

  /**
   * Removes item at specified index
   *
   * @param index the index of the item
   * @return the removed item
   */
  T remove(int index);

  /**
   * Checks if the list contains specified item
   *
   * @param item the specified item
   * @return true if the list contains specified item
   */
  Boolean contains(T item);

}
