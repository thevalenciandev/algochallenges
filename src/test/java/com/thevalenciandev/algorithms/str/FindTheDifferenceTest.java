package com.thevalenciandev.algorithms.str;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheDifferenceTest {

    @Test
    void test() {
        assertEquals('e', new FindTheDifference().findTheDifference("abcd", "abcde"));
        assertEquals('y', new FindTheDifference().findTheDifference("", "y"));
        assertEquals('a', new FindTheDifference().findTheDifference("ae", "aea"));
        assertEquals('i', new FindTheDifference().findTheDifference("aaaaaeaabbbbdwwwwdww", "aaaaaeaabbbbdwwiwwdww"));
    }

}