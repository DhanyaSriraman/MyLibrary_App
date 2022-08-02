package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
     private RecyclerView bookRecycler;
     private BookAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        bookRecycler=findViewById(R.id.bookRec);
        adapter=new BookAdapter(this);
        bookRecycler.setAdapter(adapter);
        bookRecycler.setLayoutManager(new LinearLayoutManager(this));
       /* ArrayList<AllBooks>book=new ArrayList<>();
        book.add(new AllBooks(1,"Murder","Agatha Christie",150,R.drawable.murder,"A brilliant work","Long Description"));

        book.add(new AllBooks(2,"2 States","Chetan bhagath",150,R.drawable.states,"A brilliant work","Long Description"));*/
        adapter.setBooks(Utils.getInstance().getAllBooks());
    }
}