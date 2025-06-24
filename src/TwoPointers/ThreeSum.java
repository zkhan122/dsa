package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<Integer> buffer = new ArrayList<>();
            // fix a current element
            int curr = nums[i];
            if (i > 0) {
                if (curr == nums[i-1]) {
                    continue;
                }
            }
            // 1(curr at start), 2 (left at start), 3, ... , n(right at start)
            int left = i + 1;
            int right = nums.length - 1;
            // binary search
            while (left < right) {
                int sum = curr + nums[left] + nums[right];
                // check if sum is too big
                if (sum > 0) {
                    right--; // decreasing right by 1
                }
                // check if sum is too small
                else if (sum < 0) {
                    left++;
                }
                // if sum == 0
                else {
                    solutions.add(Arrays.asList(curr, nums[left], nums[right]));

                    //skipping duplicates
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }

                    //skipping duplicates
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return solutions;
    }

    public static void main(String[] args) {

        int[] nums1 = {-1,0,1,2,-1,-4}; // case 1
        int[] nums2 = {0,1,1}; // case 2
        int[] nums3 = {0,0,0}; // case 3
        int[] nums4 = {-2,0,0,2,2}; // case 4

        System.out.println(threeSum(nums1));
        System.out.println(threeSum(nums2));
        System.out.println(threeSum(nums3));
        System.out.println(threeSum(nums4));

    }
}
