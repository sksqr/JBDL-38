package org.jbdl38.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class SampleHttpServer {

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
            server.createContext("/hello", new HelloHandler());
            server.createContext("/app", new MyAppHandler());

            server.setExecutor(Executors.newFixedThreadPool(10));
            server.start();
            System.out.println(" Server started on port 8080");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
