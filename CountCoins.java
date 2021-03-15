package com.practise;

/**
 *
 A batsman can score either {1,2,3} runs in a ball.
 Find the number of ways he can score "X".
 *
 */
public class CountCoins {

    private static int countWays(int n) {
        int a[] = new int[n+1];
        a[0] = 1;

        for(int i = 1; i<=n; i++)
            a[i] += a[i-1];

        for(int i = 2; i<=n; i++)
            a[i] += a[i-2];

        for(int i = 3; i<=n; i++)
            a[i] += a[i-3];

        for(int i: a)
            System.out.print(i + " ");

        System.out.println();

        return a[n];
    }

    public static void main(String[] args) {


        System.out.println(countWays(3));

    }

}
