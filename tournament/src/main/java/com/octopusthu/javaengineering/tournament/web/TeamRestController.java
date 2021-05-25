package com.octopusthu.javaengineering.tournament.web;

import com.octopusthu.javaengineering.tournament.core.PlayerService;
import com.octopusthu.javaengineering.tournament.core.Team;
import com.octopusthu.javaengineering.tournament.core.TeamMember;
import com.octopusthu.javaengineering.tournament.core.TeamService;
import com.octopusthu.javaengineering.tournament.web.dto.TeamDTO;
import com.octopusthu.javaengineering.tournament.web.dto.TeamMemberDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * "球队"领域实体 Controller
 *
 * @author octopusthu@gmail.com
 */
@RestController
@RequestMapping("/team")
public class TeamRestController {
    private final TeamService service;
    private final PlayerService playerService;

    public TeamRestController(
        @Qualifier("jpaTeamServiceImpl") TeamService service,
        @Qualifier("jpaPlayerServiceImpl") PlayerService playerService
    ) {
        this.service = service;
        this.playerService = playerService;
    }

    @PostMapping
    public void create(@RequestBody TeamDTO teamDTO) {
        TeamMember[] teamMembers = teamDTO.getMembers().stream()
            .map(this::convert)
            .collect(Collectors.toList())
            .toArray(new TeamMember[]{});
        service.createTeam(teamDTO.getId(), teamDTO.getName(), teamMembers);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Integer id) {
        service.removeTeam(id);
    }

    @GetMapping("/{id}")
    public Team get(@PathVariable Integer id) {
        return service.getTeam(id);
    }

    @GetMapping("/list")
    public List<Team> list() {
        return service.getAllTeams();
    }

    private TeamMember convert(TeamMemberDTO teamMemberDTO) {
        return new TeamMember(
            playerService.getPlayer(teamMemberDTO.getPlayerId()),
            teamMemberDTO.getSquadNumber(),
            teamMemberDTO.isCaptain()
        );
    }

}
