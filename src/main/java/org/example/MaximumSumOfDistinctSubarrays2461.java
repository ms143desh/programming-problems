package org.example;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumOfDistinctSubarrays2461 {
    public static void main(String[] args) {
        int[] input = {1,5,4,2,9,9,9};
        int k = 3;
        MaximumSumOfDistinctSubarrays2461 maximumSumOfDistinctSubarrays2461 = new MaximumSumOfDistinctSubarrays2461();
        System.out.print(maximumSumOfDistinctSubarrays2461.maximumSubarraySum(input, k));
    }

    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, tempSum = 0;
        int count = 0;
        Map<Integer, Integer> numCountMap = new HashMap<>();

        for(int i=0;i<=nums.length-k;i++) {
            if(i != 0) {
                tempSum -= nums[i-1];
                count = numCountMap.get(nums[i-1]);
                if(count == 1) {
                    numCountMap.remove(nums[i-1]);
                } else {
                    numCountMap.put(nums[i-1], count - 1);
                }
                tempSum += nums[i+k-1];
                count = numCountMap.getOrDefault(nums[i+k-1], 0);
                numCountMap.put(nums[i+k-1], count + 1);
            } else {
                for(int j=0;j<k;j++) {
                    tempSum += nums[j];
                    count = numCountMap.getOrDefault(nums[j], 0);
                    numCountMap.put(nums[j], count + 1);
                }
            }

            if(numCountMap.size() == k && maxSum < tempSum) {
                maxSum = tempSum;
            }
        }

        return maxSum;
    }

}
