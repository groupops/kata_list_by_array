package com.epam.training;


public interface Queue<E> {

    boolean add(E element);

    E remove();

    E element();
}
