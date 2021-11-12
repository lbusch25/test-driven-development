package com.lawson.testdrivendevelopment.search;

public class SearchInputPosition {

    /**
     *
     * @param nums input array to binary search
     * @param target location to place - return position if found otherwise its insert position
     * @return the position if present, otherwise its insert postion
     */
    public static int searchInsert(int[] nums, int target) {
        int mid = (nums.length / 2);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        return nums[mid] < target ? mid + 1 : mid;
    }
}
