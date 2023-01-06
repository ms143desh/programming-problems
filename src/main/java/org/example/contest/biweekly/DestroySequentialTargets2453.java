package org.example.contest.biweekly;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class DestroySequentialTargets2453 {
    public static void main(String[] args) {
        DestroySequentialTargets2453 destroySequentialTargets2453 = new DestroySequentialTargets2453();
        System.out.println(destroySequentialTargets2453.destroyTargets(new int[]{3,7,8,1,1,5}, 2));
        System.out.println(destroySequentialTargets2453.destroyTargets(new int[]{1,3,5,2,4,6}, 2));
        System.out.println(destroySequentialTargets2453.destroyTargets(new int[]{6,2,5}, 100));
        System.out.println(destroySequentialTargets2453.destroyTargets(new int[]{1,5,3,2,2}, 10000));
    }

    public int destroyTargets(int[] nums, int space)
    {
        Arrays.sort(nums);
        HashMap<Integer,Integer> numRemainderMap = new HashMap<>();
        for(int number : nums)
        {
            number = number % space;
            numRemainderMap.put(number,numRemainderMap.getOrDefault(number,0)+1);
        }
        int maxRemainderCount = Collections.max(numRemainderMap.values());
        for(int i = 0 ; i < nums.length;i++)
        {
            if(numRemainderMap.get(nums[i] % space) == maxRemainderCount) {
                return nums[i];
            }
        }

        return 0;
    }
}
