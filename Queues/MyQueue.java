package Queues;

/*
 * A Queue is a FIFO data structure
 * 
 * This implementation uses an array
 */


public class MyQueue {

  int[] queue = null;
  int front;
  int rear;
  int size = 0;

  public MyQueue(int size) {
    this.size = size;
    this.queue = new int[size];
    front = 0;
    rear = 0;
  }

  private boolean isFull() {
    if (front == size - 1) {
      return true;
    } else {
      return false;
    }
  }

  private boolean isEmpty() {
    if (front == rear) {
      return true;
    } else {
      return false;
    }
  }

  private void enqueue(int item) {
    if (isFull()) {
      System.out.println("Queue is full...");
    } else {
      queue[rear] = item;
      rear++;
    }
  }

  private void dequeue() {
    int dqItem = 0;
    if (isEmpty()) {
      System.out.println("Queue is empty...");
    } else {
      dqItem = queue[front];
      for (int i = 0; i < rear - 1; i++) {
        queue[i] = queue[i + 1];
      }
    }
    rear--;
    System.out.println("\n");
    System.out.println("Dequeue Operation: ");
    System.out.println(dqItem + " has been Dequeued");
  }

  private void displayQ() {

    for (int i = front; i < rear; i++) {
      System.out.printf(" %d <-- ", queue[i]);
    }
  }

  public static void main(String[] args) {
    MyQueue queue = new MyQueue(5);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.displayQ();

    queue.dequeue();
    queue.displayQ();
  }
}
