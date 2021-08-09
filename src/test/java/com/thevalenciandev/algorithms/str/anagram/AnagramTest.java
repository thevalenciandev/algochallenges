package com.thevalenciandev.algorithms.str.anagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnagramTest {

    @Test
    void test() {
        assertTrue(Anagram.isAnagram("anagram", "nagaram"));
        assertFalse(Anagram.isAnagram("rat", "car"));
    }

}