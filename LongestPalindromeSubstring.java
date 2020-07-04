package com.practise;

public class LongestPalindromeSubstring {


    public static void main(String[] args) {

        System.out.println(findPalindromSubstring("abcbc"));

    }

    private static String findPalindromSubstring(String s) {
        if (s == null || s.length() == 0)
            return null;

        int n = s.length();
        int a[][] = new int [n][n];

        for (int i = 0; i < n; i++) {
            a[i][i] = 1;
        }
        int k = 0;
        for (int i = 0; i < n-1; i++) {
            k++;
            for (int j = 0; j+k < n; j++) {
                if(s.charAt(j) == s.charAt(j+k)) {
                    a[j][j+k] = a[j+1][j+k-1] + 2;
                } else {
                    a[j][j+k] = Math.max(a[j][j+k-1], a[j+1][j+k]);
                }
            }
        }

        int m = a[0][n-1];
        int start = 0, end = m-1, i = 0, j = n-1;
        char [] c = new char[m];
        while (start <= end) {
            if (s.charAt(i) == s.charAt(j)) {
                c[start++] = c[end--] = s.charAt(i);
                i++; j--;
            } else {
                if (a[i][j-1] >= a[i+1][j]) {
                    j--;
                } else {
                    i++;
                }
            }
        }

        return String.valueOf(c);
    }

}
