package com.gfg;

import java.util.concurrent.atomic.AtomicInteger;

public class VisitorCount implements Runnable{

    public static int visitors=0;

    public static AtomicInteger atomicVisitors = new AtomicInteger();


    @Override
    public void run() {
        atomicVisitors.incrementAndGet();
        incrementvisitor();
    }


    public static  synchronized   void  incrementvisitor(){
        visitors++;
    }
}
