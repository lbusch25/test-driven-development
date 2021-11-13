package com.lawson.testdrivendevelopment.arrays;

import java.util.Arrays;

public class ArraySquares {
    /**
     *
     * @param nums array sorted in increasing order - can have negatives
     * @return sorted squares
     */
    public static int[] sortedSquares(int[] nums) {
        return linearTimeSolution(nums);
    }

    private static int[] basicApproach(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i], 2);
        }
        Arrays.sort(nums);
        return nums;
    }

    private static int[] linearTimeSolution(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            int square = 0;
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                square = nums[left];
                left++;
            } else {
                square = nums[right];
                right--;
            }
            res[i] = square * square;
        }
        return res;
    }


}
