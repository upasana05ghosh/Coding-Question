package com.practise;

import java.util.ArrayDeque;
import java.util.Queue;

public class MakeStringGreat {

    public static void main(String[] args) {
        System.out.println(makeGood("addLast"));
    }

    private static String makeGood(String st) {
        if (st == null)
            return st;

        ArrayDeque<Character> s = new ArrayDeque<>();

        for(char c : st.toCharArray()) {
            if(s.isEmpty())
                s.addLast(c);
            else {
                if(Math.abs(s.peek() - c) == 32)
                    s.removeLast();
                else
                    s.addLast(c);
            }
        }

        if (s.isEmpty())
            return "";

        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) {
            sb.append(s.removeFirst());
        }
        return sb.toString();
    }

}
