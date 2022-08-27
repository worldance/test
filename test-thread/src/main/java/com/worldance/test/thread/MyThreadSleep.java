package com.worldance.test.thread;

public class MyThreadSleep extends Thread {

    private int minIndex;

    private int maxIndex;

    public MyThreadSleep(int minIndex, int maxIndex) {
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
    }

    public MyThreadSleep(int minIndex, int maxIndex, String threadName) {
        super(threadName);
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
    }

    @Override
    public void run() {
        System.out.println("minIndex=" + minIndex + ",maxIndex=" + maxIndex);
        String threadName = getName();
        for (int i = minIndex; i < maxIndex; i++) {
            System.out.print(threadName + "|" + i + " ");
        }

    }

}
