package com.oocl.todolistapi.service;

import com.oocl.todolistapi.model.Todo;
import com.oocl.todolistapi.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class TodoServiceTest {

    @Test
    void should_get_all_todo_list_when_get_all(){
        //given
        TodoRepository todoRepository = Mockito.mock(TodoRepository.class);
        List<Todo> expected = asList(new Todo(), new Todo());
        TodoService todoService = new TodoService(todoRepository);

        //when
        when(todoRepository.findAll()).thenReturn(expected);
        List<Todo> actual = todoService.getAll();

        //then
        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void should_add_todo_when_add_given_to_do_item(){
        //given
        TodoRepository todoRepository = Mockito.mock(TodoRepository.class);
        Todo expected = new Todo();
        TodoService todoService = new TodoService(todoRepository);

        //when
        when(todoRepository.save(expected)).thenReturn(expected);
        Todo actual = todoService.addTodoList(expected);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void should_update_task_to_true_when_updating_status_given_todo_is_newly_added(){

        //given
        TodoRepository todoRepository = Mockito.mock(TodoRepository.class);
        Todo expected = new Todo();
        TodoService todoService = new TodoService(todoRepository);

        //when
        when(todoRepository.save(expected)).thenReturn(expected);
        Todo actual = todoService.updateTodoStatus(expected);

        //then
        assertEquals(expected, actual);
    }
}