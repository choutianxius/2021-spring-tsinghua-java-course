package com.choutianxius.javaengineering.libraryassistant.jdbc;

import com.choutianxius.javaengineering.libraryassistant.common.exception.DomainObjectException;
import com.choutianxius.javaengineering.libraryassistant.core.Assistant;
import com.choutianxius.javaengineering.libraryassistant.core.AssistantService;
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
public class JdbcWithJdbcTemplateAssistantServiceImpl implements AssistantService{
    private final JdbcTemplate jdbcTemplate;

    public JdbcWithJdbcTemplateAssistantServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    static RowMapper<Assistant> assistantRowMapper = (rs, rowNum) -> new Assistant(
        rs.getInt("seq"),
        rs.getString("name"),
        rs.getString("phone")
    );

    @Override
    public void createAssistant(Integer id, String name, String phone)
        throws DomainObjectException {
        jdbcTemplate.update("insert into assistant.assistant(seq,name,phone) values " +
                "(?,?,?)", id,name,phone);
    }

    @Override
    public void removeAssistant(Integer id) throws DomainObjectException {
        jdbcTemplate.update("delete from player where seq=?", id);
    }

    @Override
    public Assistant getAssistant(Integer id) {
        return jdbcTemplate.queryForObject("select seq,name,phone from assistant.assistant where seq=?",
           assistantRowMapper, id);
    }

    @Override
    public List<Assistant> getAllAssistants(){
        return jdbcTemplate.query("select seq,name,phone from assistant",
            assistantRowMapper);
    }
}
