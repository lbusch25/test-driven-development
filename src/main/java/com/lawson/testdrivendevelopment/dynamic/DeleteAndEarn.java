package com.lawson.testdrivendevelopment.dynamic;

import java.util.Arrays;
import java.util.HashMap;

public class DeleteAndEarn {

    /**
     * Rules: if we delete a number it is lost and so are all i-1 and i+1 - we want the maximum number of points
     *
     * idea: sort array and get sum for each unique integer
     * dp(i) = Math.max(Vals(nums[i - 1]), Vals(nums[i]) + Vals(nums[i] -2))
     *
     * This is very similar to house robber
     * The difference is that the i in question is the value - not the position in the array
     *
     * 1) Figure out the relationship between choices
     * 2) Figure out information necessary to make the optimal choice
     *
     * Run time = O(NLogN) + O(2N) = O(NLogN)
     * Sort takes NLogN time which dominates the O(2N)
     *
     * @param nums input array
     * @return maximum points from delete and earn
     */
    public static int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> points = new HashMap<>();
        for(Integer n : nums) {
            points.merge(n, n, Integer::sum);
        }
        int avoid = 0, using = points.get(nums[0]), prev = nums[0];
        for(int i = 1; i < nums.length; i++) {
            var max = Math.max(avoid, using);
            if (nums[i] != prev) {
                // logic to lookup should go here
                if (nums[i] - nums[i-1] == 1) {
                    using = points.get(nums[i]) + avoid; // get last skipped
                    avoid = max;
                } else {
                    using = points.get(nums[i]) + max; // just add maximum choice
                    avoid = max;
                }
            }
            prev = nums[i];
        }
        return Math.max(avoid, using);
    }
}
