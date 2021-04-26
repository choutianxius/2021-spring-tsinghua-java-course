package com.octopusthu.javaengineering.tournament.database;

import com.octopusthu.javaengineering.tournament.fixture.Fixture;
import com.octopusthu.javaengineering.tournament.fixture.FixtureService;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class FixtureServiceImpl implements FixtureService {

    private final FixtureRepository repository;

    public FixtureServiceImpl(FixtureRepository repository) {
        this.repository = repository;
    }

    @Override
    public Fixture create(Fixture fixture) {
        return convert(repository.save(convert(fixture)));
    }

    @Transactional(readOnly = true)
    @Override
    public Fixture get(Integer id) {
        return convert(repository.getOne(id));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Fixture> listByDateAndTime(boolean desc) {
        return convert(repository.findAll(Sort.by(desc ? Sort.Direction.DESC : Sort.Direction.ASC, "fixtureDate", "kickoffTime")));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Fixture> queryByField(String field) {
        return convert(repository.findByFieldContaining(field));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Fixture> queryByTeam(String team) {
        return convert(repository.findByHomeTeamNameContainingOrAwayTeamNameContaining(team, team));
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    protected FixtureEntity convert(Fixture fixture) {
        List<FixtureEventEntity> eventEntities = new ArrayList<>(fixture.getEvents().size());
        FixtureEntity entity = new FixtureEntity(fixture.getId(), fixture.getFixtureDate(), fixture.getKickoffTime(), fixture.getField(), convert(fixture.getHomeTeam()), convert(fixture.getAwayTeam()), fixture.getHomeTeamScore(), fixture.getAwayTeamScore(), eventEntities);
        fixture.getEvents().forEach(e -> eventEntities.add(convert(e, entity)));
        return entity;
    }

    protected FixtureEventEntity convert(Fixture.FixtureEvent event, FixtureEntity fixtureEntity) {
        return new FixtureEventEntity(event.getId(), fixtureEntity, event.getEvent(), event.getEventMinuteOffset(), convert(event.getTeam()), convert(event.getPlayer()));
    }

    protected TeamEntity convert(Fixture.Team team) {
        return new TeamEntity(team.getId(), team.getName());
    }

    protected PlayerEntity convert(Fixture.Player player) {
        return new PlayerEntity(player.getId(), player.getName());
    }

    protected Fixture convert(FixtureEntity entity) {
        List<Fixture.FixtureEvent> events = new ArrayList<>(entity.getEvents().size());
        entity.getEvents().forEach(e -> events.add(convert(e)));
        return new Fixture(entity.getSeq(), entity.getFixtureDate(), entity.getKickoffTime(), entity.getField(), convert(entity.getHomeTeam()), convert(entity.getAwayTeam()), entity.getHomeTeamScore(), entity.getAwayTeamScore(), events);
    }

    protected Fixture.FixtureEvent convert(FixtureEventEntity entity) {
        return new Fixture.FixtureEvent(entity.getSeq(), entity.getEvent(), entity.getEventMinuteOffset(), convert(entity.getTeam()), convert(entity.getPlayer()));
    }

    protected Fixture.Team convert(TeamEntity entity) {
        return new Fixture.Team(entity.getSeq(), entity.getName());
    }

    protected Fixture.Player convert(PlayerEntity entity) {
        return new Fixture.Player(entity.getSeq(), entity.getName());
    }

    protected List<Fixture> convert(List<FixtureEntity> entities) {
        List<Fixture> fixtures = new ArrayList<>(entities.size());
        entities.forEach(entity -> fixtures.add(convert(entity)));
        return fixtures;
    }
}
