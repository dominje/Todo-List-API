package com.oocl.todolistapi.service;

import com.oocl.todolistapi.model.Todo;
import com.oocl.todolistapi.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    public Todo addTodoList(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodoStatus(Integer taskId, Todo todo) {
        Optional<Todo> originalTodo = todoRepository.findById(taskId);
        if (originalTodo.isPresent()) {
            originalTodo.get().setStatus(todo.getStatus());
            return todoRepository.save(originalTodo.get());
        }
        return null;
    }

    public void deleteTask(Integer taskId) {
        todoRepository.deleteById(taskId);
    }
}
