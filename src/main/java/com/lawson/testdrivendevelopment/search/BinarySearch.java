package com.lawson.testdrivendevelopment.search;

public class BinarySearch {

    /**
     *
     * @param nums an array of nums sorted in ascending order
     * @param target number to find
     * @return index if present, -1 otherwise
     */
    public static int search(int[] nums, int target) {
        int mid = nums.length / 2;
        int right = nums.length - 1; //because 0 indexed
        int left = 0;
        while (left <= right) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1; // because already checked the middle
            }
            mid = (left + right) / 2;
        }
        return -1;
    }

    /**
     * Just binary search over versions - if a version is bad move the pointer
     * @param n number of versions
     * @return first bad version
     */
    public static int firstBadVersion(int n) {
        int mid = n / 2;
        int right = n;
        int left = 0;
        while (left < right) {
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
            mid = left + (right - left) / 2; // this is leetcode being super technical - preventing a java overflow bug
        }
        return left;
    }

    // api method that is called
    public static boolean isBadVersion(int n) {
        return false;
    }
}
