package com.thevalenciandev.algorithms.sorting.sleepsort;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SleepSortTest {

    @Test
    void canSort() {
        List<Integer> sorted = SleepSort.sort(List.of(1, 4, 1, 3, 2), TimeUnit.MILLISECONDS);
        assertEquals(List.of(1, 1, 2, 3, 4), sorted);
    }

}