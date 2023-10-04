package Heaps;

import java.util.Arrays;

// heaps can be implemented using arrays

public class MinIntHeap {
  private int capacity = 10; // size of tree heap (array size)
  private int size = 0;

  int[] items = new int[capacity];

  private int getLeftChildIndex(int parentIndex) {
    return 2 * parentIndex + 1;
  }

  private int getRightChildIndex(int parentIndex) {
    return 2 * parentIndex + 2;
  }

  private int getParentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  private boolean hasLeftChild(int index) {
    return getLeftChildIndex(index) < size;
  }

  private boolean hasRightChild(int index) {
    return getRightChildIndex(index) < size;
  }

  private boolean hasParent(int index) {
    return getParentIndex(index) >= 0;
  }

  private int leftChild(int index) {
    return items[getLeftChildIndex(index)];
  }

  private int rightChild(int index) {
    return items[getRightChildIndex(index)];
  }

  private int parent(int index) {
    return items[getParentIndex(index)];
  }

  private void swap(int i1, int i2) {
    int temp = items[i1];
    items[i1] = items[i2];
    items[i2] = temp;
  }

  private void ensureExtraCapacity() { // check if array is full then create new array of double of
                                       // size and copy elements over
    if (size == capacity) {
      items = Arrays.copyOf(items, capacity + 2);
    }
  }

  public int peek() {
    if (size == 0) {
      throw new IllegalStateException();
    }
    return items[0];
  }

  public int poll() { // removing the min element
    int item = peek();
    item = items[size - 1];
    size--;
    heapifyDown(); // bubble down the heap tree
    return item;
  }

  public void add(int item) {
    ensureExtraCapacity();
    items[size] = item;
    size++;
    heapifyUp();
  }

  public void heapifyUp() {
    int index = size - 1;
    while (hasParent(index) && parent(index) > items[index]) {
      swap(getParentIndex(index), index);
      index = getParentIndex(index);
    }
  }

  public void heapifyDown() {
    int index = 0;
    while (hasLeftChild(index)) { // if no left child then there is no right child
      int smallerChildIndex = getLeftChildIndex(index);
      if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
        smallerChildIndex = getRightChildIndex(index);
      }

      if (items[index] < items[smallerChildIndex]) {
        break;
      } else {
        swap(index, smallerChildIndex);
        index = smallerChildIndex;
      }
    }
  }


  public static void main(String[] args) {

  }
}
