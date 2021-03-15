package com.practise;

import java.util.HashMap;
import java.util.Map;

public class MaxNoOfKParis {

    private static int maxOperations(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i: a) {
            if(map.containsKey(k-i)) {
                if (map.get(k-i) > 0) {
                    map.put(k-i, map.get(k-i) -1);
                    res++;
                    continue;
                }
            }
                map.put(i, map.getOrDefault(i,0) +1);

        }

        //map.forEach((k,v) -> System.out.print(k + " "  + v));
        map.forEach((kk, v) -> System.out.println((kk + ":" + v)));
        return res;
    }

    public static void main(String[] args) {
        int [] a = {1,1,1,1};
        int k = 2;
        System.out.println(maxOperations(a, k));
    }

}
