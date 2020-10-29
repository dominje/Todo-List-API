package com.oocl.todolistapi.service.integration;

import com.oocl.todolistapi.model.Todo;
import com.oocl.todolistapi.repository.TodoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TodoIntegrationTest {

    private static final String TODOS_URI = "/todos";

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private MockMvc mockMvc;

    @AfterEach
    void tearDown() {
        todoRepository.deleteAll();
    }

    @Test
    void should_get_all_todos_when_get_all() throws Exception {
        //given
        Todo todo = new Todo("Piattos");
        todoRepository.save(todo);

        //when
        //then
        mockMvc.perform(get(TODOS_URI))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].text").isString());
    }

    @Test
    public void should_add_task_when_creating_given_task() throws Exception {

        //given
        String todoAsJson = "{\n" +
                "    \"text\" : \"SVG\"\n" +
                "}";

        //when
        //then
        mockMvc.perform(post(TODOS_URI)
                .contentType(MediaType.APPLICATION_JSON)
                .content(todoAsJson))
                .andExpect(jsonPath("$.text").value("SVG"));
    }

    @Test
    void should_update_task_to_true_when_updating_given_task_is_false() throws Exception {
        //given
        String todoAsJson = "{\n" +
                "    \"status\" : true\n" +
                "}";

        Todo todo = todoRepository.save(new Todo("Tata"));

        //when
        //then
        mockMvc.perform(put(TODOS_URI + "/" + todo.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(todoAsJson)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.status").value(true));
    }

    @Test
    void should_delete_task_when_deleting_given_task_id() throws Exception {
        //given
        Todo todo = todoRepository.save(new Todo("SVG"));


        //when
        mockMvc.perform(delete(TODOS_URI + "/" + todo.getId()));

        //then
        List<Todo> todoList = todoRepository.findAll();
        Assertions.assertFalse(todoList.contains("SVG"));
    }

}
