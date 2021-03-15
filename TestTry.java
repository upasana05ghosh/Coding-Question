package com.practise;

import java.util.ArrayList;
import java.util.List;

public class TestTry {

    static String strVal;

    public static void main(String[] args) {
        TestTry h1 = new TestTry();
        //strVal = h1.getString("Program");
        //System.out.print(" "+strVal);
        swap(10,20);

        int a[] = {4,2,7,1};
        bubbleSort(a);
        for(int i: a) {
            System.out.println(i);
        }

    }

    private static List<Integer> getSum(List<List<Integer>> list, int [] a) {
        List<Integer> res = new ArrayList<>();
        for(List<Integer> l : list) {
            res.add(getSumInRange(a, l.get(0), l.get(1)));
        }
        return res;
    }

    private static void bubbleSort(int [] a) {
        int n = a.length;
        if (n == 0)
            return;

        boolean isSwapped = true;
        for(int i = 0; i< n; i++) {
            for(int j = 0; j<n-1-i && isSwapped ;j++) {
                if (a[j] > a[j+1]) {
                    swap(a, j, j+1);
                    isSwapped = true;
                }
            }
        }
    }

    private static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int getSumInRange(int [] a, int start, int end) {
        int sum = 0;
        for(int i = start; i<= end && i<a.length; i++)
            sum+= a[i];
        return sum;
    }

    private static void swap(int a, int b) {
        a = a+b;
        b = a - b;
        a = a - b;
        System.out.println(a + " " + b);
    }

    public static String getString(String str){

           StringBuffer strBuf = new StringBuffer(str.length());

           for(int i=str.length() -1 ; i>0;i--)
           {
             strBuf.append(str.charAt(i));
           }
           return strBuf.toString();
        }

}
