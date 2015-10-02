package com.epam.training;

import java.util.ArrayList;

/**
 * Created by Dmytro_Ulanovych on 10/2/2015.
 */
public class ArrayListWrapper<T> implements List<T> {
    private java.util.List<T> list;

    public ArrayListWrapper() {
        list = new ArrayList<>();
    }

    public ArrayListWrapper(int initialCapacity) {
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
    public T remove(int index) {
        return list.remove(index);
    }

    @Override
    public boolean contains(T item) {
        return list.contains(item);
    }
}
