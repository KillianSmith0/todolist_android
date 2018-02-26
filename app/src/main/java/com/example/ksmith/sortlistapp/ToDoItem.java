package com.example.ksmith.sortlistapp;

import java.util.Comparator;
/**
 * Created by ksmith on 22/02/2018.
 */

public class ToDoItem {
    private int id;
    private String item;

    private Boolean isComplete;

    ToDoItem(int id, String item){
        this.id = id;
        this.item = item;
        isComplete = false;
    }

    public int getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public Boolean isComplete() {
        return isComplete;
    }

    public void isComplete(Boolean complete) {
        isComplete = complete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToDoItem toDoItem = (ToDoItem) o;

        if (id != toDoItem.id) return false;
        return item != null ? item.equals(toDoItem.item) : toDoItem.item == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        return result;
    }

    public static Comparator<ToDoItem> itemComparator = new Comparator<ToDoItem>() {
        @Override
        public int compare(ToDoItem toDoItem, ToDoItem t1) {
            return toDoItem.getItem().compareTo(t1.getItem());
        }
    };

    public static Comparator<ToDoItem> idComparator = new Comparator<ToDoItem>() {
        @Override
        public int compare(ToDoItem toDoItem, ToDoItem t1) {
            return  toDoItem.getId() - t1.getId();
        }
    };

    @Override
    public String toString() {
        return "ToDoItem{id="+getId()+", title='"+getItem()+"', isComplete="+isComplete()+"}";
    }

}
