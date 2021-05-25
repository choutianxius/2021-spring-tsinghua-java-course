package com.choutianxius.javaengineering.libraryassistant.core;

/**
 * 领域实体 - 班次成员
 *
 * @author choutianxius@gmail.com
 */
public class ScheduleMember {
    private final Integer scheduleid;
    private final Assistant assistant;
    private final boolean isCaptain;

    public ScheduleMember(Integer scheduleid, Assistant assistant, boolean isCaptain) {
        this.scheduleid = scheduleid;
        this.assistant = assistant;
        this.isCaptain = isCaptain;
    }
    public Integer getScheduleid() {return this.scheduleid;}
    public Assistant getAssistant(){
        return this.assistant;
    }
    public boolean isCaptain(){
        return this.isCaptain;
    }
}
