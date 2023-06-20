package Stacks;

import java.util.Arrays;

/*
 * a stack is a LIFO data structure used to store collection of elements
 * 
 * The stack data structure already exists in Java but we will be implementing it ourselves using an
 * ARRAY
 */
// has functions push, pop, peek, isEmpty(), isFull()

public class MyStack {
  private int maxSize = 5; // define a max size
  private int top;
  int[] stack = new int[maxSize]; // make static array (maxSize defined)

  public MyStack() {
    top = -1;
  }

  private void display() {
    System.out.println("Stack: " + Arrays.toString(stack));
  }

  private boolean isEmpty() {
    if (top == -1) {
      return true;
    } else {
      return false;
    }
  }

  private boolean isFull() {
    if (top == maxSize - 1) {
      return true;
    } else {
      return false;
    }
  }

  private void push(int value) {
    if (this.isFull()) {
      System.out.println("Stack overflow error! Stack is full...");
    } else {
      top += 1; // increment top pointer for new item
      stack[top] = value; // assign value to the top pointer
      System.out.println("Adding value " + value);

    }
    this.display();
  }

  private void pop() {
    if (this.isEmpty()) {
      System.out.println("Stack is empty! ");
    } else {
      System.out.println();
      System.out.println(stack[top] + " has been popped off");
      stack[top] = 0;
      top -= 1;
      this.display();
    }
  }

  private void peek() {
    System.out.println();
    System.out.println("element at top : " + stack[top]);
  }

  public static void main(String[] args) {
    MyStack stack = new MyStack();

    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    stack.push(6); // should give stack overflow error (max size 5)

    stack.pop();

    stack.peek();


  }

}
