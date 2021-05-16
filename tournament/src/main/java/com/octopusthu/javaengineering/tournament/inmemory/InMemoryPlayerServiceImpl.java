package com.octopusthu.javaengineering.tournament.inmemory;

import com.octopusthu.javaengineering.tournament.common.exception.DomainObjectException;
import com.octopusthu.javaengineering.tournament.core.Player;
import com.octopusthu.javaengineering.tournament.core.PlayerService;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void createPlayer(Integer id, String name) throws DomainObjectException {
        if (players.get(id) != null) {
            throw new DomainObjectException("duplicate player id: " + id);
        }
        try {
            players.put(id, new Player(id, name));
        } catch (Exception e) {
            throw new DomainObjectException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removePlayer(Integer id) throws DomainObjectException {
        if (players.get(id) == null) {
            throw new DomainObjectException("Nonexistent player id: " + id);
        }
        try {
            players.remove(id);
        } catch (Exception e) {
            throw new DomainObjectException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Player getPlayer(Integer id) throws DomainObjectException {
        Player player;
        try {
            player = players.get(id);
        } catch (Exception e) {
            throw new DomainObjectException(e);
        }
        if (player == null) {
            throw new DomainObjectException("Nonexistent player id: " + id);
        }
        return player;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Player> getAllPlayers() {
        return List.copyOf(players.values());
    }
}
