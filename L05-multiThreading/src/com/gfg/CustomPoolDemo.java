package com.gfg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomPoolDemo {

    public static void main(String[] args) {

        int  corePoolSize  =    5;
        int  maxPoolSize   =   10;
        long keepAliveTime = 5000;
        int queueSize=10;
        ExecutorService executorService =
                new ThreadPoolExecutor(
                        corePoolSize,
                        maxPoolSize,
                        keepAliveTime,
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>(queueSize)
                );

        long start = System.currentTimeMillis();
        for(int i=0; i<100; i++) {
            executorService.submit(new MyTask(i+1));
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){
            ;
        }
        long end = System.currentTimeMillis();
        System.out.println("Total time:"+(end-start));

    }

}
