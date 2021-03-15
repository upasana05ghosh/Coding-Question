package com.practise;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean visited[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(exist(board,i,j,word,0, visited))
                    return true;
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, int i, int j, String word,
            int k, boolean [][] visited) {
        if (k == word.length())
            return true;
        if(isSafe(board, i, j, visited)) {
            if(board[i][j] == word.charAt(k)) {
                visited[i][j] = true;
                if(exist(board,i,j-1,word,k+1, visited))
                    return true;
                if(exist(board, i, j+1, word, k+1, visited))
                    return true;
                if(exist(board, i-1, j, word, k+1, visited))
                    return true;
                if(exist(board,i+1,j,word,k+1, visited))
                    return true;
                visited[i][j] = false;
            }
        }
        return false;
    }

    private static boolean isSafe(char[][] board, int i, int j, boolean[][] visited) {
        if(i>=0 && i< board.length && j>=0 && j<board[0].length && !visited[i][j])
            return true;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
               // { 'A', 'B', 'C', 'E' },
               // { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }};

        System.out.println(exist(board, "A"));

    }

}
