package com.practise;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DFS {

    private int n;
    private List<Integer> [] adj;

    @SuppressWarnings("unchecked")
    public DFS(int n) {
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

    private void dfs(int s) {
        boolean [] visited = new boolean[n];
        dfsUtil(s,visited);
    }

    private void dfsUtil(int s, boolean[] visited) {
        System.out.println(s);
        visited[s] = true;

        Iterator<Integer> i = adj[s].iterator();

        while(i.hasNext()) {
            int v = i.next();
            if(!visited[v]) {
                dfsUtil(v, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFS b = new DFS(4);
        b.addEdge(0, 1);
        b.addEdge(0, 2);
        b.addEdge(2, 0);
        b.addEdge(1, 2);
        b.addEdge(2, 3);
        b.addEdge(3, 3);

        b.printadj();
        System.out.println("==================");

        b.dfs(2);
    }

}
