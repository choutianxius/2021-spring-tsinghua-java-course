package com.octopusthu.javaengineering.tournament.tba;

import com.octopusthu.javaengineering.tournament.core.FixtureService;
import com.octopusthu.javaengineering.tournament.tba.database.FixtureRepository;
import com.octopusthu.javaengineering.tournament.tba.database.FixtureServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * Spring Boot 主配置文件
 *
 * @author octopusthu@gmail.com
 */
//@Configuration
//@EnableJpaRepositories(basePackageClasses = FixtureRepository.class)
public class TournamentConfigTba {

    private final FixtureRepository fixtureRepository;

    public TournamentConfigTba(FixtureRepository fixtureRepository) {
        this.fixtureRepository = fixtureRepository;
    }

    @Bean
    @Primary
    FixtureService fixtureService() {
        return new FixtureServiceImpl(fixtureRepository);
    }
}
