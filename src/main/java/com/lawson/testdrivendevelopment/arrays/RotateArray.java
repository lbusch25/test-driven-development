package com.lawson.testdrivendevelopment.arrays;

import java.util.Arrays;

public class RotateArray {

    /**
     * Rotate the array by k steps
     * @param nums - the array to rotate
     * @param k - does not have to be less than nums
     */
    public static void rotate(int[] nums, int k) {
        int[] res = Arrays.copyOf(nums, nums.length);
        if (k >= nums.length) {
            k = k % nums.length;
        }
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (k > 0) {
                nums[(k-1)] = res[right];
                k--;
                right--;
            } else {
                nums[i] = res[left];
                left++;
            }
        }
    }
}
