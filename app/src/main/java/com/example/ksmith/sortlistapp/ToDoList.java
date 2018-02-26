package com.example.ksmith.sortlistapp;

import java.util.List;

/**
 * Created by ksmith on 26/02/2018.
 */

public class ToDoList {
    private final List<ToDoItem> items;

    public ToDoList(List<ToDoItem> items) {
        this.items = items;
    }

    public List<ToDoItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "ToDoList{items="+getItems()+"}";
    }
}
