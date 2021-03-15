package com.practise;

import java.util.Arrays;
import java.util.Random;

public class RandomizeSortedArray {

    private static void randomize(int [] a) {
        for (int end = a.length -1; end >0; end--) {
            int j = new Random().nextInt(end);
            swap(a, j, end);
        }
    }



    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }



    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        randomize(a);
        System.out.println(Arrays.toString(a));
        int i = 4;  int j = 1;
        String s = Integer.toBinaryString(i);
        String t = Integer.toBinaryString(j);
        System.out.println(Integer.bitCount(4));

//        for (int l  = 0; l< s.length(); l++) {
//			if (0)
//		}
    }

}
