package com.octopusthu.javaengineering.tournament.core;

import java.util.List;

public interface FixtureService {

    Fixture create(Fixture fixture);

    Fixture get(Integer id);

    List<Fixture> listByDateAndTime(boolean desc);

    List<Fixture> queryByField(String field);

    List<Fixture> queryByTeam(String team);

    void delete(Integer id);

    void deleteAll();

}
