package com.practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class STreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     STreeNode(int x) { val = x; }
 }

public class SeralizeDeseralizeBTree {

    private static String serialize(TreeNode root) {
        if(root == null)
            return "";
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode item = q.poll();
            list.add(item == null ? null: item.val);

            if(item == null)
                continue;

            q.add(item.left);
            q.add(item.right);
        }

        StringBuilder sb  = new StringBuilder();
        sb.append("[");
        int i;
        int n = list.size() -1;
        while (list.get(n) == null) {
            n--;
        }
        for(i = 0; i< n; i++)
            sb.append(list.get(i) + ",");
        sb.append(list.get(i));
        sb.append("]");
        return sb.toString();
    }

    private static  TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;

        String [] s = data.split(",");
        int n = s.length;
        s[0] = s[0].substring(1);
        s[n-1] = s[n-1].substring(0, s[n-1].length() -1);

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        q.add(root);
        int i = 1;
        while(!q.isEmpty() && i<n) {
            TreeNode node = q.poll();

            if (!s[i].equals("null")) {
                System.out.println(s[i]);
                node.left = new TreeNode(Integer.parseInt(s[i]));
                q.add(node.left);
            }

            if (i+1 < n && !s[i+1].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(s[i+1]));
                q.add(node.right);
            }
            i+=2;
        }
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        //root.right = new TreeNode(3);
        //root.left.right = new TreeNode(4);

        System.out.println(serialize(root));


        root = deserialize("[1,2]");
        System.out.println(root);
    }

}
