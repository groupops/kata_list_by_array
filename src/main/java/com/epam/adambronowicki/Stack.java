package com.epam.adambronowicki;

public interface Stack<E> {

  void push(E item);

  E pop();

  E peek();

  int size();

}
