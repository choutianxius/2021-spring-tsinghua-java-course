package com.octopusthu.javaengineering.tournament.core;

import lombok.AllArgsConstructor;
import lombok.Data;
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

}
