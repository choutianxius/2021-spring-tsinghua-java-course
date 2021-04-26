package com.octopusthu.javaengineering.tournament.fixture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * @author octopusthu@gmail.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fixture {
    private Integer id;
    private Date fixtureDate;
    private Time kickoffTime;
    private String field;
    private Team homeTeam;
    private Team awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;
    private List<FixtureEvent> events;

    @AllArgsConstructor
    @Getter
    public static class FixtureEvent {
        private final Integer id;
        private final String event;
        private final int eventMinuteOffset;
        private final Team team;
        private final Player player;
    }

    @AllArgsConstructor
    @Getter
    public static class Team {
        private final Integer id;
        private final String name;
    }

    @AllArgsConstructor
    @Getter
    public static class Player {
        private final Integer id;
        private final String name;
    }
}
