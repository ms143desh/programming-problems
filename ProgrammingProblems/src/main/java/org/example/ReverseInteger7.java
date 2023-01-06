package org.example;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */
public class ReverseInteger7 {
    public static void main(String[] args) {
        //int input = 123;
        System.out.println(Integer.MIN_VALUE);
        int input = Integer.MAX_VALUE;
        ReverseInteger7 reverseInteger7 = new ReverseInteger7();
        System.out.println(reverseInteger7.reverse(input));
    }

    public int reverse(int x) {
        int mr = Integer.MAX_VALUE;
        int c = 0;
        int value = 0;
        boolean negative = false;
        if(x < 0) {
            negative = true;
            x = -x;
        }
        while(x > 0) {
            int l = x % 10;
            if(validateMax(mr, value, l)) {
                value = (value * 10) + l;
            } else {
                value = 0;
                break;
            }
            x = x/10;
            c++;
        }

        if(negative) {
            value = -value;
        }
        return value;
    }

    private boolean validateMax(int mr, int value, int l) {
        boolean valid = true;
        for(int i=1;i<=10;i++) {
            if(mr - value < 0) {
                valid = false;
                break;
            } else {
                mr = mr - value;
            }
        }
        return valid;
    }
}
