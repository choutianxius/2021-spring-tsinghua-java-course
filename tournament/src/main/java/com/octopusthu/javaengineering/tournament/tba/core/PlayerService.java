package com.octopusthu.javaengineering.tournament.tba.core;

import com.octopusthu.javaengineering.tournament.tba.common.exception.DomainObjectException;

import java.util.List;

/**
 * 领域服务 - 球员
 *
 * @author octopusthu
 */
public interface PlayerService {

    /**
     * 新建球员
     *
     * @param id   球员 ID ，不能与现有球员 ID 重复
     * @param name 球员姓名
     * @throws DomainObjectException 如果 <code>id</code> 、<code>name</code> 格式不合法，或 <code>id</code> 与现有球员重复
     */
    void createPlayer(Integer id, String name) throws DomainObjectException;

    /**
     * 删除球员
     *
     * @param id 球员 ID
     * @throws DomainObjectException 如果根据 <code>id</code> 找不到球员，或者无法删除球员
     */
    void removePlayer(Integer id) throws DomainObjectException;

    /**
     * 查询球员
     *
     * @param id 球员 ID
     * @return 根据 <code>id</code> 查询到的球员，不为 <code>null</code> 。
     * @throws DomainObjectException 如果根据 <code>id</code> 找不到球员
     */
    Player getPlayer(Integer id) throws DomainObjectException;

    /**
     * 查询全部球员
     *
     * @return 全部球员。如果一名球员也没有，则返回空列表。不会返回 <code>null</code> 。
     */
    List<Player> getAllPlayers();

}
