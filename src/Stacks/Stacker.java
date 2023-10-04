package Stacks;

import java.util.Arrays;

public class Stacker {
  // assume lets create a stack of ints of size 5
  private int maxSize = 5;
  private int[] stack = new int[maxSize];
  // pointer for stack
  private int top;

  public Stacker() {
    // set the pointer to be empty initially
    top = -1;
  }

  private void display() {
    System.out.println("Current stack: " + Arrays.toString(stack));
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

  // push()
  private void push(int item) {
    if (this.isFull()) {
      System.out.println("Stack is full..cannot add anymore");
    } else {
      // increment top pointer by 1
      top += 1;
      this.stack[top] = item;
    }
  }

  // pop()
  private int pop() {
    int item_removed = stack[top];
    if (this.isEmpty()) {
      System.out.println("Nothing to remove");
    } else {
      stack[top] = 0;
      top -= 1;
      System.out.println("After popping");
      this.display();
    }
    return item_removed;
  }

  private int peek() {
    return this.stack[top];
  }

  public static void main(String[] args) {
    Stacker stackObj = new Stacker();

    stackObj.push(1);
    stackObj.push(2);
    stackObj.push(3);
    stackObj.push(4);
    stackObj.push(5);

    stackObj.display();

    // pop()
    System.out.println(stackObj.pop());

    // peek()
    System.out.println(stackObj.peek());


  }
}
