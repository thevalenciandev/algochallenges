package com.thevalenciandev.algorithms.str.firstuniq;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstUniqueCharacterTest {

    @Test
    void test() {
        assertEquals(0, new FirstUniqueCharacter().firstUniqChar("leetcode"));
        assertEquals(2, new FirstUniqueCharacter().firstUniqChar("loveleetcode"));
        assertEquals(-1, new FirstUniqueCharacter().firstUniqChar("aabb"));
        assertEquals(8, new FirstUniqueCharacter().firstUniqChar("dddccdbba"));
    }

}