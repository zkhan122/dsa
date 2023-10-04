package LinkedLists;

public class MyLinkedList {

  Node head;

  MyLinkedList insert(MyLinkedList list, int data) {
    Node new_node = new Node(data);


    // if list is empty , make the new node the head
    if (list.head == null) {
      list.head = new_node;
    } else {
      // traverse the list and end the node at the end
      Node last = list.head;
      while (last.next != null) {
        last = last.next;
      }
      last.setNext(new_node);
    }
    return list;
  }

  MyLinkedList insertAtFront(MyLinkedList list, int data) {
    Node new_node = new Node(data);


    // if list is empty , make the new node the head
    if (list.head == null) {
      list.head = new_node;
    } else {
      new_node.next = list.head;
      list.head = new_node;
    }
    return list;
  }

  static void printList(MyLinkedList list) {
    Node currentNode = list.head;
    System.out.println("Linked list: ");
    while (currentNode != null) {
      System.out.print(currentNode.getData() + " ");

      // go to the next node
      currentNode = currentNode.next;
    }
    System.out.println();
  }

  static MyLinkedList deleteByKey(MyLinkedList list, int key) {
    Node currNode = list.head, prev = null;

    // Case 1: If head node itself holds the key to be deleted

    if (currNode != null && currNode.getData() == key) {

      list.head = currNode.next; // Changed head

      // Display the message
      System.out.println(key + " found and deleted");

      printList(list);
      return list;
    }

    // CASE 2: If the key is somewhere other than at head

    // Search for the key to be deleted
    while (currNode != null && currNode.getData() != key) {
      prev = currNode; // getting ready to do prev.next.next
      currNode = currNode.next;
    }
    if (currNode != null) {
      prev.setNext(currNode.next); // doing prev.next.next

      // Display the message
      System.out.println(key + " found and deleted");
    }

    // Case 3: The key is not present in the list, currNode will be null
    if (currNode == null) {
      // Display the message
      System.out.println(key + " not found");
    }

    // return the List
    printList(list);
    return list;
  }

  static void reverseList(MyLinkedList list) {
    Node previous = null;
    Node current = list.head;
    Node next;
    while (current != null) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    list.head = previous;
    printList(list);
  }

  public static void main(String[] args) {
    MyLinkedList list = new MyLinkedList();

    list.insert(list, 1);
    list.insert(list, 2);
    list.insert(list, 3);
    list.insert(list, 4);
    list.insert(list, 5);

    printList(list);
    System.out.println();
    deleteByKey(list, 1);

    System.out.println();
    reverseList(list);
  }
}
