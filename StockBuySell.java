package com.practise;

public class StockBuySell {

    private static int buysSell(int[] prices) {
        int n = prices.length, i = 0;
        int b = 0, p = 0;
        while (i < n) {
            b = prices[i];

            while(i+1 < n && prices[i] < prices[i+1])
                i++;

            p += (prices[i]-b);
            i++;
        }
        return p;
    }

    public static void main(String[] args) {
        int [] a = {7,6,4,3,1};
        System.out.println(buysSell(a));
    }

}
