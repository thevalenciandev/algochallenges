package com.thevalenciandev.algorithms.str.anagram;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram https://leetcode.com/problems/valid-anagram/
 * <p>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 */
class Anagram {

    public static boolean isAnagram(String fst, String snd) {
        Map<Character, Integer> counts = initialiseCounts(fst);

        for (char letter : snd.toCharArray()) {
            counts.compute(letter, (k, count) -> {
                if (count == null) {
                    return 1;
                } else {
                    return count - 1;
                }
            });
        }

        return counts.values().stream().noneMatch(v -> v != 0);
    }

    private static Map<Character, Integer> initialiseCounts(String str) {
        Map<Character, Integer> counts = new HashMap<>();

        for (char letter : str.toCharArray()) {
            counts.compute(letter, (k, count) -> {
                if (count == null) {
                    return 1;
                } else {
                    return count + 1;
                }
            });
        }

        return counts;
    }
}
