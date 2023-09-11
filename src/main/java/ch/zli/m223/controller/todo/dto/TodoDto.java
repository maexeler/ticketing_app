package ch.zli.m223.controller.todo.dto;
import lombok.AllArgsConstructor;

import ch.zli.m223.model.Todo;

@AllArgsConstructor
public class TodoDto {
    public Long userId;
    public Long id;
    public String title;
    public Boolean completed;

    public TodoDto(Todo todo) {
        userId = todo.getUserId();
        id = todo.getId();
        title = todo.getTitle();
        completed = todo.getCompleted();
    }
}
