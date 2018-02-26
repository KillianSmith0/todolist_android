package com.example.ksmith.sortlistapp;

import java.util.Comparator;
/**
 * Created by ksmith on 22/02/2018.
 */

public class ListItem{
    private int id;
    private String item;

    ListItem(int id, String item){
        this.id = id;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListItem listItem = (ListItem) o;

        if (id != listItem.id) return false;
        return item != null ? item.equals(listItem.item) : listItem.item == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ID-"+getId()+": '"+getItem()+"'";
    }

    public static Comparator<ListItem> itemComparator = new Comparator<ListItem>() {
        @Override
        public int compare(ListItem listItem, ListItem t1) {
            return listItem.getItem().compareTo(t1.getItem());
        }
    };

    public static Comparator<ListItem> idComparator = new Comparator<ListItem>() {
        @Override
        public int compare(ListItem listItem, ListItem t1) {
            return  listItem.getId() - t1.getId();
        }
    };

}
