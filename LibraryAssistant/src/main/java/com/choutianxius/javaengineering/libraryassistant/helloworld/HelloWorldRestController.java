package com.choutianxius.javaengineering.libraryassistant.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Spring Boot Hello World Controller
 *
 * @author octopusthu@gmail.com
 */
@RestController
public class HelloWorldRestController {
    private final HelloWorldService service;

    public HelloWorldRestController(HelloWorldService service) {
        this.service = service;
    }

    @GetMapping("/hello-world")
    public Map<String, Object> helloWorld() {
        return service.helloWorld();
    }

}
