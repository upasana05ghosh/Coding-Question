package com.practise;

public class SubArraySum {
    /**
     * Given an array, find the continuous array which has the largest sum
     * and return it's sum
     * I/p : [-2, 1, -3, 4, -1, 2, 1]
     * o/p : 6  as (4, -1, 2, 1)
     */

    private static int findMaxSum(int nums[]) {
        int sum, maxSum ;
        sum = 0 ; maxSum = Integer.MIN_VALUE;

        for( int a: nums) {
            if (sum < 0)
                sum = 0;
            sum += a;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = { -2, -1, -3, -4, -6};
        System.out.println(findMaxSum(nums));

    }

}
