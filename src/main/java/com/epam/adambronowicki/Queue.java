package com.epam.adambronowicki;

public interface Queue<E> {

    void add(E item);

    E remove();

    E element();

    int size();

}
