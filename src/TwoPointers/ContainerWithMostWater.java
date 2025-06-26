package TwoPointers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ContainerWithMostWater {

    public static int maxArea(int[] heights) {
        int n = heights.length;

        ArrayList<Integer> areas = new ArrayList<>();
// my n^2 solution
//        for (int i = 0; i < heights.length; i++) {
//            int left = i;
//            int right = n-1;
//
//            while (left < right) {
//                int width = right - left;
//                int height =  Math.min(heights[left], heights[right]);
//                int area = width * height;
//                areas.add(area);
//
//                if (heights[left] < heights[right]) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//        }

        // o(n) solution
        int left = 0;
        int right = n -1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int currArea = width * height;
            maxArea = Math.max(maxArea, currArea);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;

    }

    public static void main(String[] args) {
        int[] heights1 = {1,7,2,5,4,7,3,6};
        int[] heights2 = {2, 2, 2};

        System.out.println(maxArea(heights1));
        System.out.println(maxArea(heights2));
    }
}
