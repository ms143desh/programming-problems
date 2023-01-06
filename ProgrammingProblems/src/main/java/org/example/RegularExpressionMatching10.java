package org.example;

public class RegularExpressionMatching10 {

    public static void main(String[] args) {
        //String s = "aa", p = "a";
        //String s = "aa", p = "a*";
        String s = "abbbcddddeeeeefgh", p = "ab.*cd.*e.*fgh";
        RegularExpressionMatching10 regularExpressionMatching10 = new RegularExpressionMatching10();
        System.out.println(regularExpressionMatching10.isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        boolean match = true;
        if(p.equals(".*")) {
            return match;
        }
        int j = 0, i = 0;
        char chr = p.charAt(j);
        while(i<s.length() && j<p.length()) {
            char ch = s.charAt(i);
            chr = p.charAt(j);
            if(chr == ch || chr == '.') {
                if(!(j+1 < p.length() && p.charAt(j+1) == '*')){
                    j++;
                }
            } else {
                match = false;
            }
            i++;
        }

        if(i != s.length() || (j+1 != p.length() && j+2 != p.length())) {
            match = false;
        }
        return match;
    }
}
