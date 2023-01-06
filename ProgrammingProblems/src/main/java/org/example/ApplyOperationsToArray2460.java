package org.example;

public class ApplyOperationsToArray2460 {
    public static void main(String[] args) {
        int[] input = {1,2,2,1,1,0};
        ApplyOperationsToArray2460 applyOperationsToArray2460 = new ApplyOperationsToArray2460();
        input = applyOperationsToArray2460.applyOperations(input);
        for(int i=0;i<input.length;i++) {
            System.out.print(input[i] + ", ");
        }

    }

    public int[] applyOperations(int[] nums) {
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i] == nums[i+1]) {
                nums[i] = 2 * nums[i];
                nums[i+1] = 0;
            }
        }
        int nonZeroIndex = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }
        while(nonZeroIndex < nums.length) {
            nums[nonZeroIndex] = 0;
            nonZeroIndex++;
        }
        return nums;
    }
}
