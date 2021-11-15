package com.lawson.testdrivendevelopment.arrays;

import java.util.Arrays;

public class MoveZeros {

    public static void moveZeroes(int[] nums) {
        arrayCopyImplementation(nums);
    }

    // Same speed - less copy operations
    private static void arrayCopyImplementation(int[] nums) {
        int[] c = Arrays.copyOf(nums, nums.length);
        int right = nums.length - 1;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (c[i] == 0) {
                nums[right] = 0;
                right--;
            } else {
                nums[left] = c[i];
                left++;
            }
        }
    }

    // Less memory, more copy operations
    // Be okay with O(2N) solutions for O(N)
    private static void inPlaceImplementation(int[] nums) {
        // two pointer approach
        // one for iteration and one for non zero elements
        // which really means what I care about is the location
        // of the last 0 - a psuedo bubble sort
        int lastNonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZero] = nums[i];
                lastNonZero++;
            }
        }
        for (int j = lastNonZero; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
