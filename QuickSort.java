package com.practise;

public class QuickSort {

    public static void main(String[] args) {
        //int [] a = {10, 4, 8, 7, 17};
        int [] a = {2,2,2,2};
        quickSort(a, 0, a.length-1);

        System.out.println("Array after sorting: ");
        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) { //at least 2 elements
            int j = partition(a, low, high);
            quickSort(a, low, j-1);
            quickSort(a, j+1, high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        int v = a[low], i = low, j = high;

        while (i< j) {
            while(i <= high && v >= a[i])
                i++;
            while(v < a[j])
                j--;
            if (i < j)
                swap(a, i, j);
        }
        swap(a, low, j);

        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
