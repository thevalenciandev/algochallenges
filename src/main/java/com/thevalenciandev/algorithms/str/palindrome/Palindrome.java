package com.thevalenciandev.algorithms.str.palindrome;

/**
 * 125. Valid Palindrome. https://leetcode.com/problems/valid-palindrome/
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 */
class Palindrome {

    static boolean isPalindrome(String str) {

        char[] s = str.toCharArray();
        int i = 0, j = s.length - 1;
        while (i < j) {
            while (i < s.length && !isAlphanumeric(s[i])) {
                i++;
            }
            while (j > 0 && !isAlphanumeric(s[j])) {
                j--;
            }
            if (i > j) {
                return true;
            }
            if (Character.toLowerCase(s[i]) != Character.toLowerCase(s[j])) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    private static boolean isAlphanumeric(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
