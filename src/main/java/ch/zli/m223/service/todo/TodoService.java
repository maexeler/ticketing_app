package ch.zli.m223.service.todo;

import java.util.List;

import ch.zli.m223.model.Todo;

public interface TodoService {

    Todo addTodo(String name, String title, boolean completed);
    List<Todo> getAllTodos(String userName);
    Todo updateTodo(String name, Long id, String title, Boolean completed);
    void deleteTodo(String userName, Long id);

}
