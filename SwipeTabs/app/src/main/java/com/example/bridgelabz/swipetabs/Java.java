package com.example.bridgelabz.swipetabs;


import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Java extends ListFragment {

    String[] strings = new String[]{"Ronaldo","bakham","C.R","Rooney","Henry"};
    int[] images = {R.drawable.java1,R.drawable.java2,R.drawable.java3,R.drawable.java4,R.drawable.java5};


    public Java() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //ListAdapter adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,strings);
        setListAdapter(new MyAdapter(getActivity(),strings,images));
        return inflater.inflate(R.layout.fragment_java, container, false);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getActivity(),getListView().getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
    }

}
