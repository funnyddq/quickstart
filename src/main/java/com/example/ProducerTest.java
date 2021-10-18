package com.example;

import java.io.PrintStream;

public class ProducerTest {
    public static void main(String[] args) {
        Cache caches = new Cache();
        Producer producer = new Producer(caches);
        Customer customer = new Customer(caches);
        for (int i = 0; i < 2; i++) {
            new Thread(producer, "Producer" + i).start();
        }
        for (int i = 0; i < 4; i++) {
            new Thread(customer, "Customer-" + i).start();
        }
    }
}

class Producer implements Runnable {
    private Cache caches;

    public Producer(Cache caches) {
        this.caches = caches;
    }

    public Cache getCaches() {
        return caches;
    }

    public void setCaches(Cache caches) {
        this.caches = caches;
    }

    @Override
    public void run() {
        synchronized (System.out) {
            int n = (int) Thread.currentThread().getId();

            while (true) {
                try {
                    Thread.sleep(1000);
                    caches.push(n);
                    System.out.print(Thread.currentThread().getName());
                    System.out.println(" push: " + n);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Customer implements Runnable {
    private Cache caches;

    public Customer(Cache caches) {
        this.caches = caches;
    }

    public Cache getCaches() {
        return caches;
    }

    public void setCaches(Cache caches) {
        this.caches = caches;
    }

    @Override
    public void run() {
        int n;
        synchronized (System.out) {
            while (true) {
                try {
                    Thread.sleep(1000);
                    n = caches.pop();
                    System.out.print("Customer-" + Thread.currentThread().getName());
                    System.out.println(" pop: " + n);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Cache {
    private int[] data;
    private int size;

    public Cache() {
        data = new int[10];
        size = 0;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int size() {
        return size;
    }

    public synchronized void push(int n) throws InterruptedException {
        while (size == 10)
            wait();

        data[size++] = n;
        notifyAll();
        return;
    }

    public synchronized int pop() throws InterruptedException {
        while (size == 0)
            wait();

        int ret = data[size--];
        notifyAll();
        return ret;

    }
}
