package org.jbdl38;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoServer {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting server");
        Scanner scanner = new Scanner(System.in);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        while (true){
            System.out.println("Waiting for request data:");
            String requestdata = scanner.nextLine();
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Processing data: "+requestdata+" in thread:"+Thread.currentThread().getName());
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

    }
}


/*

while(true){

// Accept http request
// executorService.submit(httRequest);

}
 */
