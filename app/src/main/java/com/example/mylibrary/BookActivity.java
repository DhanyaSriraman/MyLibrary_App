package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    private ImageView image;
    private Button alreadyRead,currentRead,favRead;
    private TextView auth1,bname1,pages1,longDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        initViews();
      //  AllBooks book=new AllBooks(1,"Murder","Agatha Christie",150,R.drawable.murder,"A brilliant work","Long Description");
      //  setData(book);
        Intent intent=getIntent();
        if(null!=intent)
        {
            int bookId=intent.getIntExtra("bookId",-1);
            if(bookId!=-1)
            {
               AllBooks book=Utils.getInstance().getBookById(bookId);
               if(null != book)
                   setData(book);
                   handleReadBooks(book);
                   handleCurrentBooks(book);
                   handleFavBooks(book);
            }
        }
    }
    private void handleCurrentBooks(AllBooks book)
    {
        ArrayList<AllBooks>current=Utils.getInstance().getCurrentBooks();
        boolean exits=false;
        for(AllBooks b:current)
        {
            if(b.getId()==book.getId())
                exits=true;
        }
        if(exits)
            currentRead.setEnabled(false);
        else{
            currentRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance().addToCurrentReadBooks(book)) {
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, ReadActivity.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(BookActivity.this, "Something wrong happened", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
    private void handleFavBooks(AllBooks book)
    {
        ArrayList<AllBooks>current=Utils.getInstance().getFavourite();
        boolean exits=false;
        for(AllBooks b:current)
        {
            if(b.getId()==book.getId())
                exits=true;
        }
        if(exits)
            favRead.setEnabled(false);
        else{
           favRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance().addToCurrentFavBooks(book)) {
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, FavActivity.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(BookActivity.this, "Something wrong happened", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
    private void handleReadBooks(AllBooks book)
    {
        ArrayList<AllBooks>read=Utils.getInstance().getReadBooks();
        boolean exits=false;
        for(AllBooks b:read)
        {
            if(b.getId()==book.getId())
                exits=true;
        }
        if(exits)
            alreadyRead.setEnabled(false);
        else{
            alreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  if(Utils.getInstance().addToAlreadyReadBooks(book)) {
                      Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();
                      Intent intent = new Intent(BookActivity.this, AlreadyActivity.class);
                      startActivity(intent);
                  }
                  else
                      Toast.makeText(BookActivity.this, "Something wrong happened", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
    private void setData(AllBooks book){
        auth1.setText(book.getAuthor());
        bname1.setText(book.getName());
        pages1.setText(String.valueOf(book.getPages()));
        longDesc.setText(book.getLongDesc());
        Glide.with(this).asBitmap().load(book.getImageUrl()).into(image);
    }
    private void initViews()
    {
        auth1=findViewById(R.id.auth);
        bname1=findViewById(R.id.Name1);
        pages1=findViewById(R.id.pages);
        image=findViewById(R.id.imgBook1);
        longDesc=findViewById(R.id.longD);
        alreadyRead=findViewById(R.id.alreadyRead);
        currentRead=findViewById(R.id.currentlyRead);
        favRead=findViewById(R.id.favRead);

    }
}