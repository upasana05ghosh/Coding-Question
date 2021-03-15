package com.practise;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenSum {

    private static void subArraySum(int a[], int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        map.put(0, 0);
        for (int i = 0; i < a.length; i++) {
            currSum += a[i];
            if(map.containsKey(currSum - sum)) {
                System.out.println("start: " + (map.get(currSum - sum) + 1)  + " end: " + i);
                break;
            }
            map.put(currSum, i);
        }
    }

    public static void main(String[] args) {
        int a[] = {10, 2, -2, -20, 10};
        subArraySum(a, -10);
    }

}
