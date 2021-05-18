package com.octopusthu.javaengineering.tournament.core;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 领域实体 - 球队
 *
 * @author octopusthu@gmail.com
 */
public class Team {

    /**
     * 球队至少应有几名成员
     */
    public static int MIN_TEAM_SIZE = 3;

    /**
     * 球队 ID
     */
    private final Integer id;

    /**
     * 球队名称
     */
    private final String name;

    /**
     * 球队成员
     */
    private final List<TeamMember> members = new ArrayList<>();

    public Team(Integer id, String name, TeamMember... members) {
        Assert.notNull(id, "id cannot be null");
        Assert.isTrue(StringUtils.isNotBlank(name), "name cannot be blank");
        Assert.isTrue(ArrayUtils.isNotEmpty(members), "members cannot be empty");
        Assert.isTrue(members.length >= MIN_TEAM_SIZE, "a team must have at least " + MIN_TEAM_SIZE + " members");
        Assert.noNullElements(members, "member cannot be null");
        this.id = id;
        this.name = name;
        this.members.addAll(Arrays.asList(members));
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<TeamMember> getMembers() {
        return Collections.unmodifiableList(members);
    }

    public TeamMember getCaptain() {
        return getMembers().stream()
            .filter(TeamMember::isCaptain)
            .findFirst()
            .orElse(null);
    }

}
