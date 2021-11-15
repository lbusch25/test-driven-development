package com.lawson.testdrivendevelopment.arrays;

public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                res[0] = left;
                res[1] = right;
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
