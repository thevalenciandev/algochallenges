package com.thevalenciandev.algorithms.str.firstuniq;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String https://leetcode.com/problems/first-unique-character-in-a-string/
 * <p>
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 */
class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        Map<Character, Integer> indexes = new LinkedHashMap<>(26);

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (indexes.containsKey(letter)) {
                indexes.put(letter, -1); // mark as invalid
            } else {
                indexes.put(letter, i);
            }
        }

        for (Integer index : indexes.values()) {
            if (index != -1) {
                return index;
            }
        }

        return -1;
    }
}