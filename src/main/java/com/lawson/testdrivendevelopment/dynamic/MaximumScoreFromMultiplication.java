package com.lawson.testdrivendevelopment.dynamic;

public class MaximumScoreFromMultiplication {

    //Array of nums and multipliers
    // for each number in multipliers - determine if nums[front] or nums[back is greater]
    // continue forward - may be weird if chains of equality (but should be covered since always take greater)
    // cannot be solved in a greedy manner - being patient may lead to larger products

    // dp(i, left) = max(m * nums[left] + dp(i+1, left+1), m * nums[right] + dp(i+1, left)

    private int[][] seen;
    private int[] nums, multipliers;
    private int n, m;

    public MaximumScoreFromMultiplication() {
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        return bottomUpDp(nums, multipliers);
    }

    //Working our way up from the bottom right corner of the matrix
    private int bottomUpDp(int[] nums, int[] multipliers) {
        var m = multipliers.length;
        var n = nums.length;
        var seen = new int[m + 1][m + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int left = i; left >= 0; left--) {
                var mult = multipliers[i];
                var right = n - 1 - (i - left);
                seen[i][left] = Math.max(mult * nums[left] + seen[i+1][left+1],
                        mult * nums[right] + seen[i + 1][left]);
            }
        }
        return seen[0][0];
    }

    private int topDown(int[] nums, int[] multipliers) {
        this.n = nums.length;
        this.m = multipliers.length;
        this.nums = nums;
        this.multipliers = multipliers;
        this.seen = new int[m][m];
        return topDownDP(0, 0);
    }

    private int topDownDP(int i, int left) {
        if (i != this.m) {
            var mult = multipliers[i];
            var right = n - 1 - (i - left);

            if(seen[i][left] == 0) {
                seen[i][left] = Math.max(mult * nums[left] + topDownDP(i + 1, left + 1),
                        mult * nums[right] + topDownDP(i + 1, left));
            }
            return seen[i][left];
        }
        return 0;
    }
}
