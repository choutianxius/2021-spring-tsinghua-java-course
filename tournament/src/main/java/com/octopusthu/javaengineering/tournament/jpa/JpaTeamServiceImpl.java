package com.octopusthu.javaengineering.tournament.jpa;

import com.octopusthu.javaengineering.tournament.common.exception.DomainObjectException;
import com.octopusthu.javaengineering.tournament.core.Player;
import com.octopusthu.javaengineering.tournament.core.Team;
import com.octopusthu.javaengineering.tournament.core.TeamMember;
import com.octopusthu.javaengineering.tournament.core.TeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author octopusthu@gmail.com
 */
@Service
public class JpaTeamServiceImpl implements TeamService {
    private final TeamRepository repository;
    private final PlayerRepository playerRepository;

    public JpaTeamServiceImpl(TeamRepository repository, PlayerRepository playerRepository) {
        this.repository = repository;
        this.playerRepository = playerRepository;
    }

//    @Transactional(rollbackFor = {
//        Exception.class
//    })
    @Override
    public void createTeam(Integer id, String name, TeamMember... members) throws DomainObjectException {
        final TeamEntity teamEntity = repository.save(new TeamEntity(id, name, null));
        List<TeamMemberEntity> memberEntities = Arrays.stream(members)
            .map(teamMember -> convert(teamMember, teamEntity))
            .collect(Collectors.toList());
        teamEntity.setMembers(memberEntities);
        repository.save(teamEntity);
    }

    @Transactional(rollbackFor = {
        Exception.class
    })
    @Override
    public void removeTeam(Integer id) throws DomainObjectException {
        repository.deleteById(id);
    }

    @Override
    public Team getTeam(Integer id) throws DomainObjectException {
        return convert(repository.getOne(id));
    }

    @Override
    public List<Team> getAllTeams() {
        return repository.findAll().stream()
            .map(this::convert)
            .collect(Collectors.toList());
    }

    protected Team convert(TeamEntity entity) {
        return new Team(
            entity.getSeq(),
            entity.getName(),
            entity.getMembers().stream()
                .map(this::convert)
                .toArray(TeamMember[]::new)
        );
    }

    protected TeamMember convert(TeamMemberEntity entity) {
        return new TeamMember(
            convert(entity.getPlayer()),
            entity.getSquadNumber(),
            entity.getCaptain()
        );
    }

    protected Player convert(PlayerEntity entity) {
        return new Player(entity.getSeq(), entity.getName());
    }

    protected TeamMemberEntity convert(TeamMember teamMember, TeamEntity teamEntity) {
        TeamMemberEntity teamMemberEntity = new TeamMemberEntity();
        teamMemberEntity.setTeam(teamEntity);
        teamMemberEntity.setPlayer(playerRepository.getOne(teamMember.getPlayer().getId()));
        teamMemberEntity.setSquadNumber(teamMember.getSquadNumber());
        teamMemberEntity.setCaptain(teamMember.isCaptain());
        return teamMemberEntity;
    }
}
