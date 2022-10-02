package org.jbdl38.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class MyAppHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String msg = "Hello from MyApp by -"+Thread.currentThread().getName();
        httpExchange.sendResponseHeaders(200, msg.length());
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(msg.getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
