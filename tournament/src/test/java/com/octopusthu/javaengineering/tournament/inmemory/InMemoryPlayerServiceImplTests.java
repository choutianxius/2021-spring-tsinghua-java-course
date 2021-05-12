package com.octopusthu.javaengineering.tournament.inmemory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InMemoryPlayerServiceImplTests {
    private InMemoryPlayerServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new InMemoryPlayerServiceImpl();
    }

    @AfterEach
    void tearDown() {
        service = null;
    }

    @Test
    void createPlayerThenOk() {
        service.createPlayer(1, "张三");
    }

    @Test
    void removePlayerThenOk() {
    }

    @Test
    void getPlayerThenOk() {
    }

    @Test
    void getAllPlayersThenOk() {
    }
}
