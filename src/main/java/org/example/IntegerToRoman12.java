package org.example;

public class IntegerToRoman12 {
    public static void main(String[] args) {
        //int input = 3999;//MMMCMXCIX
        //int input = 49;//XLIX
        //int input = 3000;//MMM
        //int input = 4;//IV
        int input = 58;//LVIII

//        Symbol       Value
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
//        I can be placed before V (5) and X (10) to make 4 and 9.
//        X can be placed before L (50) and C (100) to make 40 and 90.
//        C can be placed before D (500) and M (1000) to make 400 and 900.

        IntegerToRoman12 integerToRoman12 = new IntegerToRoman12();
        System.out.println(integerToRoman12.intToRoman(input));
    }

    StringBuffer sb = new StringBuffer("");
    public String intToRoman(int num) {
        int[] romanNumberArray = {1000, 500, 100, 50, 10, 5, 1};
        int quotient = 0, remainder = 0, index = 0;

        while(index < romanNumberArray.length || num > 0) {
            quotient = num / romanNumberArray[index];
            remainder = num % romanNumberArray[index];
            switch(romanNumberArray[index]) {
                case 1000:
                    appendRoman('M', quotient);
                    num = appendRomanForDivisor(remainder, 100, 9, "CM");
                    break;
                case 500:
                    num = appendRomanFor1('D', quotient, remainder);
                    num = appendRomanForDivisor(remainder, 100, 4, "CD");
                    break;
                case 100:
                    appendRoman('C', quotient);
                    num = appendRomanForDivisor(remainder, 10, 9, "XC");
                    break;
                case 50:
                    num = appendRomanFor1('L', quotient, remainder);
                    num = appendRomanForDivisor(remainder, 10, 4, "XL");
                    break;
                case 10:
                    appendRoman('X', quotient);
                    num = appendRomanForDivisor(remainder, 1, 9, "IX");
                    break;
                case 5:
                    num = appendRomanFor1('V', quotient, remainder);
                    num = appendRomanForDivisor(remainder, 1, 4, "IV");
                    break;
                case 1:
                    if(quotient < 4) {
                        appendRoman('I', quotient);
                        num = remainder;
                    }
                    break;
            }
            index++;
        }
        return sb.toString();
    }

    private void appendRoman(char ch, int quotient) {
        for(int i=0;i<quotient;i++) {
            sb.append(ch);
        }
    }

    private int appendRomanFor1(char ch, int quotient, int remainder) {
        if(quotient == 1) {
            sb.append(ch);
        }
        return remainder;
    }

    private int appendRomanForDivisor(int num, int divisor, int numCase, String str) {
        if(num / divisor == numCase) {
            sb.append(str);
            num = num - (divisor * numCase);
        }
        return num;
    }

}
