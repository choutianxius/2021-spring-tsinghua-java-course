package com.choutianxius.javaengineering.libraryassistant.inmemory;

import com.choutianxius.javaengineering.libraryassistant.inmemory.InMemoryAssistantServiceImpl;
import com.choutianxius.javaengineering.libraryassistant.common.exception.DomainObjectException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InMemoryAssistantServiceImplTests {
    private InMemoryAssistantServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new InMemoryAssistantServiceImpl();
    }

    @AfterEach
    void tearDown() {
        service = null;
    }

    @Test
    void createAssistantThenOk() {
        service.createAssistant(1, "张三", "17300000000");
    }

    @Test
    void createAssistantWhenIdIsNullThenThrowDomainObjectException(){
        assertThrows(DomainObjectException.class, () -> service.createAssistant(null, "张三", "17300000000"));
    }

    @Test
    void createAssistantWhenNameIsNullThenThrowDomainObjectException(){
        assertThrows(DomainObjectException.class, () -> service.createAssistant(1, null, "17300000000"));
    }

    @Test
    void createAssistantWhenNameIsEmptyThenThrowDomainObjectException(){
        assertThrows(DomainObjectException.class, () -> service.createAssistant(1, "", "17300000000"));
    }

    @Test
    void createAssistantWhenNameIsBlankThenThrowDomainObjectException(){
        assertThrows(DomainObjectException.class, () -> service.createAssistant(1, "  ", "17300000000"));
    }

    @Test
    void createAssistantWhenIdIsDuplicateThenThrowDomainObjectException(){
        service.createAssistant(1, "张三", "17300000000");
        assertThrows(DomainObjectException.class, () -> service.createAssistant(1, "李四", "17300000000"));
    }


    @Test
    void removeAssistantThenOk() {
        service.createAssistant(2,"a", "17300000000");
        service.removeAssistant(2);
    }

    @Test
    void removeAssistantWhenIdIsNullThenThrowsDomainObjectException() {
        assertThrows(DomainObjectException.class, () -> service.removeAssistant(null));
    }

    @Test
    void getAssistantThenOk() {
        service.createAssistant(2,"b", "17300000000");
        service.getAssistant(2);
    }

    @Test
    void getAssistantWhenIdIsNullThenThrowsDomainObjectException() {
        assertThrows(DomainObjectException.class, () -> service.getAssistant(null));
    }

    @Test
    void getAllAssistantsThenOk() {
        service.getAllAssistants();
    }

}
