package com.example.ksmith.sortlistapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText enterString;

    private RecyclerView recyclerView;
    private ToDoAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Button enterItemButton;
    private Button sortItemButton;
    private Button sortIdButton;
    private Button logButton;

    private static int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterString = (EditText) findViewById(R.id.enter_string_edit_text);

        adapter = new ToDoAdapter();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true); // if you know the content won't change the size of the RV

        //use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

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
                adapter.sortByItem();
            }
        });

        sortIdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.sortById();
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
            ToDoItem item = new ToDoItem(id, itemString);

            adapter.addItem(item);
            id++;
        }
        enterString.setText("");
    }

    public void logListClicked() {
        Log.i("List", adapter.getData().toString());
    }





}
