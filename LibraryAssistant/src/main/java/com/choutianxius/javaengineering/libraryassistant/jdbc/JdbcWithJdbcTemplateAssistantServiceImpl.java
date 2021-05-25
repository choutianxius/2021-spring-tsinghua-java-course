package com.choutianxius.javaengineering.libraryassistant.jdbc;

import com.choutianxius.javaengineering.libraryassistant.common.exception.DomainObjectException;
import com.choutianxius.javaengineering.libraryassistant.core.Assistant;
import com.choutianxius.javaengineering.libraryassistant.core.AssistantService;
import com.choutianxius.javaengineering.libraryassistant.core.EnumClass;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 基于 Spring 框架的 {@link JdbcTemplate} 操作关系型数据库实现 {@link AssistantService}
 *
 * @author choutianxius@gmail.com
 */
@Service
public class JdbcWithJdbcTemplateAssistantServiceImpl {
    private final JdbcTemplate jdbcTemplate;
    public JdbcWithJdbcTemplateAssistantServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createAssistant(Integer id, String name, String phone) throws DomainObjectException {
        //jdbcTemplate.update("insert into assistant.assistant(seq,name,rank,phone) values " +
          //      "(?,?,?,?)", id,name,EnumClass.Rank.freshman.ordinal(),phone);
    }

}
