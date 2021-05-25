package com.octopusthu.javaengineering.tournament.core;

import com.octopusthu.javaengineering.tournament.common.exception.DomainObjectException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class TeamTests {
    Player player1 = new Player(1, "Bob");
    Player player2 = new Player(2, "Chris");
    Player player3 = new Player(3, "David");
    Player player4 = new Player(4, "Eric");
    Player player5 = new Player(5, "Franklin");
    Player player6 = new Player(6, "Gatsbi");
    TeamMember member1 = new TeamMember(player1,1, true);
    TeamMember member2 = new TeamMember(player2, 2);
    TeamMember member3 = new TeamMember(player3, 3);
    TeamMember member4 = new TeamMember(player4, 4, true);
    TeamMember member5 = new TeamMember(player5,5);
    TeamMember member6 = new TeamMember(player6, 2);



    @Test
    public void ConstructorThenOK(){
        new Team(1, "team1", member1, member2, member3);
    }

    @Test
    public void IdNullThenException() {
        assertThrows(Exception.class, () -> new Team(null, "team1", member1, member2, member3));
    }

    @Test
    public void NameBlankThenException() {
        assertThrows(Exception.class, () -> new Team(1, " ", member1, member2, member3));
    }

    @Test
    public void MembersEmptyThenException(){
        assertThrows(Exception.class, () -> new Team(1, "team1"));
    }

    @Test
    public void MembersNotEnoughThenException(){
        assertThrows(Exception.class, () -> new Team(1, "team1", member1, member2));
    }

    @Test
    public void MembersHaveNullThenException(){
        assertThrows(Exception.class, () -> new Team(1, "team1", member1, member2, null));
    }

    @Test
    public void WrongCaptainNumberThenException(){
        assertThrows(Exception.class, () -> new Team(1, "team1", member5, member2, member3));
        assertThrows(Exception.class, () -> new Team(1, "team1", member1, member2, member4));
    }

    @Test
    public void DuplicativeSquadNumberThenException(){
        assertThrows(Exception.class, () -> new Team(1, "team1", member1, member2, member6));
    }

    @Test
    public void getIDThenOK(){
        assertEquals(1, new Team(1, "team1", member1, member2, member3).getId());
    }

    @Test
    public void getNameThenOK(){
        assertEquals("team1", new Team(1, "team1", member1, member2, member3).getName());
    }

    @Test
    public void getMembersThenOK(){
        ArrayList<TeamMember> memberlist = new ArrayList<TeamMember>();
        memberlist.add(member1);memberlist.add(member2);memberlist.add(member3);
        assertEquals(Collections.unmodifiableList(memberlist),
            new Team(1, "team1", member1, member2, member3).getMembers());
    }

    @Test
    public void getCaptainThenOK(){
        assertEquals(member1, new Team(1, "team1", member1, member2, member3).getCaptain());
    }
}
