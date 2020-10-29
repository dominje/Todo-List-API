package com.oocl.todolistapi.model;

public class TodoResponse {
    private Integer Id;
    private String text;
    private boolean status;

    public TodoResponse() {
    }

    public TodoResponse(Integer id, String text, boolean status) {
        Id = id;
        this.text = text;
        this.status = status;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
