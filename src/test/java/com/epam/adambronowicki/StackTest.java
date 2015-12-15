package com.epam.adambronowicki;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class StackTest {

    @Test
    public void testPush() {
        Stack<String> list = new ArrayBasedStack<>();
        list.push("this");
        list.push("is");
        list.push("simple");
        list.push("test");

        assertThat(list.size(), is(equalTo(4)));
    }

    @Test
    public void testPeek() {
        Stack<Integer> list = new ArrayBasedStack<>();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);

        assertThat(list.size(), is(equalTo(5)));
        assertThat(list.peek(), is(equalTo(5)));
    }

    @Test
    public void testPop() {
        Stack<String> list = new ArrayBasedStack<>();
        list.push("this");
        list.push("is");
        list.push("simple");
        list.push("test");
        list.push("of");
        list.push("removing");

        assertEquals(list.size(), 6);
        assertEquals(list.peek(), "removing");

        list.pop();

        assertThat(list.size(), is(equalTo(5)));
        assertThat(list.peek(), is(equalTo("of")));
    }

    @Test
    public void testPushMany() {
        Stack<Integer> list = new ArrayBasedStack<>();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.push(6);
        list.push(7);
        list.push(8);
        list.push(9);
        list.push(10);
        list.push(11);
        list.push(12);

        assertThat(list.size(), is(equalTo(12)));
    }

    @Test
    public void testPopMany() {
        Stack<Integer> list = new ArrayBasedStack<>();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.push(6);
        list.push(7);
        list.push(8);
        list.push(9);
        list.push(10);
        list.push(11);
        list.push(12);

        assertThat(list.size(), is(equalTo(12)));

        list.pop();
        list.pop();
        list.pop();
        list.pop();

        assertThat(list.size(), is(equalTo(8)));
    }

    @Test
    public void testToString() {
        Stack<String> list = new ArrayBasedStack<>();
        list.push("this");
        list.push("is");
        list.push("simple");
        list.push("test");

        assertThat(list.toString(), is(equalTo(
                "[this, is, simple, test, null, null, null, null, null, null]")));
    }
}