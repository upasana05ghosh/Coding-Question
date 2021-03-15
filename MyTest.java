package com.practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class MyTest {

    public static List<Integer> findLeader(int a[]) {

        List<Integer> res = new ArrayList<>();

        int n = a.length;

        if (n == 0)
            return res;

        int maxSofar = a[n-1];

        res.add(a[n-1]);

        for(int i = n-2; i>=0; i--) {
            if(a[i] > maxSofar) {
                res.add(a[i]);
                maxSofar = a[i];
            }
        }

        return res;
    }

    public static int getNextLeader(int [] a, int val) {

        int i;
        //Check the value index
        for( i = 0; i< a.length; i++) {
            if (a[i] == val)
                break;
        }

        //next leader with respect to ith element
        for(int j = i+1; j< a.length; j++) {
            if (a[j] > val)
                return a[j];
        }

        return -1;
    }

    public static void printNextElement (int a[]) {
        Stack<Integer> s = new Stack<>();

        for(int i = a.length -1; i>=0; i--) {
            if(s.isEmpty())
                System.out.println(a[i] + " : -1");
            else {
                while(!s.isEmpty() && s.peek() < a[i])
                    s.pop();
                if(!s.isEmpty())
                    System.out.println(a[i] + " : " + s.peek());
                else
                    System.out.println(a[i] + " : -1");
            }
            s.push(a[i]);
        }
    }

    public static void increment(int a[], int start, int end, int incrementVal) {

        a[start] += incrementVal;
        a[end + 1] -= incrementVal;

    }

    public static void printArray(int [] a) {

        //increment(a, 1,4, 100);

        for(int i = 0; i< a.length; i++) {
            a[i] = a[i -1] + a[i];
        }
    }



    public static void main(String[] args) {

        int a [] = {0,1,4, 3}; //n = 4 (0 to n)

        int n = 5;
        //int val = n & -n;

        for (n = 1; n < 7; n++) {
            int val = (int)((Math.log10(n & -n)) / Math.log10(2));
           // System.out.println(n + " " + val);
        }

        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(null);

        l.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);





        //a = {2,3,1,4} // n = 4 -- sum n(n-1)/2
        // 1.... n  (i + 1) % n

        //We are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.


        //List<Integer> res = findLeader(a);

        //res.stream().forEach(System.out::println);

        //printNextElement(a);

        // (abacd)ef(abcd)
       // [0,0,1,]
        //abcd
    }


}
