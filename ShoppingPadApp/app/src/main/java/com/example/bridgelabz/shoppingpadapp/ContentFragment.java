package com.example.bridgelabz.shoppingpadapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bridgelabz on 21/1/16.
 */
public class ContentFragment extends Fragment
{
    RecyclerView recyclerView;
    Content_Fragment_Adapter adapter;
    public static ContentFragment getInstance(int position)
    {
        ContentFragment myFragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putInt("position",position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.content_fragment,container,false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.content_fragment_recyclerView);
        adapter = new Content_Fragment_Adapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;
    }
}
