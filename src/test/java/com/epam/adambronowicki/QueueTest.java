package com.epam.adambronowicki;


import org.junit.Test;

import static org.junit.Assert.*;


public class QueueTest {

    @Test
    public void testAdd() {
        Queue<String> list = new ArrayBasedQueue<>(10);
        list.add("this");
        list.add("is");
        list.add("simple");
        list.add("test");

        assertEquals(list.size(), 4);
    }

    @Test
    public void testElement() {
        Queue<Integer> list = new ArrayBasedQueue<>(10);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        assertEquals(list.size(), 5);
        assertEquals(list.element(), Integer.valueOf(1));
    }

    @Test
    public void testRemove() {
        Queue<String> list = new ArrayBasedQueue<>(10);
        list.add("this");
        list.add("is");
        list.add("simple");
        list.add("test");
        list.add("of");
        list.add("removing");
        assertEquals(list.element(), "this");
        assertEquals(list.size(), 6);

        list.remove();
        assertEquals(list.size(), 5);
        assertEquals(list.element(), "is");
    }

    @Test
    public void testAddMany() {
        Queue<Integer> list = new ArrayBasedQueue<>(10);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        assertEquals(list.size(), 12);
    }

    @Test
    public void testRemoveMany() {
        Queue<Integer> list = new ArrayBasedQueue<>(10);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        assertEquals(list.size(), 12);

        list.remove();
        list.remove();
        list.remove();
        list.remove();
        assertEquals(list.size(), 8);
    }

    @Test
    public void testToString() {
        Queue<String> list = new ArrayBasedQueue<>(10);
        list.add("this");
        list.add("is");
        list.add("simple");
        list.add("test");

        assertEquals(list.toString(), "[this, is, simple, test]");
    }

}
