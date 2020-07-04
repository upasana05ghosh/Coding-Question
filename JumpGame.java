package com.practise;

public class JumpGame {

    /**
     * Given array a of non-ve integer, you are initially positioned at the
     * first index of array. Each element in array represents your max
     * jump length at that position.
     *
     * Determine if you are able to reach end
     */

    private static boolean canJump(int a[]) {
        int jump = 0;
        for (int i = 0; i < a.length; i++) {
            if (jump < i)
                return false;
            jump = Math.max(jump, a[i]+i);
        }
        return true;
    }

    public static void main(String[] args) {

        int a [] = {2,3,1,1,4};
        System.out.println(canJump(a));

    }
}
