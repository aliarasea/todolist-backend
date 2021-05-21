package com.winwin.todolist.dataaccess;

import com.mongodb.MongoException;
import com.winwin.todolist.constant.SortType;
import com.winwin.todolist.model.TodoItem;
import com.winwin.todolist.repo.TodoItemRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Log4j2
@Repository
public class TodoItemDao implements ITodoItemDao {
    private final TodoItemRepository repository;

    public TodoItemDao(TodoItemRepository repository) {
        this.repository = repository;
    }

    public List<TodoItem> get(int count, SortType sortType) {
        PageRequest pageRequest;
        if (sortType == SortType.ASC) {
            pageRequest = PageRequest.of(0, count, Sort.Direction.ASC, "createTime");
        } else {
            pageRequest = PageRequest.of(0, count, Sort.Direction.DESC, "createTime");
        }
        return repository.findAll(pageRequest).toList();
    }

    public List<TodoItem> get(String id) {
        Iterable<String> ids = Arrays.asList(id.split(","));
        return (List<TodoItem>) repository.findAllById(ids);
    }

    public TodoItem add(TodoItem todoItem) {
        return repository.save(todoItem);
    }

    public TodoItem delete(String id) {
        TodoItem result = null;
        try {
            TodoItem item = get(id).get(0);
            if (null == item.getDeleteTime()) {
                item.setDeleteTime(Instant.now());
                result = repository.save(item);
            }
        } catch (MongoException exception) {
            log.error(exception.getMessage());
        }
        return result;
    }

    public TodoItem complete(String id) {
        TodoItem result = null;
        try {
            TodoItem item = get(id).get(0);
            if (null == item.getDeleteTime() && null == item.getCompleteTime()) {
                item.setCompleteTime(Instant.now());
                result = repository.save(item);
            }

        } catch (MongoException exception) {
            log.error(exception.getMessage());
        }
        return result;
    }
}
