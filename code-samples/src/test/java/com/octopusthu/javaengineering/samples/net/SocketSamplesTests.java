package com.octopusthu.javaengineering.samples.net;

import com.octopusthu.javaengineering.samples.net.SocketSamples.HelloWorldClient;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SocketSamplesTests {

    @Test
    void serverClientHelloWorld() throws IOException {
        HelloWorldClient client = new HelloWorldClient();
        client.startConnection("127.0.0.1", 1234);
        String response = client.sendMessage("Hello, server!");
        assertEquals("Hello, client!", response);
        client.stopConnection();
    }
}
