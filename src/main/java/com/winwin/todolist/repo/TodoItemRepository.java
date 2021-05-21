package com.winwin.todolist.repo;

import com.winwin.todolist.model.TodoItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TodoItemRepository extends MongoRepository<TodoItem, String>, PagingAndSortingRepository<TodoItem, String> {

}
