package com.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetOfSet {

    public static List<List<Integer>> subsets(int[] nums) {

        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
            String bitmask = Integer.toBinaryString(i).substring(1);
            //System.out.println(bitmask);
            List<Integer> r = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if (bitmask.charAt(j) == '1')
                    r.add(nums[j]);
            }
            res.add(r);
        }

        return res;
    }

    public static void main(String s[]) {

        int[] a = {1,2,3};
        List<List<Integer>> list = subsets(a);

        for(List a1 : list) {
            System.out.println(a1);
        }

    }

}
