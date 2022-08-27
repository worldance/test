package com.worldance.test.thread;

public class MyRunnableDemo {

    public static void main(String[] args) {
        Runnable r1 = new MyRunnable(0, 20);
        Runnable r2 = new MyRunnable(20, 40);

        Thread t1 = new Thread(r2, "线程1");
        Thread t2 = new Thread(r2, "线程2");

        t1.start();
        t2.start();

        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 4; i++) {
            System.out.print(Thread.currentThread().getName() + "|" + i + " ");
        }

    }

}
