package com.octopusthu.javaengineering.tournament.web;

import com.octopusthu.javaengineering.tournament.core.Player;
import com.octopusthu.javaengineering.tournament.core.PlayerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * "球员"领域实体 Controller
 *
 * @author octopusthu@gmail.com
 */
@RestController
@RequestMapping("/player")
public class PlayerRestController {
    private final PlayerService service;

    public PlayerRestController(@Qualifier("jdbcWithJdbcTemplatePlayerServiceImpl") PlayerService service) {
        this.service = service;
    }

    @PostMapping
    public void create(@RequestParam Integer id, @RequestParam String name) {
        service.createPlayer(id, name);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Integer id) {
        service.removePlayer(id);
    }

    @GetMapping("/{id}")
    public Player get(@PathVariable Integer id) {
        return service.getPlayer(id);
    }

    @GetMapping("/list")
    public List<Player> list() {
        return service.getAllPlayers();
    }

}
