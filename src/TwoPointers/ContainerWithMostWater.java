package TwoPointers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ContainerWithMostWater {

    public static int maxArea(int[] heights) {

        /*
        set left = height[i]
        set the initial max between maxArea and 0
        go over the heights while left < right
        the width = right - left
        the height = min of (left, right) as we need to have sides same
        currentArea = width * height
        check max(maxArea, currentArea)
        check if the left height < right height and adjust pointers
        if max area found then return

        note: shouldnt sort as to have the optimal area we want
        the biggest width (right - left)
        */
        int n = heights.length;
        int maxArea = 0;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int currArea = width * height;
            maxArea = Math.max(currArea, maxArea);
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
