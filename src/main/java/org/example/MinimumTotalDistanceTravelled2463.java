package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumTotalDistanceTravelled2463 {
    public static void main(String[] args) {
        //List<Integer> robot = new ArrayList<>(Arrays.asList(0,4,6));
        //int[][] factory = {{2,2},{6,2}};
        //List<Integer> robot = new ArrayList<>(Arrays.asList(1,-1));
        //int[][] factory = {{-2,1},{2,1}};
//        [9,11,99,101]
//[[10,1],[7,1],[14,1],[100,1],[96,1],[103,1]]
        MinimumTotalDistanceTravelled2463 minimumTotalDistanceTravelled2463 = new MinimumTotalDistanceTravelled2463();
        System.out.println(minimumTotalDistanceTravelled2463.minimumTotalDistance(new ArrayList<>(Arrays.asList(0,4,6)), (new int[][]{{2,2},{6,2}})));
        System.out.println(minimumTotalDistanceTravelled2463.minimumTotalDistance(new ArrayList<>(Arrays.asList(1,-1)), (new int[][]{{-2,1},{2,1}})));
        System.out.println(minimumTotalDistanceTravelled2463.minimumTotalDistance(new ArrayList<>(Arrays.asList(9,11,99,101)), (new int[][]{{10,1},{7,1},{14,1},{100,1},{96,1},{103,1}})));
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int[][] robotFactoryDistanceArray = new int[robot.size()][factory.length];
        Map<Integer, Integer> factoryRobotCountMap = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        int totalDistance = 0, factoryIndex = -1;
        for(int i=0;i<robot.size();i++) {
            minDistance = Integer.MAX_VALUE;
            for(int j=0;j<factory.length;j++) {
                robotFactoryDistanceArray[i][j] = Math.abs(robot.get(i) - factory[j][0]);
                if(Math.abs(robot.get(i) - factory[j][0]) < minDistance) {
                    factoryIndex = j;
                    minDistance = Math.abs(robot.get(i) - factory[j][0]);
                }
            }
            //totalDistance += Math.abs(robot.get(i) - factory[factoryIndex][0]);
            int currentFactoryRobotCount = factoryRobotCountMap.getOrDefault(factoryIndex, 0);
            factoryRobotCountMap.put(factoryIndex, currentFactoryRobotCount + 1);
        }

        return totalDistance;
    }
}
