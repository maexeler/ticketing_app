package ch.zli.m223.service.todo.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ch.zli.m223.model.AppUser;
import ch.zli.m223.model.Todo;
import ch.zli.m223.repository.TodoRepository;
import ch.zli.m223.service.todo.TodoService;
import ch.zli.m223.service.user.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final UserService userService;
    private final TodoRepository todoRepository;

    @Override
    public Todo addTodo(String name, String title, boolean completed) {
        AppUser user = userService.getUserByName(name);
        return todoRepository.addTodo(user, title, completed);
    }

    @Override
    public List<Todo> getAllTodos(String userName) {
        AppUser user = userService.getUserByName(userName);
        return todoRepository.findAllByUserid(user.getId());
    }

    @Override
    public Todo updateTodo(String userName, Long userId, Long id, String title, Boolean completed) {
        AppUser user = userService.getUserByName(userName);
        //if (user.getId() != userId) { throw new RuntimeException();}
        Todo todo = todoRepository.findById(id).orElseThrow(()->new RuntimeException());
        return todoRepository.updateTodo(todo, title, completed);

    }

    @Override
    public void deleteTodo(String userName, Long id) {
        AppUser user = userService.getUserByName(userName);
        //if (user.getId() != id) {throw new RuntimeException();}
        todoRepository.deleteById(id);
    }
    
}
