package com.winwin.todolist.controller;

import com.winwin.todolist.model.TodoItem;
import com.winwin.todolist.service.TodoItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoItemRestController {
    private final TodoItemService service;

    public TodoItemRestController(TodoItemService service) {
        this.service = service;
    }

    @GetMapping(value = "/get/first/{count}")
    public List<TodoItem> getFirst(@PathVariable int count) {
        return service.getFirst(count);
    }

    @GetMapping(value = "/get/last/{count}")
    public List<TodoItem> getLast(@PathVariable int count) {
        return service.getLast(count);
    }

    @GetMapping(value = "/get/{id}")
    public List<TodoItem> getById(@PathVariable String id) {
        return service.get(id);
    }

    @PostMapping(value = "/add")
    public TodoItem add(@RequestBody TodoItem todoItem) {
        return service.add(todoItem);
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable String id){
        return service.delete(id);
    }

    @PostMapping(value = "/complete/{id}")
    public boolean complete(@PathVariable String id){
        return service.complete(id);
    }
}
