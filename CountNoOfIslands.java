package com.practise;

public class CountNoOfIslands {

    private void printadj() {
        // for (int i = 0; i < n; i++) {
        // for(int j: adj[i]) {
        // System.out.print(j);
        // }
        // System.out.println();
        // }
    }

    private boolean isSafe(int a[][], int i, int j, int n,
            boolean[][] visited) {
        if (i < n && j < n && a[i][j] == 1 && !visited[i][j]) {
            return true;
        }
        return false;
    }

    private int countIslands(int[][] a, int n) {
        boolean[][] visited = new boolean[n][n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1 && !visited[i][j]) {
                    count++;
                    fillVisited(a, visited, i, j, n);
                }
            }
        }
        return count;
    }

    private void fillVisited(int[][] a, boolean[][] visited,
            int i, int j, int n) {

        visited[i][j] = true;
        if (isSafe(a, i + 1, j, n, visited))
            fillVisited(a, visited, i + 1, j, n);
        if (isSafe(a, i, j + 1, n, visited))
            fillVisited(a, visited, i, j + 1, n);

    }


    public static void main(String[] args) {
        CountNoOfIslands b = new CountNoOfIslands();
        int[][] a = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 },
                { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };

        // b.printadj();
        System.out.println("==================");

        System.out.println(b.countIslands(a, 4));
    }

}
