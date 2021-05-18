package com.octopusthu.javaengineering.tournament.inmemory;

import com.octopusthu.javaengineering.tournament.common.exception.DomainObjectException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void createPlayerWhenIdIsNullThenThrowDomainObjectException(){
        assertThrows(DomainObjectException.class, () -> service.createPlayer(null, "张三"));
    }

    @Test
    void createPlayerWhenNameIsNullThenThrowDomainObjectException(){
        assertThrows(DomainObjectException.class, () -> service.createPlayer(1, null));
    }

    @Test
    void createPlayerWhenNameIsEmptyThenThrowDomainObjectException(){
        assertThrows(DomainObjectException.class, () -> service.createPlayer(1, ""));
    }

    @Test
    void createPlayerWhenNameIsBlankThenThrowDomainObjectException(){
        assertThrows(DomainObjectException.class, () -> service.createPlayer(1, "  "));
    }

    @Test
    void createPlayerWhenIdIsDuplicateThenThrowDomainObjectException(){
        service.createPlayer(1, "张三");
        assertThrows(DomainObjectException.class, () -> service.createPlayer(1, "李四"));
    }


    @Test
    void removePlayerThenOk() {
        service.createPlayer(2,"a");
        service.removePlayer(2);
    }

    @Test
    void removePlayerWhenIdIsNullThenThrowsDomainObjectException() {
        assertThrows(DomainObjectException.class, () -> service.removePlayer(null));
    }

    @Test
    void getPlayerThenOk() {
        service.createPlayer(2,"b");
        service.getPlayer(2);
    }

    @Test
    void getPlayerWhenIdIsNullThenThrowsDomainObjectException() {
        assertThrows(DomainObjectException.class, () -> service.getPlayer(null));
    }


    @Test
    void getAllPlayersThenOk() {
        service.getAllPlayers();
    }

}
