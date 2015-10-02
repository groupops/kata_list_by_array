package com.epam.adambronowicki;

/**
 * My own list implementation
 * @param <T> element of the list
 */
public interface MyList<T> {

  void add(T item);

  T get(int index);

  T remove(int index);

  Boolean contains(T item);

}
