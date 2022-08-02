package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
     private Button all,current,already,favourites;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intitViews();
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AllBooksActivity.class);
                startActivity(intent);
            }
        });
        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AlreadyActivity.class);
                startActivity(intent);
            }
        });
        current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ReadActivity.class);
                startActivity(intent);
            }
        });
        favourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FavActivity.class);
                startActivity(intent);
            }
        });
        Utils.getInstance();
    }
    private void intitViews(){
        all=findViewById(R.id.allBooks);
        current=findViewById(R.id.currentBooks);
        already=findViewById(R.id.readBooks);
        favourites=findViewById(R.id.fav);
    }
}