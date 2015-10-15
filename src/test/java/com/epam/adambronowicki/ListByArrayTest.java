package com.epam.adambronowicki;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ListByArrayTest {

  List<String> list;

  @Before
  public void setUp() {
    list = new ListByArray<>(String.class);
  }

  @Test
  public void testAdd() {
    list.add("this");
    list.add("is");
    list.add("simple");
    list.add("test");

    assertEquals(list.get(0), "this");
    assertEquals(list.get(1), "is");
    assertEquals(list.get(2), "simple");
    assertEquals(list.get(3), "test");
  }

  @Test
  public void testGet() {
    list.add("this");
    list.add("is");
    list.add("simple");
    list.add("test");

    assertEquals(list.get(0), "this");
    assertEquals(list.get(1), "is");
    assertEquals(list.get(2), "simple");
    assertEquals(list.get(3), "test");
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetTooLowIndexOfList(){
    list.add("this");
    list.add("is");
    list.add("simple");
    list.add("test");
    list.get(-1);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetTooHighIndexOfList(){
    list.add("this");
    list.add("is");
    list.add("simple");
    list.add("test");
    list.get(4);
  }

  @Test
  public void testRemove() {
    list.add("this");
    list.add("is");
    list.add("simple");
    list.add("test");
    list.add("of");
    list.add("removing");

    list.remove(5);
    assertFalse(list.contains("removing"));
  }

  @Test
  public void testContains() {
    list.add("a");

    assertTrue(list.contains("a"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testContainsNull() {
    list.add("a");
    list.contains(null);
  }

}
