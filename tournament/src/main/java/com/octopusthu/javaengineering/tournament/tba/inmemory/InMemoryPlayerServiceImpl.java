package com.octopusthu.javaengineering.tournament.tba.inmemory;

import com.octopusthu.javaengineering.tournament.tba.common.exception.DomainObjectException;
import com.octopusthu.javaengineering.tournament.tba.core.Player;
import com.octopusthu.javaengineering.tournament.tba.core.PlayerService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用内存存储方式实现 {@link PlayerService}
 *
 * @author octopusthu@gmail.com
 */
@Service
public class InMemoryPlayerServiceImpl implements PlayerService {
    private final Map<Integer, Player> players = new HashMap<>();

    @Override
    public void createPlayer(Integer id, String name) throws DomainObjectException {
        players.put(id, new Player(id, name));
    }

    @Override
    public void removePlayer(Integer id) throws DomainObjectException {
        players.remove(id);
    }

    @Override
    public Player getPlayer(Integer id) throws DomainObjectException {
        return players.get(id);
    }

    @Override
    public List<Player> getAllPlayers() {
        return List.copyOf(players.values());
    }
}
