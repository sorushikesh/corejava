package com.corejava.dsa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongestPalindrome {

    private static final Logger logger = LoggerFactory.getLogger(LongestPalindrome.class);

    public static void main(String[] args) {
        String palindromeString = "hello";
        String result = longestPalindrome(palindromeString);
        logger.info("Longest Palindromic Substring: {}", result);
    }

    public static String longestPalindrome(String s) {
        logger.info("Processing string: {}", s);

        if (s == null || s.isEmpty()) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
