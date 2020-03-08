package com.coding.practise.github;

/*
 * Given an unsorted array of nonnegative integers,
 * find a continuous subarray which adds to a given number.
 *
 *  Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
    Ouptut: Sum found between indexes 2 and 4


    Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
    Ouptut: Sum found between indexes 1 and 4

    Input: arr[] = {1, 4}, sum = 0
    Output: No subarray found

    Solution: Using Sliding window
    Complexity: O(n)
 * */

class SubArrayWithGivenSum {

    private static void findSubArryWithSum(int a[], int n, int sum) {
        int end = 0;
        int currSum = a[0];

        for (int start = 0; start < n; start++) {
            while (currSum < sum && (end + 1)< n) {
                currSum += a[++end];
            }
            if (currSum == sum) {
                System.out.println(start + " " + end);
                return;
            }
            currSum -= a[start];
        }

        System.out.println(-1); //No subArray found
    }
    public static void main(String[] args) {
        int a[] = new int[]{1, 4, 0, 0, 3, 10, 5};
        int n = a.length;
        findSubArryWithSum(a, n, 7);
    }
}