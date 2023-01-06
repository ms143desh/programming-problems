package org.example;

public class AverageValueOfEvenNumbers2455 {
    public static void main(String[] args) {
        int[] input = {1,2,2,1,1,0};
        AverageValueOfEvenNumbers2455 averageValueOfEvenNumbers2455 = new AverageValueOfEvenNumbers2455();
        System.out.println(averageValueOfEvenNumbers2455.averageValue(new int[]{1,3,6,10,12,15}));
        System.out.println(averageValueOfEvenNumbers2455.averageValue(new int[]{1,2,4,7,10}));

    }

    public int averageValue(int[] nums) {
        int output = 0;
        int count  = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] % 6 == 0 ) {
                output += nums[i];
                count++;
            }
        }
        if(count > 0) {
            return output/count;
        } else {
            return output;
        }

    }
}
