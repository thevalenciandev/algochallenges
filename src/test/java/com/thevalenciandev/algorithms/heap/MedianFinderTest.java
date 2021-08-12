package com.thevalenciandev.algorithms.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianFinderTest {

    @Test
    void test() {
        var medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        assertEquals(1.5, medianFinder.findMedian());
        medianFinder.addNum(3);
        assertEquals(2.0, medianFinder.findMedian());
    }

    @Test
    void test2() {
        var medianFinder = new MedianFinder();
        medianFinder.addNum(5);
        assertEquals(5.0, medianFinder.findMedian());
        medianFinder.addNum(3);
        assertEquals(4.0, medianFinder.findMedian());
        medianFinder.addNum(1);
        medianFinder.addNum(1);
        assertEquals(2.0, medianFinder.findMedian()); //1,1,3,5
        medianFinder.addNum(5);
        medianFinder.addNum(8);
        assertEquals(4.0, medianFinder.findMedian()); //1,1,3,5,5,8
    }

    @Test
    void test3() {
        var medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian());
        medianFinder.addNum(10);
        assertEquals(8.0, medianFinder.findMedian());
        medianFinder.addNum(2);
        assertEquals(6.0, medianFinder.findMedian());
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian());
        medianFinder.addNum(5);
        assertEquals(6.0, medianFinder.findMedian()); // 2,5,6,6,10
        medianFinder.addNum(0);
        assertEquals(5.5, medianFinder.findMedian()); // 0,2,5,6,6,10
        medianFinder.addNum(6);
        assertEquals(6.0, medianFinder.findMedian()); // 0,2,5,6,6,6,10
        medianFinder.addNum(3);
        assertEquals(5.5, medianFinder.findMedian());
        medianFinder.addNum(1);
        assertEquals(5.0, medianFinder.findMedian());
        medianFinder.addNum(0);
        assertEquals(4.0, medianFinder.findMedian());
        medianFinder.addNum(0);
        assertEquals(3.0, medianFinder.findMedian());
    }

    @Test
    void test4() {
        var medianFinder = new MedianFinder();
        medianFinder.addNum(12);
        assertEquals(12.0, medianFinder.findMedian());
        medianFinder.addNum(10);
        assertEquals(11.0, medianFinder.findMedian());
        medianFinder.addNum(13);
        assertEquals(12.0, medianFinder.findMedian()); // 10,12,13
        medianFinder.addNum(11);
        assertEquals(11.5, medianFinder.findMedian()); // 10,11,12,12
    }

}
