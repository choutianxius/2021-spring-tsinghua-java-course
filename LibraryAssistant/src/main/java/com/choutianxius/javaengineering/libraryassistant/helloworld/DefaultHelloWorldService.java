package com.choutianxius.javaengineering.libraryassistant.helloworld;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Primary
public class DefaultHelloWorldService implements HelloWorldService {
    @Override
    public Map<String, Object> helloWorld() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("status", 1);
        map.put("message", "Hello, world!");
        return map;
    }
}
