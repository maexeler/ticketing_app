package ch.zli.m223.controller.todo;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.controller.todo.dto.TodoDto;
import ch.zli.m223.service.todo.TodoService;
import lombok.RequiredArgsConstructor;

/**
 * Access point for members to their own data
 */
@RestController
@RequestMapping("/api/v1/member/todos")
@RequiredArgsConstructor
public class TodoController {
    
    private final TodoService todoService;

    @GetMapping("")
    List<TodoDto> getTodos(Principal principal) {
        return todoService.getAllTodos(principal.getName())
            .stream()
            .map((todo)-> new TodoDto(todo))
            .collect(Collectors.toList());
    }

    @PostMapping("")
    TodoDto addTodo(Principal principal, @RequestBody TodoDto todo) {
        return new TodoDto(todoService.addTodo(principal.getName(), todo.title, todo.completed));
    }

    @PatchMapping("/{id}")
    TodoDto updateTodo(
        Principal principal,
        @PathVariable("id") Long id,
        @RequestBody TodoDto todo
    ) {
        return new TodoDto(todoService.updateTodo(
            principal.getName(),
            id, todo.title, todo.completed
        ));
    }

    /**
     * Delete myself from the server
     * 
     * @param principal injected
     * @return HttpStatus.OK
     */
    @DeleteMapping("/{id}")
    void deleteTodo(Principal principal, @PathVariable("id") Long id) {
        todoService.deleteTodo(principal.getName(), id);
    }
}
