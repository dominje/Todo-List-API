package com.oocl.todolistapi.model;

public class TodoRequest {
    private String text;
    private boolean status;

    public TodoRequest() {
    }

    public TodoRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
