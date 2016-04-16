package com.example.bridgelabz.fragmentsdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Fragment1 extends Fragment {

    Bundle saveInstanceState;
    @Override
    public void onSaveInstanceState(Bundle outState)
    {

        saveInstanceState = outState;
        super.onSaveInstanceState(saveInstanceState);
        TextView tv = (TextView) getView().findViewById(101);
        outState.putCharSequence("myText", tv.getText());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstances) {

        LinearLayout linearLayout = new LinearLayout(getActivity());
        Button b1 = new Button(getActivity());
        b1.setText("Button 1");
        linearLayout.addView(b1);


        final TextView tv = new TextView(getActivity());
        tv.setText("hiiii");
        tv.setId(101);
        linearLayout.addView(tv);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                tv.setText(b.getText());
            }
        };
        b1.setOnClickListener(onClickListener);
        if (saveInstanceState != null) {
            tv.setText(saveInstanceState.getCharSequence("myText"));
        };
        return linearLayout;
    }

}
