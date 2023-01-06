package org.example;

public class MedianOfTwoSortedArrays4 {
    public static void main(String[] args) {
        //int[] nums1 = {1,3}, nums2 = {2};
        //int[] nums1 = {1,2}, nums2 = {3,4};
        //int[] nums1 = {0,0}, nums2 = {0,0};
        //int[] nums1 = {1,2}, nums2 = {1,2,3,3,4};
        //int[] nums1 = {}, nums2 = {1,2,3,3,4};
        int[] nums1 = {1,2,3,3,4}, nums2 = {5,6,7,8,9,10,11};
        MedianOfTwoSortedArrays4 medianOfTwoSortedArrays4 = new MedianOfTwoSortedArrays4();
        System.out.println(medianOfTwoSortedArrays4.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                if(i + j == (nums1.length + nums2.length)/2 - 1 + (nums1.length + nums2.length)%2) {
                    left = nums1[i];
                    right = findRightNumber(nums1, nums2, i + 1, j);
                }
                i++;
            } else {
                if(i + j == (nums1.length + nums2.length)/2 - 1 + (nums1.length + nums2.length)%2) {
                    left = nums2[j];
                    right = findRightNumber(nums2, nums1, j+1, i);
                }
                j++;
            }
        }

        if(i == nums1.length) {
            if((nums1.length + nums2.length) % 2 == 0) {
                if(left == Integer.MIN_VALUE) {
                    left = nums2[(nums1.length + nums2.length - 1)/2 - nums1.length];
                }
                if(right == Integer.MIN_VALUE) {
                    right = nums2[(nums1.length + nums2.length + 1)/2 - nums1.length];
                }
            } else {
                if(left == Integer.MIN_VALUE) {
                    left = nums2[(nums1.length + nums2.length)/2 - nums1.length];
                }
                if(right != Integer.MIN_VALUE) {
                    left = right;
                    right = Integer.MIN_VALUE;
                }
            }
        } else if(j == nums2.length) {
            if((nums1.length + nums2.length) % 2 == 0) {
                if(left == Integer.MIN_VALUE) {
                    left = nums1[(nums1.length + nums2.length - 1)/2 - nums2.length];
                }
                if(right == Integer.MIN_VALUE) {
                    right = nums1[(nums1.length + nums2.length + 1)/2 - nums2.length];
                }
            } else {
                if(left == Integer.MIN_VALUE) {
                    left = nums1[(nums1.length + nums2.length)/2 - nums2.length];
                }
                if(right != Integer.MIN_VALUE) {
                    left = right;
                    right = Integer.MIN_VALUE;
                }
            }
        }

        if(right == Integer.MIN_VALUE) {
            return left;
        } else {
            return ((double)left + (double)right)/2;
        }
    }

    private int findRightNumber(int[] nums1, int[] nums2, int i1, int j1) {
        int right = Integer.MIN_VALUE;
        if((nums1.length + nums2.length) % 2 == 0) {
            if(i1 < nums1.length) {
                if(nums1[i1] < nums2[j1]) {
                    right = nums1[i1];
                } else {
                    right = nums2[j1];
                }
            }
        }
        return right;
    }
}
