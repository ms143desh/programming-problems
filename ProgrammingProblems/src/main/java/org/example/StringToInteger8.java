package org.example;

import java.math.BigInteger;

public class StringToInteger8 {
    public static void main(String[] args) {
        /*
"42"
"   -42"
"4193 with words"
"00041093 with words"
"-91283472332"
"-8765432109876543210987654321098765432109876543210987654321098765432109876543210987654321098765432109876543210987654321098765432109876543210987654321098765432109876543210987654321098765432109876543210"
"0000000-1298989203p3929"
"-12+89"
"-+12+89"
"00000-42a1234"
"-000000009000001"
"   +0 123"
"2147483648"
         */
        //String input = "00041093 with words";
        //String input = "words and 987";
        //String input = "-91283472332";
        //String input = "-8765432109876543210987654321098765432109876543210987654321098765432109876543210987654321098765432109876543210987654321098765432109876543210987654321098765432109876543210987654321098765432109876543210";
        //String input = "0000000-1298989203p3929";
        //String input = "-12+89";
        //String input = "-+12+89";
        //String input = "00000-42a1234";
        //String input = "-000000009000001";
        //String input = "   +0 123";
        String input = "2147483648";
        StringToInteger8 stringToInteger8 = new StringToInteger8();
        System.out.println(stringToInteger8.myAtoi(input));
    }

    public int myAtoi(String s) {
        String strNumber = "";
        boolean blankChar = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch != ' ') {
                if(!(ch == '0' && (strNumber == "" || (strNumber.length() == 1 && (strNumber.charAt(0) == '-' || strNumber.charAt(0) == '+'))))) {
                    if(ch >= '0' && ch <= '9') {
                        strNumber = strNumber.concat(Character.toString(ch));
                    } else if((ch == '-' || ch == '+') && strNumber == "") {
                        if(blankChar) {
                            strNumber = strNumber.concat(Character.toString(ch));
                        }
                        else {
                            strNumber = "";
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
                blankChar = false;
            } else if(!blankChar) {
                break;
            }
        }

        if(!strNumber.equals("") && !strNumber.equals("+") && !strNumber.equals("-")) {
            String maxInt = String.valueOf(Integer.MAX_VALUE);
            if(strNumber.charAt(0) == '+') {
                strNumber = strNumber.substring(1, strNumber.length());
            } else if(strNumber.charAt(0) == '-') {
                maxInt = String.valueOf(Integer.MIN_VALUE);
            }

            if(strNumber.length() == maxInt.length()) {
                for(int i=0;i<maxInt.length();i++) {
                    if(strNumber.charAt(i) > maxInt.charAt(i)) {
                        strNumber = maxInt;
                        break;
                    } else if(strNumber.charAt(i) < maxInt.charAt(i)) {
                        break;
                    }
                }
            } else if(strNumber.length() > maxInt.length()){
                strNumber = maxInt;
            }
        }

        if(!strNumber.equals("") && !strNumber.equals("+") && !strNumber.equals("-")) {
            return Integer.valueOf(strNumber);
        } else {
            return 0;
        }
    }
}
