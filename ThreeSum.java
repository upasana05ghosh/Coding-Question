package com.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /**
     * Given array a, return the triplet which follows
     *  a1 + a2 + a3 = 0,
     *  return the list of all these unique triplets
     */

    private static List<List<Integer>> threeSum(int a[]) {

        int n = a.length;
        if (n == 0)
            return null;

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(a);
        int i = 0;
        int l, h;
        while (i < n && a[i] < 0) {
            if (i > 0 && a[i] == a[i-1]) {
                i++;
                continue;
            }

            l = i+1; h = n -1;

            while (l <= h) {
                if (a[i] + a[l] + a[h] == 0) {
                    list.add(Arrays.asList(a[i],a[l],a[h]));
                    while(a[l]== a[l+1]) l++;
                    while(a[h] == a[h-1]) h--;
                    l++; h--;
                } else {
                    if (a[i] + a[l] + a[h] > 0)
                        h--;
                    else
                        l++;
                }
            }
            i++;
        }

        return list;
    }

    public static void main(String[] args) {

        int a [] = {-1,0,1,2,-1,4};

        List<List<Integer>> list = threeSum(a);

        for(List l : list) {
            System.out.println(l);
        }
    }


}
