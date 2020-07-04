package com.practise;

public class FindMedian {



    private static double median(int[] a1, int[] a2) {
        int n = a1.length, m = a2.length;
        if (n == 0 && m == 0)
            return 0;
        if(n > m) {
            median(a2, a1);
        }

        int posX = n/2, mid = (n+m+1)/2;
        int posY;

        while(posX >=0 && posX <= n) {
            posY = mid - posX;

            int x1 = posX == 0 ? Integer.MIN_VALUE : a1[posX-1];
            int y1 = posY == 0 ? Integer.MIN_VALUE : a2[posY-1];

            int x2 = posX == n ? Integer.MAX_VALUE : a1[posX];
            int y2 = posY == m ? Integer.MAX_VALUE : a2[posY];

            if (x1 <= y2 && y1 <= x2) {
                if ((n + m) %2 == 0) { //even
                    return (double) (Math.max(x1, y1) + Math.min(x2, y2))/2;
                } else {
                    return (double) Math.max(x1, y1);
                }
            }

            if (x2 < y1) {
                posX++;
            } else
                posX--;
        }
        return -1;
    }

    public static void main(String[] args) {

        int [] a1 = {};
        int [] a2 = {};
        System.out.println(median(a1,a2));
    }



}
