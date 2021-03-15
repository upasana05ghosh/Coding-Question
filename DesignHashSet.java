package com.practise;

import java.util.LinkedList;
import java.util.List;

public class DesignHashSet {

    List<Integer> [] container;
    int cap = 1000;
    double loadFactor = 0.75;
    int count = 0;

    @SuppressWarnings("unchecked")
    public DesignHashSet() {
        container = new LinkedList[cap];
    }

    public void add(int key) {
        if(contains(key))
            return;

        if(loadFactor * cap == count) {
            cap = 2;
            List<Integer>[] oldCon = container;
            container = new LinkedList[cap];
            for(int i = 0; i< oldCon.length; i++) {
                List<Integer> list = oldCon[i];
                if (list != null) {
                    for(int entry : list) {
                        container[i].add(entry);
                    }
                }
            }
        }

        int hash = key % cap;
        if(container[hash] == null) {
            container[hash] = new LinkedList<>();
        }
        container[hash].add(key);
        count++;
    }

    public void remove(int key) {
        if(contains(key)) {
            int hash = key % cap;
            container[hash].remove(new Integer(key));
        }
    }

    public boolean contains(int key) {
        int hash = key % cap;

        if(container[hash] == null)
            return false;
        else {
            for(int entry : container[hash])
                if(entry == key)
                    return true;
        }
        return false;
    }

    public static void main(String s[]) {
        DesignHashSet obj = new DesignHashSet();
          obj.add(1);
          obj.remove(1);
          boolean param_3 = obj.contains(1);
          System.out.println(param_3);
    }

}
