package com.octopusthu.javaengineering.tournament.jpa;

import com.octopusthu.javaengineering.tournament.common.exception.DomainObjectException;
import com.octopusthu.javaengineering.tournament.core.Player;
import com.octopusthu.javaengineering.tournament.core.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author octopusthu@gmail.com
 */
@Service
public class JpaPlayerServiceImpl implements PlayerService {

    private final PlayerRepository repository;

    public JpaPlayerServiceImpl(PlayerRepository repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     * <p>
     * TODO: find bug(s)
     */
    @Override
    public void createPlayer(Integer id, String name) throws DomainObjectException {
        repository.save(new PlayerEntity(id, name));
    }

    @Override
    public void removePlayer(Integer id) throws DomainObjectException {
        repository.deleteById(id);
    }

    @Override
    public Player getPlayer(Integer id) throws DomainObjectException {
        return convert(repository.getOne(id));
    }

    @Override
    public List<Player> getAllPlayers() {
        return repository.findAll().stream()
            .map(this::convert)
            .collect(Collectors.toList());
    }

    protected Player convert(PlayerEntity entity) {
        return new Player(entity.getSeq(), entity.getName());
    }
}
