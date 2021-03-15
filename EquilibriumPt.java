package com.practise;

public class EquilibriumPt {

    public static void main(String[] args) {
        int a[] =  {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(findEquilibrium(a));
    }

    private static int findEquilibrium(int a[]) {
        int sum = 0;
        for (int i = 1; i < a.length; i++) {
            sum += a[i];
        }

        int left = 0, right = sum;

        for (int i = 1; i < a.length; i++) {
            left += a[i-1];
            right -= a[i];

            if(left == right)
                return i+1;
        }
        return -1;
    }

}
