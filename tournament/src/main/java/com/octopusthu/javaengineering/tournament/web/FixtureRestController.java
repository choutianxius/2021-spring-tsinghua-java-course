package com.octopusthu.javaengineering.tournament.web;

import com.octopusthu.javaengineering.tournament.fixture.Fixture;
import com.octopusthu.javaengineering.tournament.fixture.FixtureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author octopusthu@gmail.com
 */
@RestController
public class FixtureRestController {

    private final FixtureService service;

    public FixtureRestController(FixtureService service) {
        this.service = service;
    }

    @GetMapping("/api/fixture/{seq}")
    public Fixture get(@PathVariable int seq) {
        return service.get(seq);
    }

    @GetMapping("/api/fixture/list/by-date-and-time")
    public List<Fixture> listByDateAndTime(@RequestParam(required = false, defaultValue = "true") boolean desc) {
        return service.listByDateAndTime(desc);
    }

    @GetMapping("/api/fixture/query/by-field")
    public List<Fixture> queryByField(@RequestParam String field) {
        return service.queryByField(field);
    }

    @GetMapping("/api/fixture/query/by-team")
    public List<Fixture> queryByTeam(@RequestParam String team) {
        return service.queryByTeam(team);
    }

    @DeleteMapping("/api/fixture/{seq}")
    public void delete(@PathVariable int seq) {
        service.delete(seq);
    }

    @DeleteMapping("/api/fixture")
    public void deleteAll() {
        service.deleteAll();
    }

}
