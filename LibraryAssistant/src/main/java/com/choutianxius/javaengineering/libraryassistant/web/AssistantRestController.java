package com.choutianxius.javaengineering.libraryassistant.web;

import com.choutianxius.javaengineering.libraryassistant.core.Assistant;
import com.choutianxius.javaengineering.libraryassistant.core.AssistantService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * "队员"领域实体 Controller
 *
 * @author choutianxius@gmail.com
 */
@RestController
@RequestMapping("/assistant")
public class AssistantRestController {
    private final AssistantService service;

    public AssistantRestController(@Qualifier("jdbcWithJdbcTemplateAssistantServiceImpl") AssistantService service) {
        this.service = service;
    }

    @PostMapping
    public void create(@RequestParam Integer id, @RequestParam String name, @RequestParam String phone) {
        service.createAssistant(id, name, phone);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Integer id) {
        service.removeAssistant(id);
    }

    @GetMapping("/{id}")
    public Assistant get(@PathVariable Integer id) {
        return service.getAssistant(id);
    }

    @GetMapping("/list")
        public List<Assistant> list() {
            return service.getAllAssistants();
    }

}
