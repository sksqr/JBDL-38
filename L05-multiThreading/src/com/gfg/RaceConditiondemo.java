package com.gfg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RaceConditiondemo {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for(int i=0; i<100; i++) {
            executorService.submit(new VisitorCount());
        }
        executorService.shutdown();
        while (executorService.isTerminated()){
            ;
        }
        System.out.println("Visitors:"+VisitorCount.visitors);

        System.out.println("Atomic Visitors:"+VisitorCount.atomicVisitors.get());
    }
}
/*
visitor: 10
t-1: 10 -> 11
t-2: 10 -> 11

 */