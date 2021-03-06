package com.oocl.todolistapi.controller;

import com.oocl.todolistapi.mapper.TodoMapper;
import com.oocl.todolistapi.model.Todo;
import com.oocl.todolistapi.model.TodoRequest;
import com.oocl.todolistapi.model.TodoResponse;
import com.oocl.todolistapi.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;
    private final TodoMapper todoMapper;

    public TodoController(TodoService todoService, TodoMapper todoMapper) {
        this.todoService = todoService;
        this.todoMapper = todoMapper;
    }


    @PostMapping()
    public TodoResponse createTodoItem(@RequestBody TodoRequest request){
        Todo todo = todoMapper.toEntity(request);
        todoService.addTodoList(todo);
        return todoMapper.toResponse(todo);
    }

    @GetMapping
    public List<TodoResponse> getAllTodos(){
        List<Todo> todoList = todoService.getAll();
        return todoList.stream().map(todoMapper::toResponse).collect(Collectors.toList());
    }

    @PutMapping("/{taskId}")
    public TodoResponse updateTodo(@PathVariable Integer taskId, @RequestBody TodoRequest request){
        Todo todo = todoMapper.toEntity(request);
        Todo updatedToDo = todoService.updateTodoStatus(taskId, todo);
        return todoMapper.toResponse(updatedToDo);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTodo(@PathVariable Integer taskId){
        todoService.deleteTask(taskId);
    }
}
