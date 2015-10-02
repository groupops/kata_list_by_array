package com.epam.mateusz.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.epam.mateusz.list.MyList;
import com.epam.mateusz.list.MyListImpl;


public class ListTest {

    @Test
    public void testAdd() {
        MyList<String> list = new MyListImpl<String>();
        list.add("this");
        list.add("is");
        list.add("simple");
        list.add("test");

        assertEquals(list.size(), 4);
    }
    
    @Test
    public void testGet() {
        MyList<Integer> list = new MyListImpl<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        assertEquals(list.size(), 5);
        assertEquals(list.get(3), Integer.valueOf(4));
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBound() {
        MyList<Integer> list = new MyListImpl<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        list.get(70);
    }
    
    
    @Test
    public void testRemove() {
        MyList<String> list = new MyListImpl<String>();
        list.add("this");
        list.add("is");
        list.add("simple");
        list.add("test");
        list.add("of");
        list.add("removing");    
        assertEquals(list.get(2), "simple");       
        assertEquals(list.size(), 6);
        
        list.remove(2);
        assertEquals(list.size(), 5);
        assertEquals(list.get(2), "test");
    }
    
    @Test
    public void testContains() {
        MyList<String> list = new MyListImpl<String>();
        list.add("this");
        list.add("is");
        list.add("simple");
        list.add("test");
        list.add("of");
        list.add("contains");
        list.add("this");
        
        assertTrue(list.contains("of"));
        assertTrue(list.contains("this"));
        assertFalse(list.contains("nothing"));
    }

    
    @Test
    public void testAddMany() {
        MyList<Integer> list = new MyListImpl<Integer>();
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
        MyList<Integer> list = new MyListImpl<Integer>();
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
        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(2);
        assertEquals(list.size(), 8);
    }

    @Test
    public void testToString(){
        MyList<String> list = new MyListImpl<String>();
        list.add("this");
        list.add("is");
        list.add("simple");
        list.add("test");
        
        assertEquals(list.toString(), "[this, is, simple, test]");
    }
}
