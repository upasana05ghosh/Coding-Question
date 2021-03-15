package com.practise;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer implements Runnable {
    private BlockingQueue<Integer> q;

    public Producer(BlockingQueue<Integer> q) {
        this.q = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Procedued: " + i);
            try {
                q.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<Integer> q;

    public Consumer(BlockingQueue<Integer> q) {
        this.q = q;
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("Consumer: " + q.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumerBQueue {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer>q = new LinkedBlockingQueue<Integer>();

        Thread p = new Thread(new Producer(q));
        Thread c = new Thread(new Consumer(q));

        p.start();
        c.start();

        System.out.println("Program terminated");

    }

}
