package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class AlreadyActivity extends AppCompatActivity {
    RecyclerView already ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already);
        already=findViewById(R.id.recyclerView);
        BookAdapter adapter=new BookAdapter(this);
        already.setAdapter(adapter);
        already.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(Utils.getInstance().getReadBooks());

    }
}