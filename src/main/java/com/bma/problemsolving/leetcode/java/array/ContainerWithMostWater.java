package com.bma.problemsolving.leetcode.java.array;

/**
 * Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container,
 * such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * @author varun.shrivastava
 */
public class ContainerWithMostWater {


    public int maxArea(int[] input) {
        int length = input.length;
        int left = 0;
        int right = length - 1;
        int maxArea = -1;

        while (left < right) {
            int distance = right - left;
            if (input[left] < input[right]) {
                maxArea = Math.max(maxArea, (input[left] * distance));
                left++;
            } else {
                maxArea = Math.max(maxArea, (input[right] * distance));
                right--;
            }
        }

        return maxArea;
    }
}
