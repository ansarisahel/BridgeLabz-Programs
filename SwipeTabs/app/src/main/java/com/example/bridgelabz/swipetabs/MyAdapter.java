package com.example.bridgelabz.swipetabs;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MyAdapter extends BaseAdapter {

    String[] result;
    int[] imageId;
    Context context;
    private static LayoutInflater inflater=null;

    public MyAdapter(Activity activity1, String[] s, int[] i)
    {
        context = activity1;
        result = s;
        imageId = i;

        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
    Holder holder=new Holder();
    View rowView;
    rowView = inflater.inflate(R.layout.listview_layout, null);
    holder.tv=(TextView) rowView.findViewById(R.id.textView1);
    holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
    holder.tv.setText(result[position]);
    holder.img.setImageResource(imageId[position]);
    return rowView;
}
}
