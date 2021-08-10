package com.thevalenciandev.algorithms.str;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DetectCapitalTest {

    @Test
    void test() {
        assertTrue(new DetectCapital().detectCapitalUse("USA"));
        assertTrue(new DetectCapital().detectCapitalUse("Google"));
        assertTrue(new DetectCapital().detectCapitalUse("leetcode"));
        assertFalse(new DetectCapital().detectCapitalUse("FlaG"));
    }
}