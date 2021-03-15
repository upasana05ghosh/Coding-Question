package com.practise;

import java.util.Arrays;

public class ChocolateDistribution {

    public static void main(String[] args) {
        int a [] = {7,3,2,4,9};
        System.out.println(findMinChocolate(a, 3));

    }

    private static int findMinChocolate(int[] a, int k) {
        Arrays.sort(a);

        int min = Integer.MAX_VALUE;
        int diff;
        int n = a.length;

        for (int i = 0; i < n - k +1 ; i++) {
            diff = a[i+k-1] - a[i];
            if (diff < min)
                min = diff;
        }
        return min;
    }

}
