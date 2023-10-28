package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;

public class Router {
    public void addRoutes(HttpServer server) {
        server.createContext("/", new IndexHandler());
    }

    private class IndexHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String requestParams = null;

            handleResponse(httpExchange, requestParams);
        }

        public void handleResponse(HttpExchange httpExchange, String requestParams) throws IOException {
            OutputStream outputStream = httpExchange.getResponseBody();

            String body = "Success";

            httpExchange.sendResponseHeaders(200, body.length());

            outputStream.write(body.getBytes());
            outputStream.flush();
            outputStream.close();
        }
    }
}
