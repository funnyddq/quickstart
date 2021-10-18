package com.example;

public class MyRunnable implements Runnable {
    public static int n = 0;

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
        for (int i = 0; i < 1000000; i++)
            synchronized (MyRunnable.class) {
                n++;
            }
        return;
    }

    public int getN() {
        return n;
    }
}
