package org.example;

import java.util.Arrays;

public class TotalCostToHireKWrokers2462 {
    public static void main(String[] args) {

        /*
[17,12,10,2,7,2,11,20,8]
3
4
[1,2,4,1]
3
3
[57,33,26,76,14,67,24,90,72,37,30]
11
2
[69,10,63,24,1,71,55,46,4,61,78,21,85,52,83,77,42,21,73,2,80,99,98,89,55,94,63,50,43,62,14]
21
31
[18,64,12,21,21,78,36,58,88,58,99,26,92,91,53,10,24,25,20,92,73,63,51,65,87,6,17,32,14,42,46,65,43,9,75]
13
23
[28,35,21,13,21,72,35,52,74,92,25,65,77,1,73,32,43,68,8,100,84,80,14,88,42,53,98,69,64,40,60,23,99,83,5,21,76,34]
32
12
[31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58]
11
2
         */
        //int[] input = {17,12,10,2,7,2,11,20,8};
        //int k = 3, candidates = 4;
        //int[] input = {1,2,4,1};
        //int k = 3, candidates = 3;
        //int[] input = {31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58};
        //int k = 11, candidates = 2;
        //int[] input = {28,35,21,13,21,72,35,52,74,92,25,65,77,1,73,32,43,68,8,100,84,80,14,88,42,53,98,69,64,40,60,23,99,83,5,21,76,34};
        //int k = 32, candidates = 12;
        //int[] input = {18,64,12,21,21,78,36,58,88,58,99,26,92,91,53,10,24,25,20,92,73,63,51,65,87,6,17,32,14,42,46,65,43,9,75};
        //int k = 13, candidates = 23;
        int[] input = {69,10,63,24,1,71,55,46,4,61,78,21,85,52,83,77,42,21,73,2,80,99,98,89,55,94,63,50,43,62,14};
        int k = 21, candidates = 31;
        //int[] input = {57,33,26,76,14,67,24,90,72,37,30};
        //int k = 11, candidates = 2;
        TotalCostToHireKWrokers2462 totalCostToHireKWrokers2462 = new TotalCostToHireKWrokers2462();
        System.out.println(totalCostToHireKWrokers2462.totalCost(input, k, candidates));
    }

    public long totalCost(int[] costs, int k, int candidates) {
        int leftIndex = candidates - 1, rightIndex = costs.length - candidates;
        if(rightIndex < leftIndex) {
            if(leftIndex + 1 < costs.length) {
                rightIndex = leftIndex + 1;
            } else {
                rightIndex = -1;
            }
        }
        long totalCost = 0;

        boolean firstTimeLengthZero = true;
        int movingIndex = -1;
        if(rightIndex > -1) {
            int[] leftArray = new int[candidates];
            for(int i=0;i<candidates;i++) {
                leftArray[i] = costs[i];
            }
            int[] rightArray = new int[costs.length - rightIndex];
            for(int i=0;i<costs.length - rightIndex;i++) {
                rightArray[i] = costs[costs.length - 1 - i];
            }
            int leftMovingIndex = 0, rightMovingIndex = rightArray.length - 1;
            for(int i=0;i<k;i++) {
                if(rightArray.length == 0) {
                    if(firstTimeLengthZero) {
                        Arrays.sort(leftArray);
                        movingIndex = 0;
                        firstTimeLengthZero = false;
                    } else {
                        movingIndex++;
                    }
                    totalCost += leftArray[movingIndex];
                } else if(leftArray.length == 0) {
                    if(firstTimeLengthZero) {
                        Arrays.sort(rightArray);
                        movingIndex = 0;
                        firstTimeLengthZero = false;
                    } else {
                        movingIndex++;
                    }
                    totalCost += rightArray[movingIndex];
                } else {
                    int leftMinIndex = findSmallestElementIndex(leftArray, leftMovingIndex, leftArray.length - 1);
                    if(rightMovingIndex > -1) {
                        int rightMinIndex = findSmallestElementIndex(rightArray, 0, rightMovingIndex);
                        if(leftArray[leftMinIndex] <= rightArray[rightMinIndex]) {
                            totalCost += leftArray[leftMinIndex];
                            leftIndex++;
                            if(leftIndex < rightIndex) {
                                leftArray[leftMinIndex] = costs[leftIndex];
                                leftMovingIndex = 0;
                            } else {
                                int temp = leftArray[leftMovingIndex];
                                leftArray[leftMovingIndex] = leftArray[leftMinIndex];
                                leftArray[leftMinIndex] = temp;
                                leftMovingIndex++;
                            }
                        } else {
                            totalCost += rightArray[rightMinIndex];
                            rightIndex--;
                            if(leftIndex < rightIndex) {
                                rightArray[rightMinIndex] = costs[rightIndex];
                                rightMovingIndex = rightArray.length - 1;
                            } else {
                                int temp = rightArray[rightMovingIndex];
                                rightArray[rightMovingIndex] = rightArray[rightMinIndex];
                                rightArray[rightMinIndex] = temp;
                                rightMovingIndex--;
                            }
                        }
                    } else {
                        totalCost += leftArray[leftMinIndex];
                        leftIndex++;
                        leftArray[leftMinIndex] = costs[leftIndex];
                    }
                }
            }
        } else {
            for(int i=0;i<k;i++) {
                if(firstTimeLengthZero) {
                    Arrays.sort(costs);
                    movingIndex = 0;
                    firstTimeLengthZero = false;
                } else {
                    movingIndex++;
                }
                totalCost += costs[movingIndex];
            }
        }
        return totalCost;
    }

    private int findSmallestElementIndex(int[] arrayElements, int startIndex, int lastIndex) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i=startIndex;i<=lastIndex;i++) {
            if(arrayElements[i] < min) {
                min = arrayElements[i];
                index = i;
            }
        }
        return index;
    }

    private int[] removeIndexElementFromArray(int[] arrayElements, int index) {
        int[] newArrayElements = new int[arrayElements.length - 1];
        int newindex = 0;
        for(int j=0;j<arrayElements.length;j++) {
            if(j != index) {
                newArrayElements[newindex] = arrayElements[j];
                newindex++;
            }
        }
        return newArrayElements;
    }
}
