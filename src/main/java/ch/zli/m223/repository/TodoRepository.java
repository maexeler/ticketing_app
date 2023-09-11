package ch.zli.m223.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.zli.m223.model.AppUser;
import ch.zli.m223.model.Todo;
import ch.zli.m223.model.impl.TodoImpl;

public interface TodoRepository extends JpaRepository<TodoImpl, Long>{

    public default Todo addTodo(AppUser user, String title, boolean completed) {
        return save(new TodoImpl(user, title, completed));
    }

    public List<Todo> findAllByUserid(Long userid);

    public default Todo updateTodo(Todo todo, String title, Boolean completed) {
        if (title != null) ((TodoImpl)todo).setTitle(title);
        if (completed != null) ((TodoImpl)todo).setCompleted(completed);
        return save((TodoImpl)todo);
    }
    
}
