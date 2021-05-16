package com.octopusthu.javaengineering.tournament.database;

import com.octopusthu.javaengineering.tournament.common.exception.DomainObjectException;
import com.octopusthu.javaengineering.tournament.core.Player;
import com.octopusthu.javaengineering.tournament.core.PlayerService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 基于 Spring 框架的 {@link JdbcTemplate} 操作关系型数据库实现 {@link PlayerService}
 *
 * @author octopusthu@gmail.com
 */
@Service
public class JdbcWithJdbcTemplatePlayerServiceImpl implements PlayerService {
    private final JdbcTemplate jdbcTemplate;

    public JdbcWithJdbcTemplatePlayerServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createPlayer(Integer id, String name) throws DomainObjectException {

    }

    @Override
    public void removePlayer(Integer id) throws DomainObjectException {

    }

    @Override
    public Player getPlayer(Integer id) throws DomainObjectException {
        return jdbcTemplate.queryForObject("select seq,name from player where seq=?",
            playerRowMapper, id);
    }

    @Override
    public List<Player> getAllPlayers() {
        return jdbcTemplate.query("select seq,name from player",
            playerRowMapper);
    }

    static RowMapper<Player> playerRowMapper = (rs, rowNum) -> new Player(
        rs.getInt("seq"),
        rs.getString("name")
    );
}
