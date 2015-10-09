package com.epam.adambronowicki;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StackTest {

    private Stack<String> stack;

    @Before
    public void setUp() {
        stack = new ArrayBasedStack<>(String.class);
    }

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldCheckIfNullIsPushedToStack()
            throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The item passed to method cannot be empty");
        stack.push(null);
    }

    @Test
    public void shouldPush() {
        pushTwoItems();

        assertThat(stack.size(), is(equalTo(2)));
    }

    private void pushTwoItems() {
        stack.push("a");
        stack.push("b");
    }

    @Test
    public void shouldPeek() {
        pushTwoItems();

        assertThat(stack.peek(), is(equalTo("b")));
    }

    @Test
    public void shouldPeekWithoutPop() {
        pushTwoItems();

        assertThat(stack.size(), is(equalTo(2)));
    }

    @Test
    public void shouldPopOneItem() {
        pushTwoItems();

        stack.pop();

        assertThat(stack.size(), is(equalTo(1)));
    }

    @Test
    public void shouldPopTopItem() {
        pushTwoItems();

        stack.pop();

        assertThat(stack.peek(), is(equalTo("a")));
    }

    @Test
    public void shouldPushMany() {
        pushTwelveItems();

        assertThat(stack.size(), is(equalTo(12)));
    }

    private void pushTwelveItems() {
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");
        stack.push("g");
        stack.push("h");
        stack.push("i");
        stack.push("j");
        stack.push("k");
        stack.push("l");
    }

    @Test
    public void shouldPopMany() {
        pushTwelveItems();

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        assertThat(stack.size(), is(equalTo(8)));
    }

}
