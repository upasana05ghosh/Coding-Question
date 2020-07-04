package com.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueenLeetCode {

    public static void main(String[] args) {

        NQueenLeetCode q = new NQueenLeetCode();
        System.out.println(q.solveNQueens(4));
    }

    private int solveNQueens(int n) {
        int [] board = new int[n];
        int [] count = new int[1];
        count[0] = 0;
        nQueen(0, board, n, count);
        return count[0];
    }

    private void nQueen(int i, int[] board, int n, int [] count) {
        for (int col = 0; col < n; col++) {
            if(isSafe(board, i, col)) {
                board[i] = col;
                if (i == n -1) {
                    count[0]++;

                } else {
                    nQueen(i+1, board, n, count);
                }
            }
        }
    }

    private boolean isSafe(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col ||
                    Math.abs(board[i] - col) == Math.abs(i - row))
                return false;
        }
        return true;
    }

}
