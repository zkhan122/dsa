package MergeSort;

import java.util.Arrays;

public class MergeSort {

  /**
   * 
   * @param arr - the array to perform sorting on
   * @param left - left pointer (assume to be 0)
   * @param mid - mid pointer
   * @param right - right pointer
   */
  void merge(int[] arr, int left, int mid, int right) {

    int leftSize = mid - left + 1;
    int rightSize = right - mid;

    // create temp arrays for left and right
    int[] left_array = new int[leftSize];
    int[] right_array = new int[rightSize];

    // copy data from temp arrays
    // add all elements from i <->
    for (int i = 0; i < leftSize; ++i) {
      left_array[i] = arr[left + i];
    }
    for (int j = 0; j < rightSize; ++j) {
      // add all elements from mid <-> end to right_array
      right_array[j] = arr[mid + 1 + j];
    }

    // Now let's merge the temp arrays together

    // 2 pointers defined, one for left part of merged and other for right part of merged
    int i = 0, j = 0; // initial indices

    // initial index of new merged subarray (merged array)
    int k = left;
    while (i < leftSize && j < rightSize) {
      if (left_array[i] <= right_array[j]) {
        arr[k] = left_array[i]; // add smaller element to array (sorting)
        i++;
      } else {
        arr[k] = right_array[j];
        j++;
      }
      k++;
    }

    // copy any remaining parts for right_array (already in place)
    while (i < leftSize) {
      arr[k] = left_array[i];
      i++;
      k++;
    }

    // copy any remaining parts for right_array (already in place)
    while (j < rightSize) {
      arr[k] = right_array[j];
      j++;
      k++;
    }
  }

  void sort(int arr[], int left, int right) {

    // if (arr.length <= 1) {
    // System.out.println(arr);
    // }

    if (left < right) {
      int mid = left + (right - 1) / 2;
      // sort first half and second half of array
      sort(arr, left, mid); // left <-> mid
      sort(arr, mid + 1, right); // mid <-> right

      // then once sorted, we merge
      merge(arr, left, mid, right);
    }
  }

  public static void main(String[] args) {

    int[] arr = {12, 5, 3, 7, 2, 6, 9};

    System.out.println("Array entered: " + Arrays.toString(arr));

    MergeSort sorter = new MergeSort();
    sorter.sort(arr, 0, arr.length - 1);

    System.out.println("Sorted array is: " + Arrays.toString(arr));
  }
}

