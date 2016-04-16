package com.example.bridgelabz.headfirst1;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class TimeTrackerAdapter extends CursorAdapter {


    public ArrayList<TimeRecord> times = new ArrayList<TimeRecord>();

    public TimeTrackerAdapter(Context context,Cursor cursor)
    {
        super(context,cursor);
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.time_list_item,parent,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView timeTextView = (TextView) view.findViewById(R.id.time_view);
        timeTextView.setText(cursor.getString(1));
        TextView noteTextView = (TextView) view.findViewById(R.id.note_view);
        noteTextView.setText(cursor.getString(2));
    }
}
