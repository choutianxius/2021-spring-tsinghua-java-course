package com.octopusthu.javaengineering.tournament.web.dto;

/**
 * @author octopusthu@gmail.com
 */
public class TeamMemberDTO {
    private final Integer playerId;
    private final Integer squadNumber;
    private final Boolean captain;

    public TeamMemberDTO(Integer playerId, Integer squadNumber, Boolean captain) {
        this.playerId = playerId;
        this.squadNumber = squadNumber;
        this.captain = captain;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public Integer getSquadNumber() {
        return squadNumber;
    }

    public Boolean isCaptain() {
        return captain;
    }
}
