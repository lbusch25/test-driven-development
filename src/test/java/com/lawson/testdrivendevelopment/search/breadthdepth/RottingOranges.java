package com.lawson.testdrivendevelopment.search.breadthdepth;

public class RottingOranges {

    /**
     * NOTE: DO NOT BE AFRAID TO UTILIZE SIMPLE SOLUTIONS
     * OR PRE SEARCH FOR HELPFUL DATA
     *
     * YOU ARE TOO CONCERNED ABOUT RUN TIME AND PRE OPTIMIZATION
     * SOLVE FIRST THEN LOOK FOR BETTER SOLUTIONS
     */

    /**
     * Really what I'm doing is looking for two things
     * A) can every 1 be infected by a 2
     *      if not return -1
     * B) How many BFS iterations until all 1s are 2s
     *      return # of iterations
     *
     * Can keep track of 1) queue of rotten positions (and rounds using a pointer)
     * 2) number of fresh oranges
     *
     * If after search ends still have fresh oranges - its impossible
     *
     *
     *
     * @param grid grid of 0, 1, 2
     * @return number of bfs iterations until all 1s are a 2
     */
    public int orangesRotting(int[][] grid) {
        return -1;
    }
}
