package com.example.bridgelabz.readandwritetotheexternalfile;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends ActionBarActivity {

    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText1);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void writeFile(View view) {
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state))
        {
            File root = Environment.getExternalStorageDirectory();
            File dir = new File(root.getAbsolutePath()+"/MyAppFile");
            if(!dir.exists())
            {
                dir.mkdir();
            }
            File file = new File(dir,"myFile1.txt");
            String message = editText.getText().toString();
            try {
                FileOutputStream writer = new FileOutputStream(file);
                writer.write(message.getBytes());
                writer.close();
                editText.setText("");
                Toast.makeText(this,"file saved",Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Log.e("File not Found","File not Found hahahaha");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            Toast.makeText(this,"Sd card not found",Toast.LENGTH_SHORT).show();
        }
    }

    public void readFile(View view) {
        String messsage;
        File root = Environment.getExternalStorageDirectory();
        File dir = new File(root.getAbsolutePath()+"/MyAppFile");
        File file = new File(dir,"myFile1.txt");
        try {
            FileInputStream fileStream = new FileInputStream(file);
            InputStreamReader inputStream = new InputStreamReader(fileStream);
            BufferedReader in = new BufferedReader(inputStream);
            StringBuffer buffer = new StringBuffer();
            while ((messsage = in.readLine()) != null)
            {
                buffer.append(messsage+"\n");
            }
            textView.setText(buffer);
            textView.setVisibility(View.VISIBLE);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
