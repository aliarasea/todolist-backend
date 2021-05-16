package com.winwin.todolist.service;

import com.winwin.todolist.model.TodoItem;

import java.util.List;

public interface ITodoItemService {
    List<TodoItem> get(int count);
    List<TodoItem> get(String id);
}
