package com.epam.training;

public interface Stack<E> {

    E push(E element);

    E pop();

    E peak();
}
