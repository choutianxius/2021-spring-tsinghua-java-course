package com.octopusthu.javaengineering.tournament.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloWorldRestController.class)
public class HelloWorldRestControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void testHelloWorld() throws Exception {
        this.mvc.perform(get("/hello-world")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json(
                "{" +
                    "\"status\": 1,\n" +
                    "\"message\": \"Hello, world!\"\n" +
                    "}"));
    }

}
