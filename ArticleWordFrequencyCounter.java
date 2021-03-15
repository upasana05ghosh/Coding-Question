package com.practise;

import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArticleWordFrequencyCounter {

    private static int THREAD_POOL_VAL = 10;

    private static String readArticle(String articleUrl) throws Exception {
            URL url = new URL(articleUrl);
            return org.apache.commons.io.IOUtils.toString(url, "utf-8");
    }


   private static String[] readUrls(String filePath) {

     InputStream inputStream = new FileInputStream(new File(filePath));

     String[] urls = org.apache.commons.io.IOUtils.readLines(inputStream);

     inputStream.close();

     return urls;

   }


  private static void countMultiThreaded(String filePath) {
     String[] urls = readUrls(filePath);

     ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_VAL);
     ConcurrentMap<String, Integer> m = new ConcurrentHashMap<>();

     for(String url: urls) {
         executorService.execute(() -> {
             String content;
            try {
                content = readArticle(url);
                String[] words = content.split("\\W+");
                 for(String word: words) {
                     m.compute(word.toLowerCase(), (k, v) -> v == null ? 1 : v + 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

         });
     }


   // to free up system resources and to allow graceful application shutdown.
   //Submitted tasks are still executed, but no new tasks will be accepted.
    executorService.shutdown();

   //wait till all task are terminated
   while (!executorService.isTerminated()) {
       try {
            TimeUnit.SECONDS.sleep(1);
       } catch (InterruptedException e) {
             e.printStackTrace();
       }
       }
   //program terminated
   System.out.println("program terminated");

  }

  public static void main(String[] args)  {
     String filePath = args[0];

     countMultiThreaded(filePath);
  }
}
