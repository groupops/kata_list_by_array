package com.epam.adambronowicki;

import java.util.ArrayList;

public final class ListByArrayList<T> implements List<T> {

  private java.util.List<T> list;

  public ListByArrayList(int initialCapacity) {
      list = new ArrayList<>(initialCapacity);
  }

  @Override
  public void add(T item) {
      list.add(item);
  }

  @Override
  public T get(int index) {
    return list.get(index);
  }

  @Override
  public void remove(int index) {
    list.remove(index);
  }

  @Override
  public boolean contains(T item) {
    return list.contains(item);
  }

}
