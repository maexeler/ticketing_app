package ch.zli.m223.service.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Todo not found")
public class TodoNotFoundException extends RuntimeException {
    
}
