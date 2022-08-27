package com.worldance.test.thread;

public class ThreadPriorityDemo {

    public static void main(String[] args) {
        Thread t1 = new MyThread(0, 20, "线程1");
        Thread t2 = new MyThread(20, 40, "线程2");

        t1.setPriority(10);
        t2.setPriority(1);

        t1.start();
        t2.start();

        System.out.println(t1.getName() + "优先级:" + t1.getPriority());
        System.out.println(t2.getName() + "优先级:" + t2.getPriority());

    }

}
