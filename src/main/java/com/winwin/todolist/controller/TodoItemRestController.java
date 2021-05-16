package com.winwin.todolist.controller;

import com.winwin.todolist.model.TodoItem;
import com.winwin.todolist.service.TodoItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TodoItemRestController {
    private final TodoItemService service;

    public TodoItemRestController(TodoItemService service) {
        this.service = service;
    }

    @GetMapping(value = "getfirst/{count}")
    public List<TodoItem> get(@PathVariable int count) {
        return service.get(count);
    }

    @GetMapping(value = "get/{id}")
    public List<TodoItem> get(@PathVariable String id) {
        return service.get(id);
    }
}
