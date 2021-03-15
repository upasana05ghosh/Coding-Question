package com.practise;

class Sender {

    public synchronized void send(String msg) throws InterruptedException {
        System.out.println("message sending");
        Thread.sleep(5000);
        System.out.println("message sent");
    }
}

class ThreadSend extends Thread {
    private String msg;
    Sender s;

    public ThreadSend(String msg, Sender s) {
        this.msg = msg;
        this.s = s;
    }

    public void run() {
        try {
            s.send(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class JavaSynchronizationLearn {

    public static void main(String[] args) throws InterruptedException {

        Sender s = new Sender();
        Thread s1 = new ThreadSend("Thread 1", s);
        Thread s2 = new ThreadSend("Thread 2", s);

        s1.start();
        s2.start();

        s1.join();
        s2.join();
    }

}
