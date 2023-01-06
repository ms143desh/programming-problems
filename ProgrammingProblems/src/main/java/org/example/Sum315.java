package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum315 {
    public static void main(String[] args) {
        int[] input = {-1,0,1,2,-1,-4};
        Sum315 sum315 = new Sum315();
        List<List<Integer>> output = sum315.threeSum(input);
        System.out.println("finished");
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> output = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                int numRequired = 0 - nums[i] - nums[j];
                int numRequiredIndex = Arrays.binarySearch(nums, numRequired);
                if(numRequiredIndex >= 0 && numRequiredIndex != i && numRequiredIndex != j) {
                    List<Integer> sumList = new ArrayList<>();
                    if(nums[numRequiredIndex] < nums[i]) {
                        sumList.add(nums[numRequiredIndex]);
                        sumList.add(nums[i]);
                        sumList.add(nums[j]);
                    } else if(nums[numRequiredIndex] < nums[j]) {
                        sumList.add(nums[i]);
                        sumList.add(nums[numRequiredIndex]);
                        sumList.add(nums[j]);
                    } else {
                        sumList.add(nums[i]);
                        sumList.add(nums[j]);
                        sumList.add(nums[numRequiredIndex]);
                    }
                    output.add(sumList);
                }
            }
        }
        return new ArrayList<>(output);
    }
}
