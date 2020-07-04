package com.practise;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CountTreesInForest {

    private int n;
    private List<Integer> [] adj;

    @SuppressWarnings("unchecked")
    public CountTreesInForest(int n) {
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

    private int countTrees() {
        boolean [] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfsUtil(i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfsUtil(int s, boolean[] visited) {
        //System.out.println(s);
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
        CountTreesInForest b = new CountTreesInForest(5);
        b.addEdge(0, 1);
        b.addEdge(0, 2);
        b.addEdge(3, 4);

       // b.printadj();
        System.out.println("==================");

        System.out.println(b.countTrees());
    }

}
