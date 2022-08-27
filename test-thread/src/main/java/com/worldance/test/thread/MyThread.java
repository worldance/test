package com.worldance.test.thread;

public class MyThread extends Thread {

    private int minIndex;

    private int maxIndex;

    public MyThread(int minIndex, int maxIndex) {
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
    }

    public MyThread(int minIndex, int maxIndex, String threadName) {
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
