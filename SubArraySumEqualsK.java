package com.practise;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    /**
     * Given an array of integer a and an integer k
     * you need to find the total no of continuous subarray whose
     * sum equals k
     */

    private static int subArraySum(int nums[], int k) {
        if (nums.length == 0)
            return 0;
        int sum = 0, counter = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i: nums) {
            sum += i;
            if(map.containsKey(sum - k)) {
                counter += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return counter;
    }

    public static void main(String[] args) {

        int a [] = {2,0,3,7,10};
        System.out.println(subArraySum(a, 10));

    }
}
