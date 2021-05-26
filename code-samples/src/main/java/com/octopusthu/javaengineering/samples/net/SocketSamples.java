package com.octopusthu.javaengineering.samples.net;

import org.springframework.util.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用 Java Socket 实现简单的基于 TCP 的服务器/客户端。
 *
 * @author octopusthu@gmail.com
 */
public class SocketSamples {

    static class HelloWorldServer {
        private ServerSocket serverSocket;
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        static int minPort = 1000;
        static int maxPort = 1999;

        public void start(int port) throws IOException {
            Assert.isTrue(port >= minPort && port <= maxPort,
                "Only port from " + minPort + " to " + maxPort + " is supported!");
            serverSocket = new ServerSocket(port);

            System.out.println("Server starts to listen on port " + port + "...");
            clientSocket = serverSocket.accept();

            String expectedClientMessage = "Hello, server!";
            String expectedServerMessage = "Hello, client!";
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String actualClientMessage = in.readLine();
            System.out.println("Server received message: " + actualClientMessage);
            String actualServerMessage = expectedClientMessage.equals(actualClientMessage) ?
                expectedServerMessage : "Unexpected message from client: " + actualClientMessage;
            out.println(actualServerMessage);
            System.out.println("Server sent message: " + actualServerMessage);

            stop();
        }

        public void stop() throws IOException {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Server stopped.");
        }

        public static void main(String[] args) throws IOException {
            HelloWorldServer server = new HelloWorldServer();
            server.start(1234);
        }
    }

    static class HelloWorldClient {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public void startConnection(String ip, int port) throws IOException {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }

        public String sendMessage(String msg) throws IOException {
            out.println(msg);
            return in.readLine();
        }

        public void stopConnection() throws IOException {
            in.close();
            out.close();
            clientSocket.close();
        }
    }

}
