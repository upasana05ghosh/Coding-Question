package com.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * Finding if a number is equal to sum of 2 nodes in a binary search tree
 *
 * Sol 1: Take a node and traverse the entire tree to find the corresponding node where
 * sum of both node is N
 *
 * Sol 2. Store the in-order traversal of binary tree in array and then check if
 *
 * a[l] + a[h] > n
 * 	then
 *   h--
 * else
 *    l++
 *
 */
public class BTNodeSumToN {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private static boolean findTreeNodeSum(TreeNode head, int n) {
        if (head == null)
            return false;
        List<Integer> a = new ArrayList<>();
        inOrderTraversal(a, head);
        return findSum(a, n);
    }

    private static void inOrderTraversal(List<Integer> a, TreeNode node) {
        if (node == null)
            return;

        inOrderTraversal(a, node.left);
        a.add(node.val);
        inOrderTraversal(a, node.right);
    }

    private static boolean findSum(List<Integer> a, int n) {
        int l = 0, h = a.size() -1;

        while(l <= h) {
            int curr = a.get(l) + a.get(h);
            if (curr == n)
                return true;
            else if (curr > n)
                h--;
            else
                l++;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.right.right = new TreeNode(6);

        System.out.println(findTreeNodeSum(node, 5));
    }

}
