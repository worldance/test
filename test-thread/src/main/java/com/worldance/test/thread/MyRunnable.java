package com.worldance.test.thread;

public class MyRunnable implements Runnable {

    private int minIndex;

    private int maxIndex;

    public MyRunnable(int minIndex, int maxIndex) {
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
    }

    @Override
    public void run() {
        System.out.println("minIndex=" + minIndex + ",maxIndex=" + maxIndex);
        for (int i = minIndex; i < maxIndex; i++) {
            System.out.println(Thread.currentThread().getName() + "|" + i + " ");
        }

    }

}
