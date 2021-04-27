package com.octopusthu.javaengineering.tournament.tba.database;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * @author octopusthu@gmail.com
 */
@Entity
@Table(name = "fixture")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixtureEntity {

    @Id
    @Column
    private Integer seq;

    @Column(name = "fixture_date")
    private Date fixtureDate;

    @Column(name = "kickoff_time")
    private Time kickoffTime;

    @Column
    private String field;

    @ManyToOne
    @JoinColumn(name = "home_team")
    private TeamEntity homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team")
    private TeamEntity awayTeam;

    @Column(name = "home_team_score")
    private int homeTeamScore;

    @Column(name = "away_team_score")
    private int awayTeamScore;

    @OneToMany(mappedBy = "fixture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FixtureEventEntity> events;
}
