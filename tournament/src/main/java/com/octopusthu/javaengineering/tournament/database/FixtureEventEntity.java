package com.octopusthu.javaengineering.tournament.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
