package com.choutianxius.javaengineering.libraryassistant.core;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Schedule {

    private final int id;
    private final EnumClass.Day day;
    private final EnumClass.Shift shift;
    public List<ScheduleMember> members = new ArrayList<>();

    Schedule(EnumClass.Day day, EnumClass.Shift shift, ScheduleMember captain){
        this.day = day;
        this.shift = shift;
        this.id = day.ordinal()*4+shift.ordinal()+1;
        Assert.isTrue(captain.isCaptain(),"member added in initialization" +
            "must be captains");
        members.add(captain);
    }

    public int getId(){
        return id;
    }

    public String getDay(){
        return day.toString();
    }

    public String getShift(){
        return shift.toString();
    }

    public List<ScheduleMember> getMembers(){
        return Collections.unmodifiableList(members);
    }

    public ScheduleMember getCaptain() {
        return getMembers().get(1);
    }
}
