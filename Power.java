package com.practise;

public class Power {

    private static int pow(int x, int n, int d) {

        if (n == 1)
            return x % d;

        if (n == 0)
            return 1 & d;

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        return n % 2 == 0 ? pow(x * x, n / 2, d) : x * pow(x * x, n / 2, d);
    }

    public static void main(String[] args) {
        System.out.println(pow(-1, 1, 20));
        System.out.println(1 % 20);
    }

}
