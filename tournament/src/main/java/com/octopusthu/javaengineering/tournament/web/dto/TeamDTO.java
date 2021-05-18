package com.octopusthu.javaengineering.tournament.web.dto;

import java.util.List;

/**
 * @author octopusthu@gmail.com
 */
public class TeamDTO {
    private final Integer id;
    private final String name;
    private final List<TeamMemberDTO> members;

    public TeamDTO(Integer id, String name, List<TeamMemberDTO> members) {
        this.id = id;
        this.name = name;
        this.members = members;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<TeamMemberDTO> getMembers() {
        return members;
    }
}
