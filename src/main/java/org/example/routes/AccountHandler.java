package org.example.routes;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class AccountHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String requestParams = null;
        if ("GET".equals(httpExchange.getRequestMethod())) {
            requestParams = handleGetRequest(httpExchange);
        } else if ("POST".equals(httpExchange.getRequestMethod())) {
            requestParams = handlePostRequest(httpExchange);
        }
        handleRequest(httpExchange, requestParams);
    }

    private void handleRequest(HttpExchange httpExchange, String requestParams) throws IOException {
        System.out.println(requestParams);

        OutputStream outputStream = httpExchange.getResponseBody();
        StringBuilder htmlBuilder = new StringBuilder();

        htmlBuilder.append("<html>")
                .append("<body>")
                .append("<h1>")
                .append(requestParams)
                .append("</h1>")
                .append("</body>")
                .append("</html>");

        String htmlResponse = htmlBuilder.toString();

        httpExchange.sendResponseHeaders(200, htmlResponse.length());
        outputStream.write(htmlResponse.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    private String handleGetRequest(HttpExchange httpExchange) {
        return "/ACCOUNT:GET - " + httpExchange.getRequestURI();
    }

    private String handlePostRequest(HttpExchange httpExchange) {
        return "/ACCOUNT:GET - " + httpExchange.getRequestURI();
    }
}
