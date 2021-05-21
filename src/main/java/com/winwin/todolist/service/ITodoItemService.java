package com.winwin.todolist.service;

import com.winwin.todolist.model.TodoItem;

import java.util.List;

public interface ITodoItemService {
    List<TodoItem> getFirst(int count);

    List<TodoItem> getLast(int count);

    List<TodoItem> get(String id);

    TodoItem add(TodoItem todoItem);

    boolean delete(String id);

    boolean complete(String id);
}
