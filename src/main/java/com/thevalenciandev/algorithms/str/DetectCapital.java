package com.thevalenciandev.algorithms.str;

import java.util.function.Predicate;

/**
 * 520. Detect Capital https://leetcode.com/problems/detect-capital/
 * <p>
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * <p>
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * <p>
 * Given a string word, return true if the usage of capitals in it is right.
 * <p>
 * Constraints:
 * <p>
 * 1 <= word.length <= 100
 * word consists of lowercase and uppercase English letters.
 */
public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        return isAllCaps(word) || isAllSmallLetters(word) || isCapitalised(word);
    }

    private static boolean isAllCaps(String word) {
        return falseIfAnyLetterIs(l -> !Character.isUpperCase(l), word);
    }

    private static boolean isAllSmallLetters(String word) {
        return falseIfAnyLetterIs(Character::isUpperCase, word);
    }

    private static boolean falseIfAnyLetterIs(Predicate<Character> predicate, String word) {
        for (char l : word.toCharArray()) {
            if (predicate.test(l)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCapitalised(String word) {
        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                return false;
            }
        }
        return Character.isUpperCase(word.charAt(0));
    }
}
