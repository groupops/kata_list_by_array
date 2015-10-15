package com.epam.adambronowicki;

public interface List<TItem> {

  void add(TItem item);

  TItem get(int index);

  void remove(int index);

  boolean contains(TItem item);

}
