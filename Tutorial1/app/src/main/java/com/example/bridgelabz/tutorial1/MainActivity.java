package com.example.bridgelabz.tutorial1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

    static String EXTRA_MESSAGE = "This is my new message";
    Button b1;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                editText = (EditText) findViewById(R.id.editText1);
                String message = editText.getText().toString();
                Intent intent = new Intent(v.getContext(),AnotherClass.class);
                intent.putExtra("Extra_Message",message);
                startActivity(intent);

            }
        });
    }




   /* public void sendMessage(View view)
    {
        EditText editText = (EditText) findViewById(R.id.editText1);
        String message = editText.getText().toString();
        Intent intent = new Intent(getApplicationContext(),AnotherClass.class);
        intent.putExtra("Extra_Message",message);
        startActivity(intent);
    }*/

}
