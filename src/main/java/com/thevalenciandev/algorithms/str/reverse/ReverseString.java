package com.thevalenciandev.algorithms.str.reverse;

/**
 * 344. Reverse String. https://leetcode.com/problems/reverse-string/
 * In-place reverse.
 * Space complexity: O(1)
 * Time complexity: O(n) (n/2 swaps)
 */
class ReverseString {

    static char[] reverse(char[] str) {
        if (str == null) {
            return null;
        }
        for (int i = 0, j = str.length - 1; i < j; i++, j--) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }
        return str;
    }

}
