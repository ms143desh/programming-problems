package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.sun.source.tree.Tree;

public class HeightOfBinaryTree2458 {
    public static void main(String[] args) {
        //Integer[] input = {1,3,4,2,null,6,5,null,null,null,null,null,7};
        //int[] queries = {4};
        //Integer[] input = {5,8,9,2,1,3,7,4,6};
        //int[] queries = {3,2,4,8};
        Integer[] input = {1,null,5,3,null,2,4};
        int[] queries = {3,5,4,2,4};
        HeightOfBinaryTree2458 heightOfBinaryTree2458 = new HeightOfBinaryTree2458();
        TreeNode rootNode = heightOfBinaryTree2458.convertToTreeNode(input);
        int[] output = heightOfBinaryTree2458.treeQueries(rootNode, queries);
        for(int i=0;i<output.length;i++) {
            System.out.print(output[i] + ", ");
        }
        //System.out.println(zigzagConversion6.convert(input, rows));
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] output = new int[queries.length];
        int maxValueinTree = calculateMaxValue(root, 0);
        for(int i=0;i<queries.length;i++) {
            output[i] = removeTreeNode(root, queries[i], -1, maxValueinTree);
        }
        return output;
    }

    private int removeTreeNode(TreeNode treeNode, int value, int height, int maxValueinTree) {
        if(treeNode != null) {
            height++;
            int leftHeight = height, rightHeight = height;
            if(treeNode.left == null || treeNode.left.val != value) {
                leftHeight = removeTreeNode(treeNode.left, value, height, maxValueinTree);
            }
            if(2*leftHeight + 1 <= maxValueinTree) {
                if(treeNode.right == null || treeNode.right.val != value) {
                    rightHeight = removeTreeNode(treeNode.right, value, height, maxValueinTree);
                }
            }

            if(leftHeight > rightHeight && leftHeight > height) {
                height = leftHeight;
            } else if(rightHeight > leftHeight && rightHeight > height){
                height = rightHeight;
            }
        }

        return height;
    }

    private int calculateMaxValue(TreeNode treeNode, int maxValue) {
        if(treeNode != null) {
            if(treeNode.val > maxValue) {
                maxValue = treeNode.val;
            }
            maxValue = calculateMaxValue(treeNode.left, maxValue);
            maxValue = calculateMaxValue(treeNode.right, maxValue);
        }
        return maxValue;
    }





    private TreeNode convertToTreeNode(Integer[] input) {
        TreeNode rootNode = new TreeNode(input[0]);
        List<TreeNode> treeNodeList = new ArrayList<>();
        treeNodeList.add(rootNode);
        int i = 1, height = 1;
        while(i < input.length) {
            List<TreeNode> newTreeNodeList = new ArrayList<>();
            for(int j=0;j<treeNodeList.size();j++) {
                if(treeNodeList.get(j) != null) {
                    if(i < input.length) {
                        treeNodeList.get(j).left = valueToNode(treeNodeList.get(j).left, i, input);
                        newTreeNodeList.add(treeNodeList.get(j).left);
                        i++;
                    }
                    if(i < input.length) {
                        treeNodeList.get(j).right = valueToNode(treeNodeList.get(j).right, i, input);
                        newTreeNodeList.add(treeNodeList.get(j).right);
                        i++;
                    }
                }
            }
            treeNodeList = newTreeNodeList;
        }
        return rootNode;
    }

    private TreeNode valueToNode(TreeNode treeNode, int index, Integer[] input) {
        if(input[index] != null) {
            treeNode = new TreeNode(input[index]);
        }
        return treeNode;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
