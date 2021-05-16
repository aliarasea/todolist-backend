package com.winwin.todolist.dataaccess;

import com.winwin.todolist.model.TodoItem;
import com.winwin.todolist.repo.TodoItemRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TodoItemDao implements ITodoItemDao {
    private final TodoItemRepository repository;

    public TodoItemDao(TodoItemRepository repository) {
        this.repository = repository;
    }

    public List<TodoItem> get(int count) {
        return repository.findAll(PageRequest.of(0, count)).stream().sorted(Comparator.comparing(TodoItem::getCreateTime)).collect(Collectors.toList());
    }

    public List<TodoItem> get(String id) {
        Iterable<String> ids = Arrays.asList(id.split(","));
        return (List<TodoItem>) repository.findAllById(ids);
    }
}
