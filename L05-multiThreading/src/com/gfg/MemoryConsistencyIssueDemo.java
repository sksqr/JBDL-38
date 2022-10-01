package com.gfg;

import sun.awt.windows.ThemeReader;

public class MemoryConsistencyIssueDemo {
    public static void main(String[] args) {
        MyThread sender = new MyThread("S");
        MyThread receiver = new MyThread("R");


        Thread thread2 = new Thread(receiver);
        thread2.start();

        Thread thread1 = new Thread(sender);
        thread1.start();

    }
}

class MyThread implements Runnable{
    private static volatile int val;
    private String type;

    public MyThread(String type) {
        this.type = type;
    }

    @Override
    public void run() {
        if(type.equals("R")){
            while (val !=-1){
                System.out.println("val in thread:"+ Thread.currentThread().getName()+" is :"+val);
                val++;
            }
        }
        else{
            try {
                Thread.sleep(0);
                val=-1;
                System.out.println("Setting "+val+" val to -1 in "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
