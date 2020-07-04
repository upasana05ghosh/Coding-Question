package com.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueenCount {

    public static void main(String[] args) {

        NQueenCount q = new NQueenCount();
        List<List<String>> res = q.solveNQueens(4);
        for(List<String> s : res) {
            for(String s1: s) {
                System.out.print(s1);
            }
            System.out.println();
        }

    }

    private List<List<String>> solveNQueens(int n) {
        int [] board = new int[n];
        List<List<String>> res = new ArrayList<List<String>>();
        nQueen(0, board, n, res);
        return res;
    }

    private void nQueen(int i, int[] board, int n, List<List<String>> res) {
        for (int col = 0; col < n; col++) {
            if(isSafe(board, i, col)) {
                board[i] = col;
                if (i == n -1) {
                    populateResponse(board, n, res);
                } else {
                    nQueen(i+1, board, n, res);
                }
            }
        }
    }

    private void populateResponse(int[] board, int n, List<List<String>> res) {
        List<String>list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if(board[i] == j)
                    s.append("Q");
                else
                    s.append(".");
            }
            list.add(s.toString());
        }
        res.add(list);
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
