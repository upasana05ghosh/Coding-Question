package com.practise;

public class RatInMaze {

    private boolean isPathPossible(int[][] a, int n) {

        return pathPossible(a, 0, 0, n);
    }

    private boolean pathPossible(int[][] a, int i, int j, int n) {
        if (i == n - 1 && j == n - 1)
            return a[i][j] == 1;

        if (isSafe(a, i, j, n)) {
            if (pathPossible(a, i + 1, j, n))
                return true;
            if (pathPossible(a, i, j + 1, n))
                return true;
        }
        return false;
    }

    private boolean isSafe(int[][] a, int i, int j, int n) {
        if (i < n && j < n && a[i][j] == 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        RatInMaze b = new RatInMaze();
        int[][] a = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 },
                { 0, 1, 0, 0 }, { 1, 1, 1, 0 } };

        // b.printadj();
        System.out.println("==================");

        System.out.println(b.isPathPossible(a, 4));
    }

}
