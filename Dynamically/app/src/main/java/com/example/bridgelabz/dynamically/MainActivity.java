package com.example.bridgelabz.dynamically;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout lm = (LinearLayout) findViewById(R.id.linearLayout1);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);

        for(int i = 0;i < 4; i++)
        {
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            TextView t1 = new TextView(this);
            t1.setText("Product "+i);
            ll.addView(t1);

            TextView t2 = new TextView(this);
            t2.setText(String.valueOf(100*(i+1)));
            ll.addView(t2);

            Button b1 = new Button(this);
            b1.setText("Button "+(i+1));
            b1.setLayoutParams(params);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),((Button)v).getText(),Toast.LENGTH_SHORT);
                }
            });
            ll.addView(b1);
            lm.addView(ll);

        }
    }
}
