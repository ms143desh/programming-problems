package org.example;

public class PalindromeNumber9 {
    public static void main(String[] args) {
        //int input = -121;
        //int input = 10;
        //int input = 0;
        int input = 123;
        PalindromeNumber9 palindromeNumber9 = new PalindromeNumber9();
        System.out.println(palindromeNumber9.isPalindrome(input));
    }

    public boolean isPalindrome(int x) {
        if(x == 0) {
            return true;
        }
        if(x < 0 || x % 10 == 0) {
            return false;
        }

        int num = 0, temp = x;
        while(temp > 0) {
            num = (num * 10) + (temp % 10);
            temp = temp/10;
        }

        if(num == x) {
            return true;
        } else {
            return false;
        }
    }

}
