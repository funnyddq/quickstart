package com.example;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest implements Runnable {
    protected AtomicInteger ai = new AtomicInteger(0);
    protected Integer i = new Integer(0);

    public AtomicInteger getAi() {
        return ai;
    }

    public void setAi(AtomicInteger ai) {
        this.ai = ai;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public Integer getI() {
        return i;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            ai.getAndAdd(1);
        }
        for (int j = 0; j < 1000000; j++) {
            i++;
        }
    }
}