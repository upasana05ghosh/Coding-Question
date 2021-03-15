package com.practise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test02 {

    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private static Node add(Node n1, Node n2) {
        Node head = new Node(0);
        int carry = 0;
        Node n3 = head;
        while(n1 != null || n2 != null) {
            int val = ((n1 == null) ? 0 : n1.val) + ((n2 == null) ? 0: n2.val) + carry;
            carry = val /10;
            val = val % 10;
            n3.next = new Node(val);
            n3 = n3.next;
            if (n1 != null)
                n1 = n1.next;
            if(n2 != null)
                n2 = n2.next;
        }
        return head.next;
    }

    private static boolean checkLoop(Node n) {
        Node fast = n, slow = n;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    private static Node reverse(Node n) {
        Node pre = null;

        while (n != null) {
            Node temp = n.next;
            n.next = pre;
            pre = n;
            n = temp;
        }

        return pre;
    }

    private static int findMaxLength(int a[]) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0, sum = 0;

        for(int i = 0; i< a.length; i++) {
            sum += (a[i] == 0)? -1 : 1;

            if (map.containsKey(sum))
                maxLength = Math.max(maxLength, i - map.get(sum));
            else
                map.put(sum, i);
        }

        return maxLength;
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static class Pair {
        TreeNode n;
        int x, y;

        Pair(TreeNode n, int x, int y) {
            this.n = n;
            this.x = x;
            this.y = y;
        }

        public int getY() {
            return y;
        }
    }
    private static List<Integer> bottomView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Map<Integer, List<Pair>> map = new HashMap<>();
        int max = 0, min = 0;

        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0, 0));

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i< size; i++) {
                Pair p = q.poll();
                max = Math.max(max, p.x);
                min = Math.min(min, p.x);

                if (!map.containsKey(p.x))
                    map.put(p.x, new ArrayList<>());

                map.get(p.x).add(p);

                if (p.n.left != null)
                    q.add(new Pair(p.n.left, p.x-1, p.y+1));

                if (p.n.right != null)
                    q.add(new Pair(p.n.right, p.x+1, p.y+1));
            }
        }

        for(int i = min; i<= max; i++) {
            List<Pair> p = map.get(i);
            //res.add(p.stream().collect(Collectors.maxBy(Pair::getY)));
            Pair i1 =  p.stream().max(Comparator.comparingInt(Pair::getY)).get();
            res.add(i1.n.val);
        }
        return res;
    }

    public static void main(String[] args) {

        int [] a = {0,1,0,1,1,0,0,0};
        //System.out.println(findMaxLength(a));


        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.left.right = new TreeNode(4);

        List<Integer> res = bottomView(n);

        res.stream().forEach(System.out::println);

    }
}

