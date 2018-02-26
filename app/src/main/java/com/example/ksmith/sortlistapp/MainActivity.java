package com.example.ksmith.sortlistapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private EditText enterString;

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button enterItemButton;
    private Button sortItemButton;
    private Button sortIdButton;
    private Button logButton;

    static int id = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterString = (EditText) findViewById(R.id.enter_string_edit_text);
        mAdapter = new MyAdapter();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true); // if you know the content won't change the size of the RV

        //use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        enterItemButton = findViewById(R.id.add_item_button);

        sortItemButton = findViewById(R.id.sort_item_button);
        sortIdButton = findViewById(R.id.sort_id_button);
        logButton = findViewById(R.id.log_button);

        enterItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterItemClicked();
            }
        });

        sortItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdapter.sortByItem();
            }
        });

        sortIdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdapter.sortById();
            }
        });

        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logListClicked();
            }
        });
    }


    public void enterItemClicked() {
        if (!enterString.getText().toString().isEmpty()) {
            String itemString = enterString.getText().toString();
            ListItem item = new ListItem(id, itemString);

            mAdapter.addItem(item);
            id++;

        }
        enterString.setText("");
    }

    public void logListClicked() {
        Log.i("List", mAdapter.getData().toString());
    }





}
