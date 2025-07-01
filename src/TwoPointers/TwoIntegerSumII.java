package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoIntegerSumII {

    public static int[] twoSum(int[] numbers, int target) {

        int n = numbers.length;
        int left = 0;
        int right = n-1;

        int[] solutions = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for (int num : numbers) {
            map.put(index, num);
            index++;
        }
        while (left < right) {
            if (numbers[left] == numbers[right]) continue;
            int sum = map.get(left) + map.get(right);
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                solutions[0] = map.get(left);
                solutions[1] = map.get(right);
                left++;
                right--;
            }
        }

        return solutions;
    }

    public static void main(String[] args) {
        int[] numbers1 = {1,2,3,4};
        System.out.println(twoSum(numbers1, 3));

        int[] numbers2 = {2,3,4};
        System.out.println(twoSum(numbers2, 6));
    }
}
