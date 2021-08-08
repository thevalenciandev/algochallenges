package com.thevalenciandev.algorithms.str.palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeTest {

    @Test
    void test() {
        assertTrue(Palindrome.isPalindrome(",."));
        assertTrue(Palindrome.isPalindrome("level"));
        assertFalse(Palindrome.isPalindrome("algorithm"));
        assertTrue(Palindrome.isPalindrome("A man, a plan, a canal: Panama."));
    }

}
