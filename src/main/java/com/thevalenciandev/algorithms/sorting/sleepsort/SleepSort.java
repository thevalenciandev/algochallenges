package com.thevalenciandev.algorithms.sorting.sleepsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Horrible sorting algo:
 * Spawn a thread per integer given, and:
 * 1. Make it sleep the integer units of time
 * 2. Add the num to some collection
 * After this, the collection should be sorted, at which point we should return it.
 */
public class SleepSort {

    public static List<Integer> sort(List<Integer> nums, TimeUnit timeUnit) {
        if (nums.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> sortedNums = new ArrayList<>(nums.size());
        List<Thread> sleepers = new ArrayList<>(nums.size());
        CountDownLatch waitForThreadsToFinish = new CountDownLatch(nums.size());

        // Prepare all threads first, to avoid the overhead later
        for (int num : nums) {
            Thread sleeper = new Thread(() -> sleepAndAddNumberTo(sortedNums, num, timeUnit, waitForThreadsToFinish));
            sleepers.add(sleeper);
        }
        // Threads, go!
        sleepers.forEach(Thread::start);

        waitForThreadsToFinish(waitForThreadsToFinish);
        return sortedNums;
    }

    private static void sleepAndAddNumberTo(List<Integer> sortedNums, int num, TimeUnit timeUnit, CountDownLatch sorted) {
        try {
            TimeUnit.valueOf(timeUnit.name()).sleep(num);
            synchronized (SleepSort.class) {
                sortedNums.add(num);
            }
            sorted.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void waitForThreadsToFinish(CountDownLatch waitForThreadsToFinish) {
        try {
            waitForThreadsToFinish.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
