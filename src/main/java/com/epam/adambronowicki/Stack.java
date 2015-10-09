package com.epam.adambronowicki;

public interface Stack<E> {

    E push(E item);

    E pop();

    E peek();

    int size();

}
