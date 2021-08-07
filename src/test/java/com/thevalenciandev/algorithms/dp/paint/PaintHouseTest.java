package com.thevalenciandev.algorithms.dp.paint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaintHouseTest {

    @Test
    void test1() {

        int[][] costMatrix = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        int costNaive = PaintHouse.findMinimumCostNaive(costMatrix);
        int costDp = PaintHouse.findMinimumCostDp(costMatrix);

        assertEquals(2 + 5 + 3, costNaive);
        assertEquals(2 + 5 + 3, costDp);
    }

    @Test
    void test2() {

        int[][] costMatrix = {{17, 2, 17}, {16, 5, 16}, {14, 3, 19}};
        int cost = PaintHouse.findMinimumCostNaive(costMatrix);
        int costDp = PaintHouse.findMinimumCostDp(costMatrix);

        assertEquals(2 + 16 + 3, cost);
        assertEquals(2 + 16 + 3, costDp);
    }

    @Test
    void test3() {

        int[][] costMatrix = {{17, 2, 17}, {16, 5, 16}, {14, 3, 19}};
        int cost = PaintHouse.findMinimumCostNaive(costMatrix);
        int costDp = PaintHouse.findMinimumCostDp(costMatrix);

        assertEquals(2 + 16 + 3, cost);
        assertEquals(2 + 16 + 3, costDp);
    }

    @Test
    void test4() {

        int[][] costMatrix = {{17, 2, 5}, {16, 5, 16}, {4, 3, 19}};
        int cost = PaintHouse.findMinimumCostNaive(costMatrix);
        int costDp = PaintHouse.findMinimumCostDp(costMatrix);

        // option: 2 + 16(l) + 3 = 21
        // option: 2 + 16(r) + 3 = 21
        // option: 5 + 5 + 4     = 14
        // option: 5 + 16(l) + 3 = 24
        assertEquals(5 + 5 + 4, cost);
        assertEquals(5 + 5 + 4, costDp);
    }

}