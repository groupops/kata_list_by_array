package com.epam.adambronowicki;

public class Application {
  public static void main(String[] args){
    Stack<String> stack = new ArrayBasedStack<>(String.class, 10);
    stack.push("1");
    stack.push("2");
    stack.push("3");
    String item;
    while ((item = stack.peek()) != null) {
      System.out.println("Peeked: " + item);
      System.out.println("Popped: " + stack.pop());
    }
  }
}
