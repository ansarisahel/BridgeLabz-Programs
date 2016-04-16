package com.example.bridgelabz.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by bridgelabz on 12/1/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.RecyclerViewHolder> {

    String[] countryName;
    String[] countryCapital;
    int[] images;
    RecyclerView.ViewHolder holder;
    View view;

    public MyAdapter(String[] countryName,String[] countryCapital,int[] images)
    {
        this.countryName = countryName;
        this.countryCapital = countryCapital;
        this.images = images;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view_layout,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.countryNametxt.setText(countryName[position]);
        holder.capitalNametxt.setText(countryCapital[position]);
        holder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return countryName.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        TextView countryNametxt,capitalNametxt;
        ImageView imageView;
        public RecyclerViewHolder(View view)
        {
            super(view);
            countryNametxt = (TextView)view.findViewById(R.id.txtConuntryName);
            capitalNametxt = (TextView)view.findViewById(R.id.txtConuntryCapital);
            imageView = (ImageView) view.findViewById(R.id.imageView1);
        }
    }
}
