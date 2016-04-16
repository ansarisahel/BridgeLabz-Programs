package com.example.bridgelabz.recyclerviewdatabinding;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bridgelabz.recyclerviewdatabinding.BR;
import com.example.bridgelabz.recyclerviewdatabinding.databinding.RowViewBinding;

import java.util.List;

/**
 * Created by bridgelabz on 12/3/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Book> myBook;

    public MyAdapter(List<Book> myBook) {
        this.myBook = myBook;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view,parent,false);
        MyViewHolder holder = new MyViewHolder(rowView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Book book = myBook.get(position);
        holder.binding.setVariable(BR.book,book);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return myBook.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder
    {
        RowViewBinding binding;
        public MyViewHolder(View itemView) {
            super(itemView);
            binding = RowViewBinding.bind(itemView);
        }
    }
}
