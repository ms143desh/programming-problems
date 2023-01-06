package org.example;

public class RemoveDigitFromNumbertToMaximizeResult2259 {
    public static void main(String[] args) {
        //String input = "2998589353917872714814599237991174513476623756395992135212546127959342974628712329595771672911914471";
        String input = "123";
        char digit = '2';
        RemoveDigitFromNumbertToMaximizeResult2259 removeDigitFromNumbertToMaximizeResult2259 = new RemoveDigitFromNumbertToMaximizeResult2259();
        System.out.println(removeDigitFromNumbertToMaximizeResult2259.removeDigit(input, digit));
    }

    public String removeDigit(String number, char digit) {
        int index = number.indexOf(digit, 0);
        String maxNum = "";
        String num = "";
        while(index >= 0) {
            if(index == 0) {
                num = number.substring(1, number.length());
            } else if(index == number.length()-1) {
                num = number.substring(0, number.length()-1);
            } else {
                num = number.substring(0, index).concat(number.substring(index+1,number.length()));
            }
            maxNum = validateMax(num, maxNum);
            index = number.indexOf(digit, index+1);
        }
        return String.valueOf(maxNum);
    }

    private String validateMax(String strNumber, String maxNumber) {
        if(maxNumber == "") {
            maxNumber = strNumber;
        } else if(strNumber.length() == maxNumber.length()) {
            for(int i=0;i<strNumber.length();i++) {
                if(strNumber.charAt(i) > maxNumber.charAt(i)) {
                    maxNumber = strNumber;
                    break;
                } else if(strNumber.charAt(i) < maxNumber.charAt(i)) {
                    break;
                }
            }
        } else if(strNumber.length() > maxNumber.length()){
            maxNumber = strNumber;
        }
        return maxNumber;
    }
}
