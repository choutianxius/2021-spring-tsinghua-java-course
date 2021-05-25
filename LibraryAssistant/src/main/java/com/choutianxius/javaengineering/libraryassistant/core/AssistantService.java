package com.choutianxius.javaengineering.libraryassistant.core;

import com.choutianxius.javaengineering.libraryassistant.common.exception.DomainObjectException;

import java.util.List;

/**
 * 领域服务 - 队员
 *
 * @author choutianxius
 */
public interface AssistantService {

    /**
     * 创建新队员
     *
     * @param id   队员 ID ，不能与现有球员 ID 重复
     * @param name 队员姓名
     * @param phone 队员电话，可以为空
     * @throws DomainObjectException 如果 <code>id</code> 、<code>name</code> 格式不合法，或 <code>id</code> 与现有队员重复
     */
    void createAssistant(Integer id, String name, String phone) throws DomainObjectException;

    /**
     * 删除队员
     *
     * @param id 队员 ID
     * @throws DomainObjectException 如果根据 <code>id</code> 找不到球员，或者无法删除球员
     */
    void removeAssistant(Integer id) throws DomainObjectException;

    /**
     * 查询队员
     *
     * @param id 队员 ID
     * @return 根据 <code>id</code> 查询到的队员，不为 <code>null</code> 。
     * @throws DomainObjectException 如果根据 <code>id</code> 找不到队员
     */
    Assistant getAssistant(Integer id) throws DomainObjectException;

    /**
     * 查询全部队员
     *
     * @return 全部队员。如果一名球员也没有，则返回空列表。不会返回 <code>null</code> 。
     */
    List<Assistant> getAllAssistants();

    /**
     * 按等级查询队员
     *
     * @param rank 指定等级
     * @return 全部指定等级队员。如果一名球员也没有，则返回空列表。不会返回 <code>null</code> 。
     */
    //List<Assistant> getRankedAssistants(AssistantRank.Rank rank);
}
