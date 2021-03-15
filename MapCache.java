package com.practise;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class MapCache {

    class Cache {

        Map<String, Node> map = new HashMap<>();

        public void put(String key, String value, int ttl, RefreshFunction fun) {
            map.put(key, new Node(value, ttl, fun, LocalDateTime.now()));
        }

        public String get(String key) {
            Node n = map.get(key);
            if (isTimeValid(n.ttl, n.entryTime)) {
                update(key);
            }
            return map.get(key).value;
        }

        private boolean isTimeValid(int ttl, LocalDateTime entryTime) {
            LocalDateTime currTime = LocalDateTime.now();
            if (currTime.isBefore(entryTime.plusSeconds(ttl))) {
                return false;
            }
            return true;
        }

        private void update(String key) {
            Node n = map.get(key);
            n.value = n.fun.refresh(key);
            n.entryTime = LocalDateTime.now();
        }

        class Node {
            String value;
            int ttl;
            RefreshFunction fun;
            LocalDateTime entryTime;

            public Node(String value, int ttl, RefreshFunction fun, LocalDateTime entryTime) {
                this.value = value;
                this.ttl = ttl;
                this.fun = fun;
                this.entryTime = entryTime;
            }
        }

    }

    interface RefreshFunction {
        String refresh(String key);
    }

    public static void main(String[] args) {
        System.out.println("Hello Java");
    }

}
