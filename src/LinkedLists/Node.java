package LinkedLists;

public class Node {
  int data;
  Node next;

  public Node(int d) {
    this.setData(d);
    this.setNext(null);
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }
}
