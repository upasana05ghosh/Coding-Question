package com.practise;

public class FIndMedianOfSortedArray {

    /**
     * Given 2 sorted array, find the median
     * i/p -> a1: [1,3], a2: [2,4]
     * o/p -> 2.5 (1,2,3,4) -> 2+3/2
     */

    private static double findMedian(int a1[], int a2[]) {
        if (a1.length > a2.length)
            return findMedian(a2, a1);

        int m = a1.length, n = a2.length;
        int posX = m/2;
        int mid = (m+n+1) / 2;
        int posY;

        while (posX >= 0 && posX <= m) {
            posY = mid - posX;

            int x1 = posX-1 >= 0 ? a1[posX -1] : Integer.MIN_VALUE;
            int y1 = posY-1 >= 0 ? a2[posY-1] : Integer.MIN_VALUE;

            int x2 = posX < m ? a1[posX] : Integer.MAX_VALUE;
            int y2 = posY < n ? a2[posY] : Integer.MAX_VALUE;

            if (x1 <= y2 && y1 <= x2) {
                if ((m + n) % 2 == 0) {
                    return (double)(Math.max(x1, y1) + Math.min(x2, y2)) / 2;
                } else {
                    return (double)Math.max(x1, y1);
                }
            }

            if (x2 < y1) {
                posX++;
            } else {
                posX--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int a1 [] = {2};
        int a2 [] = {5};
        System.out.println(findMedian(a1, a2));

    }
}
