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

    /**
     * TODO
     */
    @Test
    void removePlayerThenOk() {
    }

    /**
     * TODO
     */
    @Test
    void getPlayerThenOk() {
    }


    /**
     * TODO
     */
    @Test
    void getAllPlayersThenOk() {
    }

}
