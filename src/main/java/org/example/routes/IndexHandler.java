package org.example.routes;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class IndexHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String requestParams = null;
        if ("GET".equals(httpExchange.getRequestMethod())) {
            requestParams = handleGetRequest(httpExchange);
        } else if ("POST".equals(httpExchange.getRequestMethod())) {
            requestParams = handlePostRequest(httpExchange);
        }
        handleResponse(httpExchange, requestParams);
    }

    private void handleResponse(HttpExchange httpExchange, String requestParams) throws IOException {
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

    public String handleGetRequest(HttpExchange httpExchange) {
        return "/INDEX:GET - " + httpExchange.getRequestURI().toString();
    }

    public String handlePostRequest(HttpExchange httpExchange) {
        return "/INDEX:POST -  " + httpExchange.getRequestURI().toString();
    }
}
