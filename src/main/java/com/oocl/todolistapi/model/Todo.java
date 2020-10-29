package com.oocl.todolistapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String text;
    private boolean status;

    public Todo() {
    }

    public Todo(Integer id, String text, boolean status) {
        Id = id;
        this.text = text;
        this.status = status;
    }

    public Integer getId() {
        return Id;
    }

    public String getText() {
        return text;
    }

    public boolean getStatus() {
        return status;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
