package com.octopusthu.javaengineering.tournament.core;

/**
 * 领域实体 - 球队成员
 *
 * @author octopusthu@gmail.com
 */
public class TeamMember {
    private final Player player;
    private final int squadNumber;
    private final boolean isCaptain;

    public TeamMember(Player player, int squadNumber) {
        this(player, squadNumber, false);
    }

    public TeamMember(Player player, int squadNumber, boolean isCaptain) {
        this.player = player;
        this.squadNumber = squadNumber;
        this.isCaptain = isCaptain;
    }

    public Player getPlayer() {
        return player;
    }

    public int getSquadNumber() {
        return squadNumber;
    }

    public boolean isCaptain() {
        return isCaptain;
    }
}
