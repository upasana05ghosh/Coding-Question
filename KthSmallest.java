package com.practise;

public class KthSmallest {


    private static int findKthSmallest(int [] a, int k) {
        int l = 0, h = a.length -1;
        while (l <= h) {
            int j = partition(a, l, h);
            if (j == k) {
                break;
            }
            if (j > k)
                h = j-1;
            else
                l = j+1;
        }
        return a[k];
    }

    private static int partition(int []a, int start, int end) {
        int v = a[start], i = start, j = end;

        while(i <= j) {
            while(i <= end && v >= a[i])
                i++;
            while(v < a[j])
                j--;
            if(i < j)
                swap(a, i, j);
        }

        swap(a, start, j);
        return j;
    }

    private static void swap(int []a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String s[]) {
        int a[] = {7, 10, 4, 3, 2};

        System.out.println(findKthSmallest(a, 0));
    }

}
