package com.practise;

public class FindOddDivisor {

    public static void main(String[] args) {
        System.out.println(findDivisior(2));

    }

    private static int findDivisior(int n) {
        int div = 1, count = 0;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                count++;
                n = n / i;
            }
            div = div * (count + 1);
            count = 0;
        }
        if (n > 1) {
            div = div * (2);
        }

        return div;
    }

}
