package com.octopusthu.javaengineering.tournament.helloworld;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VerboseHelloWorldService implements HelloWorldService {
    @Override
    public Map<String, Object> helloWorld() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("status", 1);
        map.put("message", "Hello, world! Hi! Blah blah blah...");
        return map;
    }
}
