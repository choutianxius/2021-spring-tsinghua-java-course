package com.octopusthu.javaengineering.tournament.database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FixtureRepository extends JpaRepository<FixtureEntity, Integer> {

    List<FixtureEntity> findByFieldContaining(String field);

    List<FixtureEntity> findByHomeTeamNameContainingOrAwayTeamNameContaining(String homeTeam, String awayTeam);

}
