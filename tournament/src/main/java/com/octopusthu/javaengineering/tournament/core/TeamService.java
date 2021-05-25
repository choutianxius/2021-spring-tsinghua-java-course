package com.octopusthu.javaengineering.tournament.core;

import com.octopusthu.javaengineering.tournament.common.exception.DomainObjectException;

import java.util.List;

/**
 * 领域服务 - 球队
 *
 * @author octopusthu
 */
public interface TeamService {

    /**
     * 新建球队
     *
     * @param id      球队 ID ，不能与现有球队 ID 重复
     * @param name    球队名称
     * @param members 球队成员
     * @throws DomainObjectException 由于参数格式不合法、ID 重复、或其他原因无法新建球队
     */
    void createTeam(Integer id, String name, TeamMember... members) throws DomainObjectException;

    /**
     * 删除球队（同时移除全部球队成员）
     *
     * @param id 球队 ID
     * @throws DomainObjectException 如果根据 <code>id</code> 找不到球队，或者无法删除球队
     */
    void removeTeam(Integer id) throws DomainObjectException;

    /**
     * 查询球队
     *
     * @param id 球队 ID
     * @return 根据 <code>id</code> 查询到的球队，不为 <code>null</code> 。
     * @throws DomainObjectException 如果根据 <code>id</code> 找不到球队，或找到多支球队
     */
    Team getTeam(Integer id) throws DomainObjectException;

    /**
     * 查询全部球队
     *
     * @return 全部球队。如果一支球队也没有，则返回空列表。不会返回 <code>null</code> 。
     */
    List<Team> getAllTeams();

}
