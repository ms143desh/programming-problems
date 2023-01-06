package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumConsecutiveCardsToPickUp2260 {
    public static void main(String[] args) {
        //int[] input = {3,4,2,3,4,7};
        int[] input = {1,0,5,3};
        MinimumConsecutiveCardsToPickUp2260 minimumConsecutiveCardsToPickUp2260 = new MinimumConsecutiveCardsToPickUp2260();
        System.out.println(minimumConsecutiveCardsToPickUp2260.minimumCardPickup(input));
    }

    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<cards.length;i++) {
            int index = indexMap.getOrDefault(cards[i], -1);
            if(index == -1) {
                index = i;
            } else if(i - index + 1 < min) {
                min = i - index +  1;
            }
            indexMap.put(cards[i], i);
        }
        if(min == Integer.MAX_VALUE) {
            min = -1;
        }
        return min;
    }
}
