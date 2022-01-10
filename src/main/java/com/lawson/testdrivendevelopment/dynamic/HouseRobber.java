package com.lawson.testdrivendevelopment.dynamic;

public class HouseRobber {

    //recurrence relation
    //dp(i) = max (dp(i - 1), dp(i - 2) + nums[i])
    //This makes sense, starting at 0 we either rob or don't rob the house
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i - 2] + nums[i]);
        }
        return nums[nums.length - 1];
    }
}
