package com.practise;

public class CountVal {

    private static int calCount(int m) {
        int count = 0;
       while (m!= 0) {
           if((m & 1) == 0) {
               count++;
               System.out.println(m);
           }
           m = m >> 1;
       }
       return count;
    }

    public static void main(String[] args) {

        System.out.println(calCount(2048));

    }

}
