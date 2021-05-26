package com.choutianxius.javaengineering.libraryassistant;

import com.choutianxius.javaengineering.libraryassistant.helloworld.HelloWorldRestController;
import com.choutianxius.javaengineering.libraryassistant.inmemory.InMemoryAssistantServiceImpl;
import com.choutianxius.javaengineering.libraryassistant.jdbc.JdbcWithJdbcTemplateAssistantServiceImpl;
import com.choutianxius.javaengineering.libraryassistant.web.AssistantRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring Boot 启动程序
 *
 * @author choutianxius.com
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = {
    InMemoryAssistantServiceImpl.class,
    JdbcWithJdbcTemplateAssistantServiceImpl.class,
    AssistantRestController.class,
    HelloWorldRestController.class
})
public class AssistantApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssistantApplication.class, args);
    }

}
