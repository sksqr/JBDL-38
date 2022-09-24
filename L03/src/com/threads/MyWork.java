package com.threads;

public class MyWork implements Runnable{
    @Override
    public void run() {
        System.out.println("Executing my work in "+Thread.currentThread().getName());
    }
}
