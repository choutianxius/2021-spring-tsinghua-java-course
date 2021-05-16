package com.octopusthu.javaengineering.tournament;

import com.octopusthu.javaengineering.tournament.database.JdbcPlayerServiceImpl;
import com.octopusthu.javaengineering.tournament.helloworld.HelloWorldRestController;
import com.octopusthu.javaengineering.tournament.inmemory.InMemoryPlayerServiceImpl;
import com.octopusthu.javaengineering.tournament.web.PlayerRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring Boot 启动程序
 *
 * @author octopusthu@gmail.com
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = {
    InMemoryPlayerServiceImpl.class,
    JdbcPlayerServiceImpl.class,
    PlayerRestController.class,
    HelloWorldRestController.class
})
public class TournamentApplication {

    public static void main(String[] args) {
        SpringApplication.run(TournamentApplication.class, args);
    }

}
