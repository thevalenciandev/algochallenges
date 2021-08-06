package com.thevalenciandev.algorithms.other.maxpop;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/maximum-population-year/
 * <p>
 * You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.
 * <p>
 * The population of some year x is the number of people alive during that year.
 * The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1].
 * Note that the person is not counted in the year that they die.
 * <p>
 * Return the earliest year with the maximum population.
 */
class MaximumPopulation {

    public int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> yearCounts = new TreeMap<>();
        for (int y = 1950; y <= 2050; y++) {
            yearCounts.put(y, 0);
        }
        for (int year = 1950; year <= 2050; year++) {
            for (int[] log : logs) {
                int birth = log[0];
                int death = log[1];
                if (wasAlive(year, birth, death)) {
                    yearCounts.compute(year, (k, count) -> count + 1);
                }
            }
        }

        return yearCounts.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElseThrow();
    }

    private static boolean wasAlive(int year, int birth, int death) {
        return birth <= year && death > year;
    }
}