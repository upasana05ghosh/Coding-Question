package com.practise;

public class FindDuplicate {

    private static int findDuplicate(int[] nums) {

        int i = 0, j = 2, n = nums.length;

        while (nums[i] != nums[j]) {
            i = (i+1) % n;
            j = (j+1) % n;
        }
        return nums[i];
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,3};
        System.out.println(findDuplicate(nums));

    }



}
