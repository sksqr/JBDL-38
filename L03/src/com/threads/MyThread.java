package com.threads;

public class MyThread extends Thread{

    @Override
    public void run(){
        System.out.println("In Thread :"+Thread.currentThread().getName());
    }

}
