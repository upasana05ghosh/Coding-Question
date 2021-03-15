package com.practise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointToOrigin {

    /**
     * Given a list of points on the plane. Find the k closest pt. to origin
     * (0,0) You may return the answer in any order
     */


    // O(nlogn)
    private static int[][] kClosestBySorting(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, k);
    }


    // O(nlogk)
    private static int[][] kClosestByMaxHeap(int[][] points, int k) {
        Queue<int []> q = new PriorityQueue<>((p1, p2) -> ((p2[0] * p2[0] + p2[1] * p2[1]) -
                (p1[0] * p1[0] + p1[1] * p1[1])));

        for(int [] p : points) {
            q.add(p);
            if (q.size() > k)
                q.poll();
        }

        int [][] res = new int[k][2];

        while(k > 0) {
            res[--k] = q.poll();
        }

        return res;
    }

    private static int[][] kClosestQuickSort(int [][] points, int k) {
        int start = 0, end = points.length-1;

        while (start <= end) {
            int j = partition(points, start, end);
            if (j == k) {
                break;
            }
            if (j < k) {
                start = j+1;
            } else {
                end = j-1;
            }
        }
        return Arrays.copyOfRange(points, 0, k);
    }

    private static int partition(int[][] points, int start, int end) {
        int [] v = points[start];
        int i = start, j = end;

        while (i <= j) {
            while (i <= end && comp(v, points[i]) >= 0)
                i++;
            while(comp(v, points[j]) < 0)
                j--;

            if (i<= j)
                swap(points, i, j);
        }
        swap(points, start, j);
        return j;
    }


    private static void swap(int[][] points, int i, int j) {
        int [] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }


    private static int comp(int[] p1, int[] p2) {
        return (p1[0] *p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] + p2[1]);
    }


    public static void main(String[] args) {

        int[][] points = { { 1, 3 }, { -2, 2 }, {0, 0} };

        int k = 0;
        int[][] res = kClosestQuickSort(points, k);

       for (int i = 0; i < k; i++) {
           System.out.println(res[i][0] + " " + res[i][1]);
       }
    }

}
