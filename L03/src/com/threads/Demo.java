package com.threads;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello from "+Thread.currentThread().getName());

        MyThread myThread = new MyThread();
//        myThread.setName("Child Thread");
        myThread.start();

        myThread.join();
        System.out.println("Waiting");

        MyThread myThread1 = new MyThread();
//        myThread.setName("Child Thread");
        myThread1.start();

        myThread1.join();
        System.out.println("End of main method");


        Thread thread = new Thread(new MyWork());
        thread.start();


    }


}

