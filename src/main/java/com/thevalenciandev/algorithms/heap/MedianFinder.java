package com.thevalenciandev.algorithms.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream https://leetcode.com/problems/find-median-from-data-stream/
 * <p>
 * The median is the middle value in an ordered integer list. If the size of the list is even,
 * there is no middle value and the median is the mean of the two middle values.
 * <p>
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * <p>
 * Implement the MedianFinder class:
 * <p>
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 * <p>
 * Constraints:
 * <p>
 * -105 <= num <= 105
 * There will be at least one element in the data structure before calling findMedian.
 * At most 5 * 104 calls will be made to addNum and findMedian.
 */
class MedianFinder {

    private final PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
    private final PriorityQueue<Integer> right = new PriorityQueue<>(); // natural ordering

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
    }

    public void addNum(int num) {
        if (left.isEmpty() || left.peek() > num) {
            left.add(num);
        } else {
            right.add(num);
        }
        // invariant: the sizes should be the same, or at most, different only by one element
        if (Math.abs(left.size() - right.size()) > 1) {
            // the code below will "re-balance" the queues
            // l=2,3  r=4,5,6,7 ==> l=2,3,4  r=5,6,7
            if (right.size() > left.size()) {
                left.add(right.poll());
            } else {
                right.add(left.poll());
            }
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return ((double) (left.peek() + right.peek()) / 2);
        } else if (left.size() > right.size()) {
            return left.peek();
        } else {
            return right.peek();
        }
    }

}
