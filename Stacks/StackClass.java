package Stacks;

import java.util.Stack;

public class StackClass {

  static void display(Stack<String> stack) {
    System.out.println("Stack:surr " + stack);
    System.out.println();
  }

  public static void main(String[] args) {
    Stack<String> stack = new Stack<>(); // can use Stack<Object> to allow for multiple wrapper
                                         // types

    stack.push("A");
    stack.push("B");
    stack.push("C");
    stack.push("D");

    display(stack);

    String poppedItem = stack.pop();
    System.out.println("Popped item: " + poppedItem);
    display(stack);

    String peekItem = stack.peek();
    System.out.println("Peek item: " + peekItem);

    display(stack);

  }
}
