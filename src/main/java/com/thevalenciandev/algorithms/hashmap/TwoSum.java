package com.thevalenciandev.algorithms.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum https://leetcode.com/problems/two-sum/
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int neededNumber = target - nums[i];
            if (cache.containsKey(neededNumber)) {
                return new int[]{i, cache.get(neededNumber)};
            } else {
                cache.put(nums[i], i);
            }
        }

        throw new RuntimeException("Should not happen.");
    }
}
