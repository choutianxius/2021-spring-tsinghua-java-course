package com.octopusthu.javaengineering.tournament;

import com.octopusthu.javaengineering.tournament.web.HelloWorldRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring Boot 启动程序
 *
 * @author octopusthu@gmail.com
 */
@SpringBootApplication(exclude = {
    DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class
})
@ComponentScan(basePackageClasses = {HelloWorldRestController.class})
public class TournamentApplication {

    public static void main(String[] args) {
        SpringApplication.run(TournamentApplication.class, args);
    }

}
