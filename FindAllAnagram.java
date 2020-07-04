package com.practise;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagram {

    /**
     * Given a string s and a non-empty string p, find all indices of p's
     * anagram in s
     *
     * I/p: s: abdcdab p: abd
     * O/p: [0, 4]
     */

    private static List<Integer> findAnagram(String s, String p) {

        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length())
            return res;
        int n, m, found, start, end;
        n = s.length(); m = p.length();
        found = m; start = 0; end = 0;

        int [] map = new int[26];
        //mark 1 for character in p
        for (char ch: p.toCharArray()) {
            map[ch - 'a']++;
        }

        //check the first window
        char ch;
        for (end  = 0; end < m; end++) {
            ch = s.charAt(end);
            map[ch - 'a']--;
            if (map[ch-'a'] >= 0)
                found --;
        }

        if (found == 0)
            res.add(0);

        while(end < n) {
            ch = s.charAt(start);
            map[ch - 'a']++;
            if (map[ch - 'a'] > 0)
                found++;
            start++;

            ch = s.charAt(end);
            map[ch - 'a']--;
            if (map[ch - 'a'] >=0)
                found--;

            if (found == 0)
                res.add(start);
            end++;
        }
        return res;
    }

    public static void main(String[] args) {

        String s = "abdcdab", p = "abd";

        System.out.println(findAnagram(s, p));


    }
}
