package org.example.routes;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;

public class Router {
    public void addRoutes(HttpServer server) {
        server.createContext("/", new IndexHandler());
        server.createContext("/bank", new BankHandler());
        server.createContext("/user", new UserHandler());
        server.createContext("/account", new AccountHandler());
        server.createContext("/transaction", new TransactionHandler());
    }
}
