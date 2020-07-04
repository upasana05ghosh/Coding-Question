package com.practise;

public class SortBinaryInSinglePass {

    private static void sortColors(int[] nums) {
        int start = 0, end = nums.length -1, i = 0;

        while (i <= end) {
            if (nums[i] == 0) {
                swap(nums, i, start);
                start++;
            } if (nums[i] == 2) {
                swap(nums, i, end);
                end--;
                i--;
            }
            i++;
        }
    }

    private static void swap(int[] nums, int i, int end) {
        int temp = nums[i];
        nums[i] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {

        int[] nums = { 2,0,2,1,1,0};
        sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
