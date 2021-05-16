package com.winwin.todolist.service;

import com.winwin.todolist.dataaccess.TodoItemDao;
import com.winwin.todolist.model.TodoItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoItemService implements ITodoItemService {

    private final TodoItemDao dao;

    public TodoItemService(TodoItemDao dao) {
        this.dao = dao;
    }

    @Override
    public List<TodoItem> get(int count) {
        return dao.get(count);
    }

    @Override
    public List<TodoItem> get(String id) {
        return dao.get(id);
    }
}
