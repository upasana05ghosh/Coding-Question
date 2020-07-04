package com.practise;

public class JumpGame2 {

    /**
     * Given array a of non-ve integer, you are initially positioned at the
     * first index of array. Each element in array represents your max
     * jump length at that position.
     *
     * Determine min jump to reach the end
     */

    private static int minJump(int a[]) {
        int count = 0, jump = 0, maxJump = 0;
        for (int i = 0; i < a.length; i++) {
           maxJump = Math.max(maxJump, a[i]+i);
           if (jump == i) {
               count++;
               jump = maxJump;
           }
        }
        return count;
    }

    public static void main(String[] args) {

        int a [] = {2,3,1,1,4};
        System.out.println(minJump(a));

    }
}
