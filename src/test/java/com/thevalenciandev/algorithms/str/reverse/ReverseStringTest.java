package com.thevalenciandev.algorithms.str.reverse;

import org.junit.jupiter.api.Test;

import static com.thevalenciandev.algorithms.str.reverse.ReverseString.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReverseStringTest {

    @Test
    void test() {
        assertArrayEquals("".toCharArray(), reverse("".toCharArray()));
        assertArrayEquals("taC".toCharArray(), reverse("Cat".toCharArray()));
        assertArrayEquals("The Daily Byte".toCharArray(), reverse("etyB yliaD ehT".toCharArray()));
        assertArrayEquals("civic".toCharArray(), reverse("civic".toCharArray()));
    }

}