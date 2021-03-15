package com.practise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
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

public class BinaryTreeZicZak {

    public static void main(String[] args) {
        List<List<Integer>> list = null;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            while(!s1.isEmpty()) {
                TreeNode item = s1.pop();
                l.add(item.val);
                if(item.left != null)
                    s2.push(item.left);
                if(item.right != null)
                    s2.push(item.right);
            }
            if (l.size() > 0)
                list.add(l);

            List<Integer> l2 = new ArrayList<>();
            while(s2.size() > 0) {
                TreeNode item = s2.pop();
                l2.add(item.val);
                if(item.right != null)
                    s1.add(item.right);
                if(item.left != null)
                    s1.push(item.left);
            }

            if (l2.size() > 0)
                list.add(l2);
        }

        return list;
    }

}
