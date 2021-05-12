package com.octopusthu.javaengineering.tournament.web;

import com.octopusthu.javaengineering.tournament.common.exception.DomainObjectException;
import com.octopusthu.javaengineering.tournament.core.Player;
import com.octopusthu.javaengineering.tournament.core.PlayerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlayerRestController.class)
public class PlayerRestControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PlayerService service;

    @Test
    void createThenOk() throws Exception {
        this.mvc.perform(post("/player")
            .param("id", "1")
            .param("name", "张三")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    void createWhenMissingParameterThenBadRequest() throws Exception {
        this.mvc.perform(post("/player")
            .param("id", "1")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }

    @Test
    void createWhenInvalidParameterThenBadRequest() throws Exception {
        this.mvc.perform(post("/player")
            .param("id", "abc")
            .param("name", "张三")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }

    @Test
    void createWhenDuplicateIdThenBadRequest() throws Exception {
        Mockito.doThrow(new DomainObjectException("id 与现有球员重复"))
            .when(service).createPlayer(anyInt(), anyString());
        this.mvc.perform(post("/player")
            .param("id", "1")
            .param("name", "张三")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }

    @Test
    void getThenOk() throws Exception {
        given(service.getPlayer(1))
            .willReturn(new Player(1, "张三"));
        this.mvc.perform(get("/player/1")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json(
                "{" +
                    "\"id\": 1,\n" +
                    "\"name\": \"张三\"\n" +
                    "}"));
    }

    @Test
    void listThenOk() throws Exception {
        given(service.getAllPlayers())
            .willReturn(
                List.of(
                    new Player(1, "张三"),
                    new Player(2, "李四")
                )
            );
        this.mvc.perform(get("/player/list")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json(
                "[" +
                    "{" +
                    "\"id\": 1,\n" +
                    "\"name\": \"张三\"\n" +
                    "},"
                    +
                    "{" +
                    "\"id\": 2,\n" +
                    "\"name\": \"李四\"\n" +
                    "}"
                    + "]"
            ));
    }

}
