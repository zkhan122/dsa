package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoIntegerSumII {

    public static int[] twoSum(int[] numbers, int target) {

        int[] solutions = new int[2];
        int n = numbers.length;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                solutions[0] = left + 1;
                solutions[1] = right + 1;

                while (left < right && numbers[left] == numbers[left+1]) {
                    left++;
                }
                while (left < right && numbers[right] == numbers[right-1]) {
                    right--;
                }
                left++;
                right--;
            }
            else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(Arrays.toString(solutions));
        return solutions;
    }

    public static void main(String[] args) {
//        int[] numbers1 = {1,2,3,4};
//        System.out.println(twoSum(numbers1, 3));

        int[] numbers2 = {2,3,4};
        System.out.println(twoSum(numbers2, 6));
    }
}
