package Stacks;

import java.util.Stack;

/*
 * a stack is a LIFO data structure used to store collection of elements
 * 
 * The stack data structure already exists in Java but we will be implementing it ourselves using an
 * ARRAY
 */
// has functions push, pop, peek, isEmpty(), isFull()

public class MyStack {


  public static void main(String[] args) {

    Stack<String> stack = new Stack<>();

    // stack of books (collection)
    // push()
    stack.push("B1");
    stack.push("B2");
    stack.push("B3"); // top of the stack
    System.out.println(stack);

    // peek()
    System.out.println("element at top of stack: " + stack.peek());

    // pop() -- remove and returning
    String bookAtTop = stack.pop();
    System.out.println(bookAtTop); // B3 gets removed

    // now lets print current state of the stack
    System.out.println(stack);
    System.out.println(stack.peek());


  }

}
