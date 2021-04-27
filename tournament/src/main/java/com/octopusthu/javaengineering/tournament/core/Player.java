package com.octopusthu.javaengineering.tournament.core;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

/**
 * 领域实体 - 球员
 *
 * @author octopusthu@gmail.com
 */
public class Player {

    /**
     * 球员 ID
     */
    private final Integer id;

    /**
     * 球员姓名
     */
    private final String name;

    public Player(Integer id, String name) {
        Assert.notNull(id, "id cannot be null");
        Assert.isTrue(StringUtils.isNotBlank(name), "name cannot be blank");
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
