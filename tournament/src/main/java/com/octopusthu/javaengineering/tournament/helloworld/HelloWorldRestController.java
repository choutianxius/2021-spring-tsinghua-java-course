package com.octopusthu.javaengineering.tournament.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Spring Boot Hello World Controller
 *
 * @author octopusthu@gmail.com
 */
@RestController
public class HelloWorldRestController {

    @GetMapping("/hello-world")
    public Map<String, Object> helloWorld() {
        Map<String, Object> map = new HashMap<>(1);
        map.put("status", 1);
        map.put("message", "Hello, world!");
        return map;
    }

}
