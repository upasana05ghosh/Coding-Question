package com.practise;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    private int n;
    private List<Integer> [] adj;

    @SuppressWarnings("unchecked")
    public BFS(int n) {
        this.n = n;
        adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    private void addEdge(int u, int v) {
        adj[u].add(v);
    }

    private void printadj() {
        for (int i = 0; i < n; i++) {
            for(int j: adj[i]) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    private void bfs(int s) {
        boolean [] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        visited[s] = true;

        while(q.size() > 0) {
            int v = q.poll();
            System.out.println(v);

            Iterator<Integer> i = adj[v].listIterator();
            while(i.hasNext()) {
                int val = i.next();
                //System.out.println("val is: "+val);
                if (!visited[val]) {
                    visited[val] = true;
                    q.add(val);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS b = new BFS(4);
        b.addEdge(0, 1);
        b.addEdge(0, 2);
        b.addEdge(2, 0);
        b.addEdge(1, 2);
        b.addEdge(2, 3);
        b.addEdge(3, 3);

        b.printadj();
        System.out.println("==================");

        b.bfs(2);
    }

}
