package org.example.contest.biweekly;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctAverages2465 {
    public static void main(String[] args) {
        NumberOfDistinctAverages2465 numberOfDistinctAverages2465 = new NumberOfDistinctAverages2465();
        System.out.println(numberOfDistinctAverages2465.distinctAverages(new int[]{4,1,4,0,3,5}));
        System.out.println(numberOfDistinctAverages2465.distinctAverages(new int[]{1, 100}));
        System.out.println(numberOfDistinctAverages2465.distinctAverages(new int[]{6,2,5}));
        System.out.println(numberOfDistinctAverages2465.distinctAverages(new int[]{1,5,3,2,2}));
    }

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Double> avgSet = new HashSet<>();
        int leftIndex = 0, rightIndex = nums.length-1, left = 0, right = 0;
        while(leftIndex < rightIndex) {
            left = nums[leftIndex];
            right = nums[rightIndex];
            avgSet.add((double)(left + right)/2);
            leftIndex++;
            rightIndex--;
        }

        if(leftIndex == rightIndex) {
            avgSet.add((double)nums[leftIndex]);
        }
        return avgSet.size();
    }
}
