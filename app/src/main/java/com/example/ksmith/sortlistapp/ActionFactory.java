package com.example.ksmith.sortlistapp;

import zendesk.suas.Action;

/**
 * Created by ksmith on 26/02/2018.
 *
 * Where the actions, that effect the state of the application, are stored
 *
 */

public class ActionFactory {
    static final String ADD_ITEM = "ADD_ITEM";
    static final String SORT_ITEM_ID = "SORT_ITEM_ID";
    static final String SORT_ITEM_ALPHA = "SORT_ITEM_ALPHA";
    static final String DELETE_ITEM = "DELETE_ITEM";
    static final String TOGGLE_ITEM = "TOGGLE_ITEM";

    static Action addAction(String itemTitle){
        return new Action<>(ADD_ITEM, itemTitle);
    }

//    static Action sortByIdAction(){}
//    static Action sortItemAction(){}

    static Action deleteAction(int itemIndex){
        return new Action(DELETE_ITEM, itemIndex);
    }

    static Action toggleItem(int itemIndex){
        return new Action(TOGGLE_ITEM, itemIndex);
    }
}
