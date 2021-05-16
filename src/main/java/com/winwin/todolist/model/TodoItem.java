package com.winwin.todolist.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Setter
@Getter
public class TodoItem {
    @Id
    private String id;
    private String label;
    private String value;
    private Instant createTime;
    private Instant completeTime;
    private Instant deleteTime;
}
