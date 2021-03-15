package com.practise;

import java.util.Stack;

public class CandyCrush {
    /**
     * Input: "aaabbbc"
        Output: "c"
        Explanation:
        1. Remove 3 'a': "aaabbbc" => "bbbc"
        2. Remove 3 'b': "bbbc" => "c"
     */
    private static String crushTheCandy(String candy) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < candy.length(); i++) {
            stack.push(candy.charAt(i));

        }
        return null;
    }



    public static void main(String[] args) {}

}
