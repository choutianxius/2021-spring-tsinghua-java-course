package com.octopusthu.javaengineering.tournament.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FixtureEvent {
    private final Integer id;
    private final String event;
    private final int eventMinuteOffset;
    private final Team team;
    private final Player player;
}
