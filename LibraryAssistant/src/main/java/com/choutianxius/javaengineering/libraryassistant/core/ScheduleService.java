package com.choutianxius.javaengineering.libraryassistant.core;

import com.choutianxius.javaengineering.libraryassistant.common.exception.DomainObjectException;

import java.util.List;

/**
 * 领域服务 - 班次
 *
 * @author choutianxius
 */
public interface ScheduleService {

    /**
     * 新建/初始化
     *
     * @param day    周几
     * @param shift  班次
     * @param captain 班次负责人
     * @throws DomainObjectException 由于参数格式不合法、ID 重复、或其他原因无法初始化班次
     */
    void createTeam(EnumClass.Day day, EnumClass.Shift shift, ScheduleMember captain) throws DomainObjectException;

    /**
     * 添加队员
     *
     * @param day    周几
     * @param shift  班次
     * @param members 普通队员，可以为null
     * @throws DomainObjectException 由于参数格式不合法、ID 重复、或其他原因无法添加队员
     */
    void addMembers(EnumClass.Day day, EnumClass.Shift shift, ScheduleMember... members);

    /**
     * 查询班次内队员
     *
     */
    List<ScheduleMember> getScheduleMembers();

    /**
     * 删除队员，不能是班次负责人
     *
     * @param scheduleids 队员班次内编号
     * @throws DomainObjectException 如果根据 <code>id</code> 找不到球队，或者无法删除球队
     */
    void removeScheduleMembers(Integer... scheduleids);

    /**
     * 改变班次负责人
     *
     * @param newid 新班次负责人id
     * @throws DomainObjectException 如果根据 <code>id</code> 找不到球队，或者无法删除球队
     */
    void changeCaptain(Integer newid);
}
