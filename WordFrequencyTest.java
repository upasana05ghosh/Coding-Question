package com.practise;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WordFrequencyTest {

    private static int THREAD_POOL_VAL = 10;

    private static String readArticle(String url) {
        return url;
    }

    private static void countMultiThreaded() {
        String[] urls = { "Hi there!", "How are you!", "Ï'm fine" };

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_VAL);
        ConcurrentMap<String, Integer> m = new ConcurrentHashMap<>();

        for (String url : urls) {
            executorService.execute(() -> {

                try {
                    String content = readArticle(url);
                    String[] words = content.split("\\W+");
                    for (String word : words) {
                        m.compute(word.toLowerCase(), (k, v) -> v == null ? 1 : v + 1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
        }

        executorService.shutdown();

        // wait till all task are terminated
        while (!executorService.isTerminated()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // program terminated

        printResults(m);
        System.out.println("program terminated");

    }

    private static void printResults(ConcurrentMap<String, Integer> map) {
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }

    public static void main(String[] args) {
        countMultiThreaded();
    }

}
