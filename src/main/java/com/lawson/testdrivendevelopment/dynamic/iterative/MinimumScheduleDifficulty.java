package com.lawson.testdrivendevelopment.dynamic.iterative;

import java.util.Arrays;

public class MinimumScheduleDifficulty {

    /*
     * schedule a list of dependent jobs in d days
     *      => to work i all jobs j 0 <= j < i must be completed
     * have to complete one task every day
     *
     * difficulty is the sum of each day's difficultly
     *      a day's difficulty is the difficulty of the hardest job done that day
     *
     * find the minimum difficulty - if you cannot find a schedule return -1
     *
     * Note: no limit to jobs done per day - just want to minimize total work across d days
     *
     * => need to determine how many jobs to do per day (in order)
     *      => need i (job number) and d (day)
     *      => need to solve for all combinations of i and d (leaving enough remaining)
     *          => foreach i solve from i to d - i and pick optimal
     *
     * for jobs i < j < n-(d-day) - next day's start is j + 1
     *      => difficulty is hardest + dp(j+1, day+1)
     *
     * dp(i, day) = min(hardest + dp(j+1, day+1)) for all i <= j < n - (d-day)
     *      where hardest = max(jobDifficulty[k] for all i <= k <= j)
     *
     * Base case: last day
     *      have to finish all jobs => hardest job on or after index i
     */

    public static int minDifficulty(int[] jobDifficulty, int d) {
        return bottomUp(jobDifficulty, d);
    }

    private static int bottomUp(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        var length = jobDifficulty.length;
        var seen = new int[length][d + 1];
        for (int i = 0; i < length; i++) {
            Arrays.fill(seen[i], Integer.MAX_VALUE); // set up dp
        }

        seen[length-1][d] = jobDifficulty[length - 1]; // set up base case AKA last day

        // set most difficult job for last day on each row
        for (int i = length - 2; i >= 0; i--) {
            seen[i][d] = Math.max(seen[i + 1][d], jobDifficulty[i]);
        }

        for (int day = d -1; day > 0; day--) {
            for (int i = day - 1; i < length - (d - day); i++) {
                var hardest = 0;
                //Iterate and choose best option per day per row
                for (int j = i; j < length - (d - day); j++) {
                    hardest = Math.max(hardest, jobDifficulty[j]);
                    seen[i][day] = Math.min(seen[i][day], hardest + seen[j + 1][day + 1]);
                }
            }
        }

        return seen[0][1];
    }

    private static int topDownSetup(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        var hardest = 0;
        var hardestRemaining = new int[jobDifficulty.length];
        for (int i = jobDifficulty.length - 1; i > -1; i--) {
            hardest = Math.max(hardest, jobDifficulty[i]);
            hardestRemaining[i] = hardest;
        }
        var seen = new int[jobDifficulty.length][d + 1];
        for (int i = 0; i < jobDifficulty.length; i++) {
            Arrays.fill(seen[i], -1);
        }
        return topDown(0, 1, hardestRemaining, seen, d, jobDifficulty);
    }

    private static int topDown(int i, int day, int[] hardestRemaining, int[][] seen, int d, int[] jobDifficulty) {
        if (day == d) {
            return hardestRemaining[i]; //base case
        }

        if (seen[i][day] == -1) {
            var best = Integer.MAX_VALUE;
            var hardest = 0;
            for (int j = i; j < hardestRemaining.length - (d - day); j++) {
                hardest = Math.max(hardest, jobDifficulty[j]);
                best = Math.min(best, hardest + topDown(j + 1, day + 1, hardestRemaining, seen, d, jobDifficulty));
            }
            seen[i][day] = best;
        }
        return seen[i][day];
    }
}
