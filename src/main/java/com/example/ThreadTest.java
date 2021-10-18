package com.example;

/**
 * Hello world!
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable c = new MyRunnable();
        Thread t1 = new Thread(c);
        t1.start();
        Thread t2 = new Thread(c);
        t2.start();
        t1.join();
        t2.join();
        System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
        System.out.println(c.getN());
    }
}
