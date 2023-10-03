package MergeSort;

import java.util.ArrayList;

public class Merge {

  // merge function for integer arrays
  // 1 big array split up into 2 separate ararys a and b
  // assume a and b are sorted
  ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {

    // sorted array
    ArrayList<Integer> c = new ArrayList<>();

    // while arrays a & b are not empty (AND ONLY 1 ELEMENT)
    while (a.size() > 0 && b.size() > 0) {
      // if a is bigger than b (b is smaller than a)
      if (a.get(0) > b.get(0)) {
        c.add(b.get(0)); // we then want to add b to sorted c
        b.remove(0);
      } else {
        c.add(a.get(0));
        a.remove(0);
      }
    }
    while (a.size() > 0) {
      /*
       * we keep adding and removing array[0] as if we remove then we want to
       */
      c.add(a.get(0));
      a.remove(0);
    }
    while (b.size() > 0) {
      c.add(b.get(0));
      b.remove(0);
    }
    return c;
  }

  ArrayList<Integer> mergeSort(ArrayList<Integer> a) {
    int N = a.size();
    int mid = N / 2;
    // base case
    if (N == 1) {
      return a;
    }
    ArrayList<Integer> arrayOne = new ArrayList<>();
    ArrayList<Integer> arrayTwo = new ArrayList<>();

    for (int i = 0; i < mid; i++) {
      arrayOne.add(a.get(i));
    }
    for (int i = mid; i < N; i++) {
      arrayTwo.add(a.get(i));
    }
    return merge(arrayOne, arrayTwo);
  }

}

