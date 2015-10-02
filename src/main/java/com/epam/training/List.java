package com.epam.training;

/**
 * Created by Dmytro_Ulanovych on 10/2/2015.
 */
public interface List<T> {

    void add(T item);

    T get(int index);

    T remove(int index);

    Boolean contains(T item);
}
