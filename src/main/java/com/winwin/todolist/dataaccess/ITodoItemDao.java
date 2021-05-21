package com.winwin.todolist.dataaccess;

import com.winwin.todolist.constant.SortType;
import com.winwin.todolist.model.TodoItem;

import java.util.List;

public interface ITodoItemDao {
    List<TodoItem> get(int count, SortType sortType);

    List<TodoItem> get(String id);

    TodoItem add(TodoItem todoItem);

    TodoItem delete(String id);

    TodoItem complete(String id);
}
