package com.oocl.todolistapi.mapper;

import com.oocl.todolistapi.model.Todo;
import com.oocl.todolistapi.model.TodoRequest;
import com.oocl.todolistapi.model.TodoResponse;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {

    public TodoResponse toResponse(Todo todo){
        TodoResponse response = new TodoResponse();

        response.setId(todo.getId());
        response.setText(todo.getText());
        response.setStatus(todo.getStatus());

        return response;
    }

    public Todo toEntity(TodoRequest todoRequest){
        Todo todo = new Todo();

        todo.setText(todoRequest.getText());
        todo.setStatus(todoRequest.getStatus());

        return todo;
    }

}
