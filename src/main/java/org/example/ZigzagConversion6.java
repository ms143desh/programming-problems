package org.example;

public class ZigzagConversion6 {
    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        int rows = 3;
        ZigzagConversion6 zigzagConversion6 = new ZigzagConversion6();
        System.out.println(zigzagConversion6.convert(input, rows));
    }

    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }

        StringBuffer outputBuffer = new StringBuffer("");
        for(int i=0;i<numRows;i++) {
            int iteration = 0;
            int index = 0;
            while(i + index < s.length()) {
                outputBuffer.append(s.charAt(i + index));
                iteration++;
                if(i == 0) {
                    index += (numRows - i - 1) * 2;
                } else if(i == numRows - 1) {
                    index += i * 2;
                } else if(iteration % 2 != 0) {
                    index += (numRows - i - 1) * 2;
                } else {
                    index += i * 2;
                }
            }
        }
        return outputBuffer.toString();
    }

}
