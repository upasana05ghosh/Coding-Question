package com.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    Map<Integer, Integer>map;
    List<Integer>a;
    Random rm;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        a = new ArrayList<>();
        rm = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        a.add(val);
        map.put(val, a.size());
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int index = map.get(val);
        int lastIndex = a.size() -1;
        if(index < lastIndex) {
            int lastElement = a.get(lastIndex);
            a.set(index, lastElement);
            map.put(lastElement, index);
        }
        a.remove(lastIndex);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        a.forEach(v -> System.out.println("val is : " + v));
        int ran = new Random().nextInt(a.size());
        return a.get(ran);
    }

    public static void main(String[] args) {

    }

}
