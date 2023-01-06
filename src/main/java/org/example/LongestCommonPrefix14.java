package org.example;

public class LongestCommonPrefix14 {
    public static void main(String[] args) {
        //String[] input = {"flower","flow","flight"};
        String[] input = {"ab","a"};
        LongestCommonPrefix14 longestCommonPrefix14 = new LongestCommonPrefix14();
        System.out.println(longestCommonPrefix14.longestCommonPrefix(input));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) {
            return strs[0];
        }
        int i = 0;
        outer:for(i=0;i<strs[0].length();i++) {
            boolean charPrefix = true;
            for(int j=1;j<strs.length;j++) {
                if(strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    break outer;
                }
            }
        }

        return strs[0].substring(0, i);
    }
}
