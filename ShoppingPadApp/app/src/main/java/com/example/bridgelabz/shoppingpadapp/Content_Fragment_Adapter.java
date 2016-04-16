package com.example.bridgelabz.shoppingpadapp;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cocosw.bottomsheet.BottomSheet;

/**
 * Created by bridgelabz on 22/1/16.
 */
public class Content_Fragment_Adapter extends RecyclerView.Adapter<Content_Fragment_Adapter.RecyclerViewHolder> {

    int[] images = {R.drawable.shahruk_khan,R.drawable.salman_khan};
    String[] content = {"Content 1","Content 2"};
    String[] title = {"Title1","Title2"};
    View view;
    Context context;

    public Content_Fragment_Adapter(Context context)
    {
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_fragment_row_view,parent,false);
        RecyclerViewHolder holder = new RecyclerViewHolder(view,context);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
        holder.textView.setText(content[position]);
        holder.textView.setText(title[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        ImageView imageView,imageView1;
        TextView textView,textView1;
        Context context1;
        public RecyclerViewHolder(View itemView,Context mycontext) {
            super(itemView);
            itemView.setOnLongClickListener(this);
            context1 = mycontext;
            imageView = (ImageView) itemView.findViewById(R.id.content_fragment_imageView);
            imageView1 = (ImageView) itemView.findViewById(R.id.content_fragment_imageView1);
            textView = (TextView) itemView.findViewById(R.id.content_fragment_textView1);
            textView1 = (TextView) itemView.findViewById(R.id.content_fragment_textView2);
        }

        @Override
        public boolean onLongClick(View view) {
            new BottomSheet.Builder((Activity) context).title("title").sheet(R.menu.content_fragment_bottom_sheet).listener(new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (which == R.id.content_info) {
                            Toast.makeText(context,"you clicked content_info",Toast.LENGTH_SHORT).show();
                    }
                }
            }).show();
            return true;
        }

    }
}
