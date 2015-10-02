package com.epam.training;


public interface Queue<E> {

    boolean add(E e);

    E remove();

    E element();
}
