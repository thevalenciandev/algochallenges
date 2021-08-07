package com.thevalenciandev.algorithms.dp.paint;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Paint House (https://leetcode.com/problems/paint-house/)
 * <p>
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * <p>
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green,
 * and so on... Find the minimum cost to paint all houses
 */
class PaintHouse {

    public static int findMinimumCostDp(int[][] costMatrix) {
        if (costMatrix == null || costMatrix.length == 0) {
            return 0;
        }

        // Start from index 1 and work the minimum costs for each color option,
        // backwards.
        for (int i = 1; i < costMatrix.length; i++) {
            // We re-use the costMatrix to store the minimum cost so far, to optimise memory
            costMatrix[i][0] = Math.min(costMatrix[i - 1][1] + costMatrix[i][0], costMatrix[i - 1][2] + costMatrix[i][0]);
            costMatrix[i][1] = Math.min(costMatrix[i - 1][0] + costMatrix[i][1], costMatrix[i - 1][2] + costMatrix[i][1]);
            costMatrix[i][2] = Math.min(costMatrix[i - 1][0] + costMatrix[i][2], costMatrix[i - 1][1] + costMatrix[i][2]);
        }

        // The last index will have the minimum cost for each of the options
        // So we just need to pick the minimum of all three combos and return it.
        int lastIndex = costMatrix.length - 1;
        return Math.min(Math.min(costMatrix[lastIndex][0], costMatrix[lastIndex][1]), costMatrix[lastIndex][2]);
    }

    public static int findMinimumCostNaive(int[][] costMatrix) {

        int costStartingRed = minimumCostHelper(costMatrix, costMatrix[0][0], 1, 0); // red
        int costStartingBlue = minimumCostHelper(costMatrix, costMatrix[0][1], 1, 1); // blue
        int costStartingGreen = minimumCostHelper(costMatrix, costMatrix[0][2], 1, 2); // green
        return Stream.of(costStartingRed, costStartingBlue, costStartingGreen).min(Comparator.comparing(Integer::intValue)).get();
    }

    private static int minimumCostHelper(int[][] costMatrix, int carriedCost, int currentHouseIndex, int previousHouseColor) {
        if (currentHouseIndex == costMatrix.length) {
            return carriedCost; // base case
        }

        int nextHouseIndex = currentHouseIndex + 1;
        if (previousHouseColor == 0) { // red
            int costBlue = minimumCostHelper(costMatrix, carriedCost + costMatrix[currentHouseIndex][1], nextHouseIndex, 1);
            int costGreen = minimumCostHelper(costMatrix, carriedCost + costMatrix[currentHouseIndex][2], nextHouseIndex, 2);
            return Math.min(costBlue, costGreen);
        } else if (previousHouseColor == 1) { // blue
            int costRed = minimumCostHelper(costMatrix, carriedCost + costMatrix[currentHouseIndex][0], nextHouseIndex, 0);
            int costGreen = minimumCostHelper(costMatrix, carriedCost + costMatrix[currentHouseIndex][2], nextHouseIndex, 2);
            return Math.min(costRed, costGreen);
        } else { // 2 = green
            int costRed = minimumCostHelper(costMatrix, carriedCost + costMatrix[currentHouseIndex][0], nextHouseIndex, 0);
            int costBlue = minimumCostHelper(costMatrix, carriedCost + costMatrix[currentHouseIndex][1], nextHouseIndex, 1);
            return Math.min(costRed, costBlue);
        }
    }
}
