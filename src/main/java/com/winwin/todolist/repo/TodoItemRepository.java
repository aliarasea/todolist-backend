package com.winwin.todolist.repo;

import com.winwin.todolist.model.TodoItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TodoItemRepository extends MongoRepository<TodoItem, String>, PagingAndSortingRepository<TodoItem, String> {

    @Query("{'createTime' : {$ne : null}}")
    List<TodoItem> findAllByCreateTime();
}
