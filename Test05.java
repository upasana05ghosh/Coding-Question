package com.practise;

import java.util.LinkedList;
import java.util.Queue;

public class Test05 {
    //2 grid binary -> {1 - land, 0 -> water}
//	[0011]    [1 0 1]   -> {(0,0)}
//  [1000]    [1 0 1]    -> {(0,3)(1,3),(2,3)}
//  [1000]    [0 0 1]

//	1,1,1,0,0,0
//
//	0,0,0,0,0,0
//
//	0,0,0,0,1,1
//
//	0,0,0,0,0,1

    //1,1,1,0,0,0



    private class Node {
        int x;
        int y;
    }

    private static int findMinMatric(int [][] m) {
        int r = m.length;
        int c = m[0].length;
        int minDist = Integer.MAX_VALUE;
        Queue<Node> q = new LinkedList<>();

        for(int i = 0; i< r; i++) {
            for(int j = 0; j< c; j++) {
                if (m[i][j] == 1) {
                   // populateQueue(q, i,j, m);
                    break;
                }
            }
        }

        while(!q.isEmpty()) {
           // minDist = Math.min(minDist, findDist(q.poll(), m));
        }
        return minDist;
    }


    public static void main(String[] args) {
System.out.println("hellow ");

    }

}
