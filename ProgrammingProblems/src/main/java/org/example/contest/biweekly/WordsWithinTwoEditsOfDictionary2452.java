package org.example.contest.biweekly;

import java.util.ArrayList;
import java.util.List;

public class WordsWithinTwoEditsOfDictionary2452 {

    public static void main(String[] args) {
        WordsWithinTwoEditsOfDictionary2452 wordsWithinTwoEditsOfDictionary2452 = new WordsWithinTwoEditsOfDictionary2452();
        System.out.println(wordsWithinTwoEditsOfDictionary2452.twoEditWords(new String[]{"word","note","ants","wood"}, new String[]{"wood","joke","moat"}));
        System.out.println(wordsWithinTwoEditsOfDictionary2452.twoEditWords(new String[]{"yes"}, new String[]{"not"}));
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> output = new ArrayList<>();
        for(int i=0;i<queries.length; i++) {
            for(int j=0;j<dictionary.length;j++) {
                int difference = 0;
                for(int k=0;k<queries[i].length();k++) {
                    if(queries[i].charAt(k) != dictionary[j].charAt(k)) {
                        difference++;
                    }
                }
                if(difference <= 2) {
                    output.add(queries[i]);
                    break;
                }
            }
        }
        return output;
    }
}
