package com.practise;

import java.util.LinkedHashMap;
import java.util.Scanner;

class MyOuterClass {

    private static String longestPalindromeSubseq(String s) {
        if (s.length() == 1)
            return s;

        int n = s.length();
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++)
            mat[i][i] = 1;

        for (int i = 1; i < n; i++) {
            int k = i;
            for (int j = 0; k < n; j++) {
                if (s.charAt(j) == s.charAt(k))
                    mat[j][k] = 2 + mat[j + 1][k - 1];
                else
                    mat[j][k] = Math.max(mat[j][k - 1], mat[j + 1][k]);
                k++;
            }
        }

        int t = mat[0][n - 1];

        char[] c = new char[t];

        int i = 0, j = n - 1;
        int f = 0, l = t - 1;
        while (f <= l) {
            if (s.charAt(i) == s.charAt(j)) {
                c[f] = c[l] = s.charAt(i);
                i++;
                j--;
                f++;
                l--;
            } else if (mat[i][j - 1] > mat[i + 1][j]) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println("Palindrome: " + new String(c));
        return new String(c);
    }

    public static String StringChallenge(String str) {
        String pal = longestPalindromeSubseq(str);
        int sl = str.length(), pl = pal.length();
        if (sl == pl)
            return "palindrome";
        if (sl - pl <= 2)
            return findDiff(str, pal);
        return "not possible";
    }

    private static String findDiff(String s, String pal) {
        String res = new String();
        int n  = s.length(), m = pal.length();
        int i = 0, j = 0;
//        for(int i = 0; i< n; i++) {
//          if (j >= m || s.charAt(i) != pal.charAt(j)) {
//            res += s.charAt(i);
//            j++;
//          }
//        }
        while (i < n) {
            if (j < m && s.charAt(i) == pal.charAt(j)) {
                i++; j++;
            } else {
                res += s.charAt(i);
                i++;
            }
        }
        return res;
      }

    public static void main(String args[]) {
        String s = "abjchba";
        System.out.print(StringChallenge(s));

    }
}
