package com.practise;

public class LongestCommonSubsequence {


    public static void main(String[] args) {

        System.out.println(findLongestCommonSubsequence("cda", "da"));

    }

    private static String findLongestCommonSubsequence(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0)
            return null;

        int n = s1.length();
        int m = s2.length();
        int a[][] = new int [n+1][m+1];


        for (int j = 1; j <= m; j++) { //going column wise
            for (int i = 1; i <= n; i++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    a[i][j] = 1 + a[i-1][j-1];
                } else {
                    a[i][j] = Math.max(a[i][j-1], a[i-1][j]);
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        int t = a[n][m];
        int end = t-1, i = n, j = m;
        char [] c = new char[t];
        while (end >= 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                c[end--] = s1.charAt(i-1);
                i--; j--;
            } else {
                if (a[i][j-1] >= a[i-1][j]) {
                    j--;
                } else {
                    i++;
                }
            }
        }

        return String.valueOf(c);
    }

}
