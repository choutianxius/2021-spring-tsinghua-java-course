package com.octopusthu.javaengineering.tournament.tba.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.octopusthu.javaengineering.tournament.jpa.PlayerEntity;
import com.octopusthu.javaengineering.tournament.jpa.TeamEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author octopusthu@gmail.com
 */
@Entity
@Table(name = "fixture_event")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixtureEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer seq;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fixture", nullable = false)
    private FixtureEntity fixture;

    @Column
    private String event;

    @Column(name = "event_minute_offset")
    private int eventMinuteOffset;

    @ManyToOne
    @JoinColumn(name = "team")
    private TeamEntity team;

    @ManyToOne
    @JoinColumn(name = "player")
    private PlayerEntity player;
}
