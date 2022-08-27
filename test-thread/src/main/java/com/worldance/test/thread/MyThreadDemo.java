package com.worldance.test.thread;

public class MyThreadDemo {

    public static void main(String[] args) {

        System.out.println("HelloWorld");
        System.out.println("hhhhaaa");

        Thread myThread1 = new MyThread(0, 20);
        myThread1.setName("tth1");
        myThread1.start();
        Thread myThread2 = new MyThread(30, 50);
        myThread2.setName("tth2");
        myThread2.start();

        System.out.println(myThread1.getName() + "优先级:" + myThread1.getPriority());
        System.out.println(myThread2.getName() + "优先级:" + myThread2.getPriority());

        Thread mainThread = Thread.currentThread();
        System.out.println("主线程:" + mainThread.getName());
    }

}
