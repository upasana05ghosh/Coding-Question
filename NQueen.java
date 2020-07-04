package com.practise;

public class NQueen {

    public static void main(String[] args) {

        NQueen q = new NQueen();
        q.printNQueen(4);

    }

    private void printNQueen(int n) {
        int [] board = new int[n];
        printQueen(0, board, n);
    }

    private void printQueen(int i, int[] board, int n) {
        for (int col = 0; col < n; col++) {
            if(isSafe(board, i, col)) {
                board[i] = col;
                if (i == n -1) {
                    printBoard(board, n);
                } else {
                    printQueen(i+1, board, n);
                }
            }
        }

    }

    private void printBoard(int[] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i] == j)
                    System.out.print(1);
                else
                    System.out.print(0);
            }
            System.out.println();
        }
        System.out.println("======================");

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
