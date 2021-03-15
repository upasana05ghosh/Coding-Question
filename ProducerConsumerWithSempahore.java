package com.practise;

import java.util.concurrent.BlockingQueue;

class MyBlockingQueue<T> {
    T [] a;
    int size = 0;
    int capacity;
    int head;
    int tail;

    CountingSem mutex = new CountingSem(1,1);
    CountingSem semP;
    CountingSem semC;

    public MyBlockingQueue(int capacity) {
        a = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.semP = new CountingSem(capacity, capacity);
        this.semC = new CountingSem(capacity, 0);
    }

    public void put(T item) throws InterruptedException {
        semP.acquire();
        mutex.acquire();

        if(tail == capacity) {
            tail = 0;
        }
        a[tail] = item;
        size++;
        tail++;
        mutex.release();
        semC.release();
    }

    public T take() throws InterruptedException {
        T item = null;
        semC.acquire();
        mutex.acquire();

        if (head == capacity)
            head = 0;

        item = a[head];
        a[head] = null;
        head++;
        size--;
        semP.release();
        mutex.release();
        return item;
    }
}

class CountingSem {
    int usedPermit = 0;
    int maxCount = 0;

    public CountingSem(int count) {
        this.maxCount = count;
    }

    public CountingSem(int count, int initial) {
        this.maxCount = count;
        this.usedPermit = this.maxCount - initial;
    }

    public synchronized void acquire() throws InterruptedException {
        while(usedPermit == maxCount)
            wait();
        notify();
        usedPermit++;
    }

    public synchronized void release() throws InterruptedException {
        while(usedPermit == 0)
            wait();
        usedPermit--;
        notify();
    }
}

public class ProducerConsumerWithSempahore {

    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue<Integer> q = new MyBlockingQueue<>(5);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        q.put(new Integer(i));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Produced from thread 1 " + i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        System.out.println("Consumed from thread 2 " + q.take());
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        System.out.println("Consumed from thread 3 " + q.take());
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        Thread.sleep(5000);
        t2.start();
        t2.join();
        t3.start();
        t1.join();
        t3.join();
    }

}
