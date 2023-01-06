package org.example.contest.biweekly;

import org.example.ApplyOperationsToArray2460;

public class OddStringDifference2451 {
    public static void main(String[] args) {
        OddStringDifference2451 oddStringDifference2451 = new OddStringDifference2451();
        System.out.println(oddStringDifference2451.oddString(new String[]{"adc","wzy","abc"}));
        System.out.println(oddStringDifference2451.oddString(new String[]{"aaa","bob","ccc","ddd"}));
    }

    public String oddString(String[] words) {
        int firstDifference = 0, secondDifference = 0, thirdDifference = 0;
        int defaultIndex = -1, negativeIndex = -1;
        for(int j=0;j<words[0].length()-1;j++) {
            firstDifference = words[0].charAt(j+1) - words[0].charAt(j);
            secondDifference = words[1].charAt(j+1) - words[1].charAt(j);
            thirdDifference = words[2].charAt(j+1) - words[2].charAt(j);
            if(firstDifference == secondDifference) {
                defaultIndex = 0;
                if(secondDifference != thirdDifference) {
                    negativeIndex = 2;
                }
            } else if(firstDifference == thirdDifference){
                defaultIndex = 0;
                negativeIndex = 1;
            } else if(secondDifference == thirdDifference) {
                defaultIndex = 1;
                negativeIndex = 0;
            }
        }
        if(negativeIndex == -1) {
            int[] defaultDifference = new int[words[defaultIndex].length()-1];
            for(int j=0;j<words[defaultIndex].length()-1;j++) {
                defaultDifference[j] = words[defaultIndex].charAt(j+1) - words[defaultIndex].charAt(j);
            }

            w:for(int i=3;i<words.length; i++) {
                for(int j=0;j<words[i].length()-1;j++) {
                    if(words[i].charAt(j+1) - words[i].charAt(j) != defaultDifference[j]) {
                        negativeIndex = i;
                        break w;
                    }
                }

            }
        }
        return words[negativeIndex];
    }
}
