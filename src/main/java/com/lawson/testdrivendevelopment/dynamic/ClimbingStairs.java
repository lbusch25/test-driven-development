package com.lawson.testdrivendevelopment.dynamic;

import java.util.HashMap;

public class ClimbingStairs {

    public static int climbStairs(int n) {
        return climbStairsBottomUp(n);
    }

    private static int climbStairsBottomUp(int n) {
        // distinct steps should be the sum of the prior two steps
        int[] seen = new int[n];
        seen[0] = 1;
        seen[1] = 2;
        for (int i = 2; i < n; i++) {
            seen[i] = seen[i -1] + seen[i - 2];
        }
        return seen[n - 1];
    }

    private static int climbStairsTopDown(int n) {
        HashMap<Integer, Integer> solved = new HashMap<>();
        solved.put(1, 1);
        solved.put(2, 2);
        return climbStairsDp(n, solved);
    }

    private static int climbStairsDp(int n, HashMap<Integer, Integer> solved) {
        if (solved.containsKey(n)) {
            return solved.get(n);
        } else {
            int t = climbStairsDp(n - 1, solved) + climbStairsDp(n-2, solved);
            solved.put(n, t);
            return t;
        }
    }

    // This is just the HouseRobber problem but a minimum
    // can start from 0 or 1 so no update needed to second state
    // cost[i] = Min(cost[i - 1], cost[i - 2]) + cost(i);
    public static int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i-1], cost[i -2]) + cost[i];
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
