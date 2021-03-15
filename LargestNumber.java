package com.practise;

public class LargestNumber {

    private static String largestNumber(int[] a) {

        int n = a.length;

        String [] s = new String [n];

        for(int i = 0; i< n; i++)
            s[i] = Integer.toString(a[i]);


        //s.sort((s1, s2) -> (s2+s1).compareTo(s1+s2));

        if (s[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();

        for(int i=0; i< n; i++)
            sb.append(s[i]);

        return sb.toString();
    }

    public static void main(String[] args) {
    }

}
