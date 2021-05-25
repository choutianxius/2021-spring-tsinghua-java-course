package com.octopusthu.javaengineering.tournament.core;

import com.octopusthu.javaengineering.tournament.common.exception.DomainObjectException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeamMemberTests {
    Player player1 = new Player(1, "Bob");

    @Test
    public void Constructor_1_ThenOK() {
        TeamMember member = new TeamMember(player1, 1, true);
        assertEquals(player1, member.getPlayer());
        assertEquals(1, member.getSquadNumber());
        assertTrue(member.isCaptain());
    }

    @Test
    public void Constructor_2_ThenOK() {
        TeamMember member = new TeamMember(player1, 1);
        assertEquals(player1, member.getPlayer());
        assertEquals(1, member.getSquadNumber());
        assertFalse(member.isCaptain());
    }

    @Test
    public void SquadNumberOutOfBoundaryThenException() {
        assertThrows(DomainObjectException.class, () -> new TeamMember(player1,
            0, true));
        assertThrows(DomainObjectException.class, () -> new TeamMember(player1,
            100, true));
        assertThrows(DomainObjectException.class, () -> new TeamMember(player1,
            0));
        assertThrows(DomainObjectException.class, () -> new TeamMember(player1,
            100));
    }

    @Test
    public void getPlayerThenOK(){
        assertEquals(player1,
            new TeamMember(player1, 1, true).getPlayer());
    }

    @Test
    public void getSquadNumberThenOK(){
        assertEquals(1,
            new TeamMember(player1, 1, true).getSquadNumber());
    }

    @Test
    public void isCaptainThenOK(){
        assertTrue(new TeamMember(player1, 1, true).isCaptain());
    }
}
