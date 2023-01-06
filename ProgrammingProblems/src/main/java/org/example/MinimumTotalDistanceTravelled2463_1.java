package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumTotalDistanceTravelled2463_1 {
    public static void main(String[] args) {
        //List<Integer> robot = new ArrayList<>(Arrays.asList(0,4,6));
        //int[][] factory = {{2,2},{6,2}};
        //List<Integer> robot = new ArrayList<>(Arrays.asList(1,-1));
        //int[][] factory = {{-2,1},{2,1}};
//        [9,11,99,101]
//[[10,1],[7,1],[14,1],[100,1],[96,1],[103,1]]
        MinimumTotalDistanceTravelled2463_1 minimumTotalDistanceTravelled2463 = new MinimumTotalDistanceTravelled2463_1();
        //System.out.println(minimumTotalDistanceTravelled2463.minimumTotalDistance(new ArrayList<>(Arrays.asList(0,4,6)), (new int[][]{{2,2},{6,2}})));
        //System.out.println(minimumTotalDistanceTravelled2463.minimumTotalDistance(new ArrayList<>(Arrays.asList(1,-1)), (new int[][]{{-2,1},{2,1}})));
        System.out.println(minimumTotalDistanceTravelled2463.minimumTotalDistance(new ArrayList<>(Arrays.asList(9,11,99,101)), (new int[][]{{10,1},{7,1},{14,1},{100,1},{96,1},{103,1}})));
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        List<Integer> fact=new ArrayList<Integer>();
        for(int i=0;i<factory.length;i++){
            for(int j=0;j<factory[i][1];j++){
                fact.add(factory[i][0]);
            }
        }
        Collections.sort(fact);
        Long[][] dp=new Long[robot.size()+1][fact.size()+1];
        return helper(dp,robot,fact,0,0);
    }
    public long helper(Long[][] dp,List<Integer> robot,List<Integer> factory,int i,int j){
        if(i==robot.size()){
            return 0;
        }
        if(j==factory.size()){
            return (long)1e14;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        long min=(long)1e14;
        min=Math.min(min,helper(dp,robot,factory,i+1,j+1)+Math.abs(robot.get(i)-factory.get(j)));
        min=Math.min(min,helper(dp,robot,factory,i,j+1));
        return dp[i][j]=min;
    }
}
