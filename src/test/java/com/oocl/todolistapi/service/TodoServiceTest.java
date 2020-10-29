package com.oocl.todolistapi.service;

import com.oocl.todolistapi.repository.TodoRepository;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class TodoServiceTest {

    @Test
    void should_get_all_todo_list_when_get_all(){
        //given
        TodoRepository todoRepository = Mockito.mock(TodoRepository.class);
        List<Todo> expected = aslist(new Todo(), new Todo());
        TodoService todoService = new TodoService(todoRepository);

        //when
        when(todoRepository.getAll()).thenReturn(expected);
        List<Todo> actual = todoService.getAll();

        //then
        assert(expected.size, actual.size);
    }
}