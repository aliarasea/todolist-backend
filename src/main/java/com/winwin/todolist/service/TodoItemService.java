package com.winwin.todolist.service;

import com.winwin.todolist.constant.SortType;
import com.winwin.todolist.dataaccess.TodoItemDao;
import com.winwin.todolist.model.TodoItem;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TodoItemService implements ITodoItemService {

    private final TodoItemDao dao;

    public TodoItemService(TodoItemDao dao) {
        this.dao = dao;
    }

    @Override
    public List<TodoItem> getFirst(int count) {
        return dao.get(count, SortType.ASC);
    }

    @Override
    public List<TodoItem> getLast(int count) {
        return dao.get(count, SortType.DESC);
    }

    @Override
    public List<TodoItem> get(String id) {
        return dao.get(id);
    }

    @Override
    public TodoItem add(TodoItem todoItem) {
        if (null == todoItem.getCreateTime()) {
            todoItem.setCreateTime(Instant.now());
        }
        return dao.add(todoItem);
    }

    @Override
    public boolean delete(String id) {
        return dao.delete(id);
    }

    @Override
    public boolean complete(String id) {
        return dao.complete(id);
    }
}
