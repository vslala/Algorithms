package com.bma.problemsolving.leetcode.java.array;

/**
 * 88. Merge Sorted Array
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function,
 * but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n,
 * where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * @author varun.shrivastava
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        var k = m + n - 1;
        var i = m - 1;
        var j = n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else if (nums2[j] > nums1[i]) {
                nums1[k--] = nums2[j--];
            }
        }

        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
