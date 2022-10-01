package com.gfg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        long start = System.currentTimeMillis();
        for(int i=0; i<100; i++) {
            executorService.submit(new MyTask(i+1));
        }
//        executorService.w();
        executorService.shutdown();
//        executorService.shutdownNow();

//        executorService.submit(new MyTask(21));

        while (!executorService.isTerminated()){
            ;
        }
        long end = System.currentTimeMillis();
        System.out.println("Total time:"+(end-start));
    }
}

