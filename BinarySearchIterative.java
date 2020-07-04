package com.practise;

public class BinarySearchIterative {

    public static void main(String[] args) {
        int[] a = { 3, 6, 7, 9 };
        int key = 8;

        System.out.println(binarySearch(a, key));
    }

    private static int binarySearch(int[] a, int key) {
        int low = 0, high = a.length -1;

        while(low <= high) {
            int mid = (low + high) /2;
            if(a[mid] == key)
                return mid;
            if (a[mid] > key)
                high = mid-1;
            else
                low = mid + 1;
        }
        return -1;
    }

}
