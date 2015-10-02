package com.epam.adambronowicki;

public interface List<T> {

  void add(T item);

  T get(int index);

  T remove(int index);

  boolean contains(T item);

}
