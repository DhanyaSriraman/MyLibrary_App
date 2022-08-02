package com.example.mylibrary;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class FavActivity extends AppCompatActivity {
    RecyclerView fav ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        fav = findViewById(R.id.recyclerView3);
        BookAdapter adapter = new BookAdapter(this);
        fav.setAdapter(adapter);
        fav.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(Utils.getInstance().getFavourite());

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}