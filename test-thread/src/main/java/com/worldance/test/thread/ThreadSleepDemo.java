package com.worldance.test.thread;

public class ThreadSleepDemo {

    public static void main(String[] args) {
		/*Thread t1 = new MyThread(0,20,"线程1");
		Thread t2 = new MyThread(20,40,"线程2");
		
		t1.setDaemon(true);
		t2.setDaemon(true);
		
		t1.start();
		t2.start();
		
		Thread.currentThread().setName("主线程");
		for(int i=0;i<4;i++){
			System.out.print(Thread.currentThread().getName()+"|"+i + " ");
		}*/
        System.out.println(Math.round(10.5));
        System.out.println(Math.round(12.55));
        System.out.println(Math.ceil(10.5));
        System.out.println(Math.floor(12.55));
    }

}
