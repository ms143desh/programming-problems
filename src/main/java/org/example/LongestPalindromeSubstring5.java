package org.example;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeSubstring5 {
    public static void main(String[] args) {
        //String input = "babad";
        //String input = "baabad";
        //String input = "cbbd";
        String input = "baabadbfghhgfbd";
        LongestPalindromeSubstring5 longestPalindromeSubstring5 = new LongestPalindromeSubstring5();
        System.out.println(longestPalindromeSubstring5.longestPalindrome(input));
    }

    public String longestPalindrome(String s) {
        if(s.length() == 1) {
            return s;
        }
        int i , j;
        int start = 0, end = 0;
        for(int t=0;t<s.length();t++) {
            i = t;
            j = t + 1;
            while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                if(end-start < j-i){
                    end = j;
                    start = i;
                }
                j++;
                i--;
            }

            i = t;
            j = t + 2;
            while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                if(end-start < j-i){
                    end = j;
                    start = i;
                }
                j++;
                i--;
            }
        }

        return s.substring(start, end + 1);
    }
}