package com.example.bridgelabz.headfirst1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by bridgelabz on 7/1/16.
 */
public class AddTimeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_time_layout);

    }

    public void onSaveBtnClicked(View view) {
        Intent intent = getIntent();
        EditText time = (EditText)findViewById(R.id.timeEditText);
        intent.putExtra("time",time.getText().toString());

        EditText note = (EditText) findViewById(R.id.noteEditText);
        intent.putExtra("note",note.getText().toString());

        this.setResult(RESULT_OK,intent);
        finish();
    }

    public void onCancelBtnClicked(View view) {
        finish();
    }
}
