package com.octopusthu.javaengineering.tournament;

import com.octopusthu.javaengineering.tournament.database.FixtureRepository;
import com.octopusthu.javaengineering.tournament.database.FixtureServiceImpl;
import com.octopusthu.javaengineering.tournament.fixture.FixtureService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring Boot 主配置文件
 *
 * @author octopusthu@gmail.com
 */
@Configuration
@EnableJpaRepositories(basePackageClasses = FixtureRepository.class)
public class TournamentConfig {

    private final FixtureRepository fixtureRepository;

    public TournamentConfig(FixtureRepository fixtureRepository) {
        this.fixtureRepository = fixtureRepository;
    }

    @Bean
    @Primary
    FixtureService fixtureService() {
        return new FixtureServiceImpl(fixtureRepository);
    }
}
