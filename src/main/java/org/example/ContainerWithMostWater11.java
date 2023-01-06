package org.example;

public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        int[] input = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater11 containerWithMostWater11 = new ContainerWithMostWater11();
        System.out.println(containerWithMostWater11.maxArea(input));
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length-1;
        while(left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if(area > maxArea) {
                maxArea = area;
            }
            if(height[left] < height[right]) {
                left++;
            } else if(height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return maxArea;
    }
}
