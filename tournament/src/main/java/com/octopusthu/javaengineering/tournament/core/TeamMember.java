package com.octopusthu.javaengineering.tournament.core;

import com.octopusthu.javaengineering.tournament.common.exception.DomainObjectException;

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
        if(squadNumber>0 && squadNumber<100) {
            this.player = player;
            this.squadNumber = squadNumber;
            this.isCaptain = isCaptain;
        }
        else throw new DomainObjectException("SquadNumber can't <=0 or >=99");
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
