package com.example.bridgelabz.navigationdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.http.impl.io.ContentLengthInputStream;

/**
 * Created by bridgelabz on 5/1/16.
 */
public class MyAdapter extends BaseAdapter {

    Context context;
    String[] socialSites;
    int[] images = {R.drawable.facebook,R.drawable.google_plus,R.drawable.twitter,R.drawable.gmail,R.drawable.youtube};

    public MyAdapter(Context context)
    {
        this.context = context;
        socialSites = context.getResources().getStringArray(R.array.socials);
    }

    @Override
    public int getCount() {
        return socialSites.length;
    }

    @Override
    public Object getItem(int position) {
        return socialSites[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = null;
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.listview_layout,parent,false);
        }
        else {
            row = convertView;
        }
        TextView titleTextView = (TextView) row.findViewById(R.id.textView1);
        ImageView titleImageView = (ImageView) row.findViewById(R.id.imageView1);
        titleTextView.setText(socialSites[position]);
        titleImageView.setImageResource(images[position]);
        return row;
    }
}
