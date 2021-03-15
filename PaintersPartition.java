package com.practise;

public class PaintersPartition {

    private static int partition(int a[], int k) {
        int l = 0, r = 0;

        for(int i : a) {
            l = Math.max(l,  i);
            r += i;
        }

        while(l< r) {
            System.out.println("l: " + l + " r: " + r);
            int mid = (l + r)/2;
            if(getTime(a, mid) > k)
                l = mid+1;
            else
                r = mid;
        }

        return l;
    }

    private static int getTime(int a[], int max) {
        int c = 0, d = 1;

        for(int i : a) {
            c+=i;
            if (c > max) {
                c = i;
                d++;
            }
        }
        return d;
    }

    public static void main(String[] args) {
        int a [] = {1, 8, 11, 3};
        System.out.println(partition(a, 10));

    }

}
