package com.thevalenciandev.algorithms.dp;

/**
 * 70. Climbing Stairs https://leetcode.com/problems/climbing-stairs/
 * <p>
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 45
 */
class ClimbStairs {

    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            cache[i] = -1;
        }
        return climbStairs(n, cache);
    }

    private static int climbStairs(int n, int[] cache) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            if (cache[n] != -1) {
                return cache[n];
            }
            int withOne = climbStairs(n - 1, cache);
            int withTwo = climbStairs(n - 2, cache);
            cache[n] = withOne + withTwo;
            return cache[n];
        }
    }
}
