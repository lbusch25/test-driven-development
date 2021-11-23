package com.lawson.testdrivendevelopment.search.breadthdepth;

import java.util.ArrayDeque;
import java.util.Deque;

public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return breadthFirstSearch(image, sr, sc, newColor);
    }

    private static int[][] breadthFirstSearch(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor) {
            bfs(image, sr, sc, newColor, oldColor);
        }
        return image;
    }

    /*
     * Need to abstract out dfs because stack for 2d array is much too large
     */
    private static int[][] depthFirstSearch(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor) {
            dfs(image, sr, sc, newColor, oldColor);
        }
        return image;
    }

    private static void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
            if (sr > 0) {
                dfs(image, sr - 1, sc, newColor, oldColor);
            }
            if (sc > 0) {
                dfs(image, sr, sc - 1, newColor, oldColor);
            }
            if (sc < image[0].length - 1) {
                dfs(image, sr, sc + 1, newColor, oldColor);
            }
            if (sr < image.length - 1) {
                dfs(image, sr + 1, sc, newColor, oldColor);
            }
        }
    }

    private static void bfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        Deque<BFSNode> queue = new ArrayDeque<>();
        queue.add(new BFSNode(sr, sc));
        while(!queue.isEmpty()) {
            BFSNode n = queue.poll();
            if (image[n.r][n.c] == oldColor) {
                image[n.r][n.c] = newColor;
                if (n.r > 0) {
                    queue.add(new BFSNode(n.r - 1, n.c));
                }
                if (n.c > 0) {
                    queue.add(new BFSNode(n.r, n.c - 1));
                }
                if (n.c < image[0].length - 1) {
                    queue.add(new BFSNode(n.r, n.c + 1));
                }
                if (n.r < image.length - 1) {
                    queue.add(new BFSNode(n.r + 1, n.c));
                }
            }
        }
    }

    private static class BFSNode {

        public BFSNode(Integer r, Integer c) {
            this.r = r;
            this.c = c;
        }

        protected Integer r;
        protected Integer c;
    }
}
