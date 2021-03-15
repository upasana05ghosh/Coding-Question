package com.practise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class CourseSchedule {

    /**
     * There are total no. of 'numCourse' course labeled from o t0 numCourse -1
     * Some course may have prerequisite 'p'
     * like [0,1] -> to take course 1, you have to take course 0 first
     *
     * find is it possible to finish the course
     */

    public static boolean canFinish(int numCourse, int [][] p) {
        int n = numCourse;
        int [][] mat = new int [n][n];
        int [] indegree = new int[n];

        for (int i = 0; i < p.length; i++) {
            mat[p[i][0]][p[i][1]] = 1;
            indegree[p[i][1]]++;
        }

        Queue<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            if(indegree[i] == 0)
                q.add(i);
        }

        int count = 0;

        while(!q.isEmpty()) {
            int item = q.poll();
            count++;

            for (int i = 0; i < n; i++) {
                if(mat[item][i] == 1) {
                    mat[item][i] = 0;
                    indegree[i]--;
                    if (indegree[i] == 0)
                        q.add(i);
                }
            }
        }
        return count == n;
    }



    public static void main(String[] args) {
        int [][] p = {{0,1},
                {1,0}};
        System.out.println(canFinish(2, p));
    }

}
