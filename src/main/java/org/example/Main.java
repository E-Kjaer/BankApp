package org.example;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(0, "testbank");
        User admin = new User(true, "admin", "test@gmail.com", "123");
        bank.addUser(admin);

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
            server.setExecutor(threadPoolExecutor);

            Router router = new Router();
            router.addRoutes(server);

            server.start();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
