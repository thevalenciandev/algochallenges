package com.thevalenciandev.algorithms.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClimbStairsTest {

    @Test
    void test() {
        assertEquals(2, new ClimbStairs().climbStairs(2));
        assertEquals(1836311903, new ClimbStairs().climbStairs(45));
    }

}