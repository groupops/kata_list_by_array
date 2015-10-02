package com.epam.mateusz.list;

public interface MyList<T> {

    void add(T item);
    T get(int index);
    T remove(int index);
    Boolean contains(T item);
    int size();
}
