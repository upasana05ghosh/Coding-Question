package com.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {

    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        String s = "ABC";
        permuate(s, res, new ArrayList<>(), new boolean[s.length()]);
        res.forEach(System.out::println);
    }

    private static void permuate(String s, List<String> res, List<Character> temp, boolean[] used) {
        if (temp.size() == s.length()) {
            res.add(temp.stream().map(String::valueOf).collect(Collectors.joining()));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (used[i])
                continue;
            temp.add(s.charAt(i));
            used[i] = true;
            permuate(s, res, temp, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

}
