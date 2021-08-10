package com.thevalenciandev.algorithms.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {

    @Test
    void test() {
        assertArrayEquals(new int[]{1, 0}, new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{2, 1}, new TwoSum().twoSum(new int[]{3, 2, 4}, 6));
        assertArrayEquals(new int[]{1, 0}, new TwoSum().twoSum(new int[]{3, 3}, 6));
    }

}