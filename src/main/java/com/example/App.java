package com.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        AtomicTest at = new AtomicTest();
        Thread t1 = new Thread(at);
        Thread t2 = new Thread(at);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(at.getAi());
        System.out.println(at.getI());
    }
}
