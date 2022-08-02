package com.example.mylibrary;

import android.content.Context;
import android.content.Intent;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    ArrayList<AllBooks>books=new ArrayList<>();
    Context context;

    public BookAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int a=position;
        holder.bookName.setText(books.get(position).getName());
        Glide.with(context).asBitmap().load(books.get(a).getImageUrl()).into(holder.bookImage);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,BookActivity.class);
                intent.putExtra("bookId",books.get(a).getId());
                context.startActivity(intent);
            }
        });
        holder.author.setText(books.get(position).getAuthor());
        holder.shortDesc.setText(books.get(position).getShortDesc());
         if(books.get(a).isExpanded())
         {
             TransitionManager.beginDelayedTransition(holder.parent);
             holder.rel2.setVisibility(View.VISIBLE);
             holder.downArrow.setVisibility(View.GONE);
         }
         else {
             TransitionManager.beginDelayedTransition(holder.parent);
             holder.rel2.setVisibility(View.GONE);
             holder.downArrow.setVisibility(View.VISIBLE);
         }

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<AllBooks> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private ImageView bookImage;
        private TextView bookName;
        private ImageView upArrow,downArrow;
        private RelativeLayout rel2;
        private TextView author,name,shortDesc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent=itemView.findViewById(R.id.parent1);
            bookImage=itemView.findViewById(R.id.imgBook);
            bookName=itemView.findViewById(R.id.bookName);
            upArrow=itemView.findViewById(R.id.arrowUp);
            downArrow=itemView.findViewById(R.id.arrowDown);
            rel2=itemView.findViewById(R.id.rel2);
            author=itemView.findViewById(R.id.author);

            name=itemView.findViewById(R.id.name);
            shortDesc=itemView.findViewById(R.id.shortDesc);
            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AllBooks book=books.get(getAbsoluteAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAbsoluteAdapterPosition());
                }
            });
            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AllBooks book=books.get(getAbsoluteAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAbsoluteAdapterPosition());
                }
            });
        }
    }
}
