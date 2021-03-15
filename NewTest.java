package com.practise;
/*
 *
 * 1. (m,n) at least 1 element in that range
 * 2. different length
 * 3. may contain duplicate
 * 4. ascending order
 *    [6,8] 2
 */

//bhargava@lenskart.in

public class NewTest {

    public static void main(String[] args) {
        int a[] = { 4, 7, 9, 13, 15, 19, 23 };
        int b[] = { 0, 8, 10, 14, 20, 21 };
        int c[] = { 6, 12, 16, 30, 50 };
        int[] res = findMinRange(a, b, c);
        System.out.println("Min Range is: [" + res[0] + " " + res[1] + "]");
    }

    private static int[] findMinRange(int[] a, int[] b, int[] c) {
        // final response
        int[] res = { -1, -1 };

        // pointer to a, b and c array
        int i = 0, j = 0, k = 0;

        int diff = Integer.MAX_VALUE;
        int min, max, minVal = -1;

        // length of a, b and c array
        int aLength = a.length, bLength = b.length, cLength = c.length;

        // we need to iterate to min length of a, b and c array
        int minLength = Math.min(aLength, Math.min(bLength, cLength));

        while (Math.max(k, Math.max(i, j)) < minLength) {

            int a1 = a[i];
            int b1 = b[j];
            int c1 = c[k];

            // find minimum
            min = Math.min(Math.min(c1, b1), a1);
            // find maximum
            max = Math.max(Math.max(c1, b1), a1);

            // update difference
            if (diff > max - min) {
                diff = max - min;
                minVal = min;
            }

            // increment 'min' value pointer so as to minimize the range
            if (i < aLength && min == a[i])
                i++;
            else if (j < bLength && min == b[j])
                j++;
            else if (k < cLength && min == c[k])
                k++;
        }

        // update response
        res[0] = minVal;
        res[1] = diff == Integer.MAX_VALUE ? -1 : minVal + diff;

        return res;
    }

}
