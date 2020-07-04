package com.practise;

public class SearchInsertPosition {

    private static int searchInsert(int[] nums, int target) {
        return search(nums, 0, nums.length -1, target);
    }

    private static int search(int[] nums, int start, int end, int target) {

        if (start == end) {//single element
            if (nums[start] == target)
                return start;
            else if (nums[start] > target)
                return start;
            else
                return start+1;
        }

        int mid = (start + end + 1) / 2;

        if (mid > end || mid < start)
            return mid;

        if (nums[mid] == target)
            return mid;

        if (nums[mid] > target) {
            return search(nums, start, mid-1, target);
        } else
            return search(nums, mid+1, end, target);
    }

    public static void main(String[] args) {

        int[] nums = {1,3,5};
        int target = 4;
        System.out.println(searchInsert(nums, target));
    }

}
