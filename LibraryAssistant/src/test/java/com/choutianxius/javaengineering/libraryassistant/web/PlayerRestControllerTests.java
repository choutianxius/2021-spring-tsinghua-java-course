package com.choutianxius.javaengineering.libraryassistant.web;

import com.choutianxius.javaengineering.libraryassistant.core.Assistant;
import com.choutianxius.javaengineering.libraryassistant.common.exception.DomainObjectException;
import com.choutianxius.javaengineering.libraryassistant.core.AssistantService;
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

@WebMvcTest(AssistantRestController.class)
public class PlayerRestControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AssistantService service;

    @Test
    void createThenOk() throws Exception {
        this.mvc.perform(post("/assistant")
            .param("id", "1")
            .param("name", "张三")
            .param("phone", "17300000000")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    void createWhenMissingParameterThenBadRequest1() throws Exception {
        this.mvc.perform(post("/assistant")
            .param("id", "1")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }

    @Test
    void createWhenMissingParameterThenBadRequest2() throws Exception {
        this.mvc.perform(post("/assistant")
            .param("id", "1")
            .param("name", "张三")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }

    @Test
    void createWhenInvalidParameterThenBadRequest() throws Exception {
        this.mvc.perform(post("/assistant")
            .param("id", "abc")
            .param("name", "张三")
            .param("phone", "17300000000")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }

    @Test
    void createWhenDuplicateIdThenBadRequest() throws Exception {
        Mockito.doThrow(new DomainObjectException("id 与现有球员重复"))
            .when(service).createAssistant(anyInt(), anyString(), anyString());
        this.mvc.perform(post("/assistant")
            .param("id", "1")
            .param("name", "张三")
            .param("phone", "17300000000")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }

    @Test
    void getThenOk() throws Exception {
        given(service.getAssistant(1))
            .willReturn(new Assistant(1, "张三", "17300000000"));
        this.mvc.perform(get("/assistant/1")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json(
                "{" +
                    "\"id\": 1,\n" +
                    "\"name\": \"张三\"\n" +
                    "\"phone\": \"17300000000\"\n" +
                    "}"));
    }

    @Test
    void listThenOk() throws Exception {
        given(service.getAllAssistants())
            .willReturn(
                List.of(
                    new Assistant(1, "张三", "17300000000"),
                    new Assistant(2, "李四", "17311111111")
                )
            );
        this.mvc.perform(get("/assistant/list")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json(
                "[" +
                    "{" +
                    "\"id\": 1,\n" +
                    "\"name\": \"张三\"\n" +
                    "\"phone\": \"17300000000\"\n" +
                    "},"
                    +
                    "{" +
                    "\"id\": 2,\n" +
                    "\"name\": \"李四\"\n" +
                    "\"phone\": \"17311111111\"\n" +
                    "}"
                    + "]"
            ));
    }

}
