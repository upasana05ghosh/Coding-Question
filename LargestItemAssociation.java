package com.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class PairString {
    String first;
    String second;

    public PairString(String first, String second) {
        this.first = first;
        this.second = second;
    }
}

public class LargestItemAssociation {

    private static void print(List<String> st) {
        System.out.println("**************");
        for (String s : st) {
            System.out.println(s);
        }
    }

    public static List<String> largestItemAssociation(String[][] itemAssociation) {
        Map<String, Set<String>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        String x = null, y = null;
        for(String[] item : itemAssociation) {

            if(item[0].compareTo(item[1]) <= 0) {
                x = item[0];
                y = item[1];
            } else {
                x = item[1];
                y = item[0];
            }

          //move key if combine
            if (map.containsKey(x) && map.containsKey(y)) {
                map.get(x).addAll(map.get(y));
                map.remove(y);
                continue;
            }

            //check if exist
            boolean found = false;
            for(String key : map.keySet()) {
                if(map.get(key).contains(x) || map.get(key).contains(y)) {
                    map.get(key).add(y);
                    map.get(key).add(x);
                    found = true;
                }
            }

            if(!found) {
                map.put(x, new HashSet<>());
                map.get(x).add(x);
                map.get(x).add(y);
            }
        }

        int max = 0;
        String resKey = null;
        for(String key : map.keySet()) {
            if(map.get(key).size() >= max) {
                if(map.get(key).size() == max) {
                    if (key.compareTo(resKey) <= 0)
                        resKey = key;
                } else {
                    resKey = key;
                    max = map.get(key).size();
                }
            }
        }
        res.add(map.get(resKey).toString());
        return res;
    }

    public static void main(String[] args) {

        String [][] s = {{"A", "B"}, {"C", "D"}, {"D", "E"}, {"F", "E"}, {"A", "C"}, {"F", "E"}, {"X", "G"},{"X", "N"}, {"G", "K"}, {"K", "L"}, {"L", "M"}};
        List<String> st = largestItemAssociation(s);
        print(st);
    }

}
