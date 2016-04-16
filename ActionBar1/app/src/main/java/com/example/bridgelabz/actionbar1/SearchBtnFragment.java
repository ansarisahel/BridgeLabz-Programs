package com.example.bridgelabz.actionbar1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by bridgelabz on 23/12/15.
 */
public class SearchBtnFragment extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LinearLayout linearLayout1 = new LinearLayout(getActivity());
        linearLayout1.setId(100);

        TextView tv = new TextView(getActivity());
        tv.setId(101);
        tv.setText("Searching the text");
        tv.setHint("Search");
        linearLayout1.addView(tv);
        return linearLayout1;

    }

}
