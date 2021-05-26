package com.octopusthu.javaengineering.tournament;

import com.octopusthu.javaengineering.tournament.helloworld.HelloWorldRestController;
import com.octopusthu.javaengineering.tournament.inmemory.InMemoryPlayerServiceImpl;
import com.octopusthu.javaengineering.tournament.jdbc.JdbcPlayerServiceImpl;
import com.octopusthu.javaengineering.tournament.jpa.JpaPlayerServiceImpl;
import com.octopusthu.javaengineering.tournament.jpa.PlayerRepository;
import com.octopusthu.javaengineering.tournament.web.PlayerRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring Boot 启动程序
 *
 * @author octopusthu@gmail.com
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = {
    InMemoryPlayerServiceImpl.class,
    JdbcPlayerServiceImpl.class,
    JpaPlayerServiceImpl.class,
    PlayerRestController.class,
    HelloWorldRestController.class
})
@EnableJpaRepositories(basePackageClasses = PlayerRepository.class)
public class TournamentApplication {

    public static void main(String[] args) {
        SpringApplication.run(TournamentApplication.class, args);
    }

}
