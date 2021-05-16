package com.winwin.todolist.dataaccess;

import com.winwin.todolist.model.TodoItem;

import java.util.List;

public interface ITodoItemDao {
    List<TodoItem> get(int count);
    List<TodoItem> get(String id);
}
