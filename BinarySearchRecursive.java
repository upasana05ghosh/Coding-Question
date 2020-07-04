package com.practise;

public class BinarySearchRecursive {

    public static void main(String[] args) {

        int[] a = {3,6,7,9};
        int key = 8;

        System.out.println(binarySearch(a, key, 0, a.length-1));

    }

    private static int binarySearch(int[] a, int key, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == key)
                return mid;
            if (a[mid] > key)
                return binarySearch(a, key, low, mid-1);
            else
                return binarySearch(a, key, mid+1, high);
        }
        return -1;
    }

}
