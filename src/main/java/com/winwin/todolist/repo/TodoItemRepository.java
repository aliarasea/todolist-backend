package com.winwin.todolist.repo;

import com.winwin.todolist.model.TodoItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoItemRepository extends MongoRepository<TodoItem, String> {
}
